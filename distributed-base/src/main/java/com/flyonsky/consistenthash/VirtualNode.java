package com.flyonsky.consistenthash;

/**
 * 虚拟节点
 * @author flyonsky@gmail.com
 * @param <T> 节点类型
 */
public class VirtualNode<T extends Node> implements Node {
    /** 物理节点 **/
    final T physicalNode;
    /** 虚拟节点索引 **/
    final int replicaIndex;

    public VirtualNode(T physicalNode, int replicaIndex) {
        this.replicaIndex = replicaIndex;
        this.physicalNode = physicalNode;
    }

    @Override
    public String getKey() {
        return physicalNode.getKey() + "-" + replicaIndex;
    }

    /**
     * 是否为指定节点的虚拟节点
     * @param pNode 待判断的节点
     * @return true:虚拟节点,false:非虚拟节点
     */
    public boolean isVirtualNodeOf(T pNode) {
        return physicalNode.getKey().equals(pNode.getKey());
    }

    /**
     * 物理节点
     * @return
     */
    public T getPhysicalNode() {
        return physicalNode;
    }
}
