package algorithm.test;

import algorithm.symbol.OrderSymbolTable;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 15:01
 **/
public class OrderSymbolTableTest {

    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();

        table.put(1, "a");
        table.put(2, "b");
        table.put(4, "c");
        table.put(7, "d");

        table.put(3, "e");



    }
}
