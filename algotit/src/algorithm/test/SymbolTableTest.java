package algorithm.test;

import algorithm.symbol.SymbolTable;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 14:46
 **/
public class SymbolTableTest {

    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();

        symbolTable.put(1, "a");
        symbolTable.put(2, "b");
        symbolTable.put(3, "c");

        System.out.println("插入完毕后元素的个数为: " + symbolTable.size());

        symbolTable.put(2, "d");
        System.out.println("替换完毕后元素的个数为: " + symbolTable.size());

        String s = symbolTable.get(2);
        System.out.println("替换完毕后，键2对应元素值为: " + s);

        symbolTable.delete(2);
        System.out.println("删除完毕后元素的个数为: " + symbolTable.size());

    }
}
