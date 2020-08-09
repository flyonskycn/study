package com.flyonsky.consistenthash;

/**
 * @author flyonskycn@gmail.com
 * 代表被映射到hash环上的节点
 */
public interface Node {
    /**
     * 节点的键值
     * @return 键值
     */
    String getKey();
}
