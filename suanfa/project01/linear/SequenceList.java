package linear;

import java.util.Iterator;

/**
 * @Author zhourui
 * @Date 2020/8/14 15:48
 */
public class SequenceList<T> implements Iterable<T> {

    // 存储元素的数组
    private T[] eles;
    // 记录当前顺序表中的元素个数
    private int N;

    public SequenceList(int capacity) {
        // 初始化数组
        this.eles = (T[]) new Object[capacity];
        // 初始化长度
        this.N = 0;
    }

    // 清空表
    public void clear() {
        this.N = 0;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 获取线性表的长度
    public int length() {
        return N;
    }

    // 获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    // 插入元素
    public void insert(T t){
        eles[N++] = t;
    }

    // 指定位置插入元素
    public void insert(int i, T t) {
        // 先把i索引处的元素及其后面的元素依次向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index-1];
        }
        // 再把t元素放到i索引处即可
        eles[i] = t;

        // 将元素个数+1
        N++;
    }

    // 删除指定i索引处的元素，并返回该元素
    public T remove(int i) {
        // 记录i索引处的值
        T current = eles[i];
        // 索引i后面元素依次向前移动一位即可
        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }

        // 元素个数-1
        N--;
        return current;
    }

    // 查找t元素第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i] == t) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {

        private int cursor;
        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public java.lang.Object next() {
            return eles[cursor++];
        }
    }
}
