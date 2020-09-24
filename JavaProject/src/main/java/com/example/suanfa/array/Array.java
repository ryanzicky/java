package com.example.suanfa.array;

/**
 * @Author zhourui
 * @Date 2019/10/23 9:32
 */
public class Array<T> {

    private T[] data;
    private int size;

    // 有参构造函数
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造函数
    public Array() {
        this(10);
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 添加以为元素到最后位置
    public void addLast(T e) {
        add(size, e);
    }

    // 在第index位置插入一个元素e
    public void add(int index, T e) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. index is error.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // 数组是否包含元素
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 找到元素对应索引
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 删除索引元素
    public T remove(int index) {
        if (size == 0) {
            throw new IllegalArgumentException("add failed. Array is empty.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. index error.");
        }
        T tmp = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length / 4 && size >= 10) {
            resize(data.length / 2);
        }
        return tmp;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 删除元素e
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 数组扩容
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int getCapacity() {
        return size;
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. index is error.");
        }
        return data[index];
    }
}
