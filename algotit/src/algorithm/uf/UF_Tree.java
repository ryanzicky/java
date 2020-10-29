package algorithm.uf;

/**
 * @Author: zhourui
 * @Date: 2020-10-27 10:37
 **/
public class UF_Tree {

    private int[] eleAndGroup;
    private int count;

    public UF_Tree(int N) {
        this.count = N;

        this.eleAndGroup = new int[N];

        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (true) {
            if (p == eleAndGroup[p]) {
                return p;
            }

            p = eleAndGroup[p];
        }
    }

    public void union(int p, int q) {
        // 找到p元素和q元素所在组对应的树的根节点
        int pRoot = find(p);
        int qRoot = find(q);

        // 如果p和q在同一分组，就不需要合并
        if (pRoot == qRoot) {
            return;
        }

        // 让p所在的树的根节点的父节点变为q所在树的根节点即可
        eleAndGroup[pRoot] = qRoot;

        // 组的数量-1
        this.count--;
    }
}
