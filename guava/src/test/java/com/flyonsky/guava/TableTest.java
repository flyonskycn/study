package com.flyonsky.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

/**
 * @author luowengang
 * @date 2020/9/24 21:37
 */
public class TableTest {

    @Test
    public void testTable(){
        Table<String, String, Integer> table = HashBasedTable.create();

        table.put("a", "b", 100);
        table.put("a", "c", 1000);
        table.put("c", "b", 5000);

        System.out.println(table.row("a"));

        System.out.println(table.column("b"));
    }
}
