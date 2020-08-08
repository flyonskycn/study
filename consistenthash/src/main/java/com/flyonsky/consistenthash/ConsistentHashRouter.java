package com.flyonsky.consistenthash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash路由实现类
 * @author flyonsky@gmail.com
 *
 * @param <T>
 */
public class ConsistentHashRouter<T extends Node> {
    /** hash环 **/
    private final SortedMap<Long, VirtualNode<T>> ring = new TreeMap<>();
    /** hash函数 **/
    private final HashFunction hashFunction;

    /**
     * 构造函数
     * @param pNodes 物理节点集合
     * @param vNodeCount 每个物理节点的虚拟节点数
     */
    public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount) {
        this(pNodes,vNodeCount, new MD5Hash());
    }

    /**
     * 构造函数
     * @param pNodes 物理节点集合
     * @param vNodeCount 每个物理节点的虚拟节点数
     * @param hashFunction hash函数
     */
    public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount, HashFunction hashFunction) {
        if (hashFunction == null) {
            throw new NullPointerException("Hash Function is null");
        }
        this.hashFunction = hashFunction;
        if (pNodes != null) {
            for (T pNode : pNodes) {
                addNode(pNode, vNodeCount);
            }
        }
    }

    /**
     * 添加物理节点并添加对应的虚拟节点
     * @param pNode 物理节点
     * @param vNodeCount 虚拟节点数量
     */
    public void addNode(T pNode, int vNodeCount) {
        if (vNodeCount < 0){
            throw new IllegalArgumentException("illegal virtual node counts :" + vNodeCount);
        }
        int existingReplicas = getExistingReplicas(pNode);
        for (int i = 0; i < vNodeCount; i++) {
            VirtualNode<T> vNode = new VirtualNode<>(pNode, i + existingReplicas);
            ring.put(hashFunction.hash(vNode.getKey()), vNode);
        }
    }

    /**
     * 删除对应的节点包括虚拟节点
     * @param pNode 删除除的节点
     */
    public void removeNode(T pNode) {
        Iterator<Long> it = ring.keySet().iterator();
        while (it.hasNext()) {
            Long key = it.next();
            VirtualNode<T> virtualNode = ring.get(key);
            if (virtualNode.isVirtualNodeOf(pNode)) {
                it.remove();
            }
        }
    }

    /**
     * 根据对象key找到对应的物理节点
     * @param objectKey 对像key
     * @return
     */
    public T routeNode(String objectKey) {
        if (ring.isEmpty()) {
            return null;
        }
        Long hashVal = hashFunction.hash(objectKey);
        SortedMap<Long,VirtualNode<T>> tailMap = ring.tailMap(hashVal);
        Long nodeHashVal = !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
        return ring.get(nodeHashVal).getPhysicalNode();
    }

    /**
     * 获取指定节点的虚拟节点数量
     * @param pNode 节点
     * @return 虚拟节点数
     */
    public int getExistingReplicas(T pNode) {
        int replicas = 0;
        for (VirtualNode<T> vNode : ring.values()) {
            if (vNode.isVirtualNodeOf(pNode)) {
                replicas++;
            }
        }
        return replicas;
    }

    /**
     * 默认的MD5 hash实现
     */
    private static class MD5Hash implements HashFunction {
        MessageDigest instance;

        public MD5Hash() {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
        }

        @Override
        public long hash(String key) {
            instance.reset();
            instance.update(key.getBytes());
            byte[] digest = instance.digest();

            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }
            return h;
        }
    }

}
