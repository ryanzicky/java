package com.example.suanfa.stack1;

import com.example.suanfa.array.Array;

/**
 * @Author zhourui
 * @Date 2019/10/23 15:20
 */
public class ArrayStack<T> implements Stack {

    Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(Object o) {
        array.addLast((T) o);
    }

    @Override
    public Object pop() {
        return array.removeLast();
    }

    @Override
    public Object peek() {
        return array;
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: ");
        stringBuilder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
