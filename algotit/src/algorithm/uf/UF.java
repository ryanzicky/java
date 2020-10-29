package algorithm.uf;

/**
 * 并查集
 *
 * @Author: zhourui
 * @Date: 2020-10-26 15:59
 **/
public class UF {

    private int[] eleAndGroup;
    private int count;

    public UF(int N) {
        // 初始化分组的数量,默认情况下有N个分组
        this.count = N;

        // 初始化eleAndGroup数组
        this.eleAndGroup = new int[N];

        // 初始化eleAndGroup中的元素及其所在组的标识符,让eleAndGroup数组的索引作为并查集的每个节点的元素
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }


    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return eleAndGroup[p];
    }

    // 判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        // 判断元素p和q是否在同一分组中
        if (connected(p, q)) {
            return;
        }

        // 找到p所在分组的标识符
        int pGroup = find(p);

        // 找到q所在分组的标识符
        int qGroup = find(q);

        // 合并组: 让p所在组的所有元素的组标识符变为q所在分组的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        // 分组-1
        count--;
    }
}
