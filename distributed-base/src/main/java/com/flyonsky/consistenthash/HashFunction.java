package com.flyonsky.consistenthash;

/**
 * @author flyonskycn@gmail.com
 *
 * Hash 函数数，将String类型的键转换为对应的long值
 */
public interface HashFunction {
    /**
     * hash函数实现
     * @param key 键值
     * @return 键值的long表示
     */
    long hash(String key);
}
