package algorithm.uf;

/**
 * @Author: zhourui
 * @Date: 2020-10-27 10:37
 **/
public class UF_Tree_Weighted {

    private int[] eleAndGroup;
    private int count;
    // 用来存储每一个根节点对应的树中保存的节点的个数
    private int[] sz;

    public UF_Tree_Weighted(int N) {
        this.count = N;

        this.eleAndGroup = new int[N];

        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }

        this.sz = new int[N];
        // 默认情况下,sz中每个索引处的值都是1
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
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

        // 判断pRoot对应的树大还是qRoot对应的树大，把较小的树合并到较大的树中
        if (sz[pRoot] < sz[qRoot]) {
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        // 组的数量-1
        this.count--;
    }
}
