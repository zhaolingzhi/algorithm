package template;


interface UnionFind {
    int find(int v);
    void union(int u, int v);
    boolean isConnect(int u, int v);
}

abstract class AbstractUnionFind implements UnionFind {
    int[] parents;
    int size;


    public AbstractUnionFind(int size) {
        this.size = size;
        parents = new int[size];
        for (int i = 0; i < size; i++){
            parents[i] = i;
        }
    }

    @Override
    public abstract int find(int v);

    @Override
    public abstract void union(int u, int v);

    @Override
    public boolean isConnect(int u, int v) {
        return find(u) == find(v);
    }
}


class UnionFindQuickUnion extends AbstractUnionFind {

    public UnionFindQuickUnion(int size) {
        super(size);
    }

    @Override
    public int find(int v) {
        int parent = parents[v];
        while (parent != parents[parent]){
            parent = parents[parent];
        }
        return parent;
    }

    @Override
    public void union(int u, int v) {
        int firstParent = find(u);
        int secondParent = find(v);
        if (firstParent != secondParent){
            parents[secondParent] = firstParent;
        }
    }
}

/**
 * 秩
 */
class UnionFindUseRank extends AbstractUnionFind{
    private int[] rank;

    public UnionFindUseRank(int size) {
        super(size);
        rank = new int[size];
    }

    @Override
    public int find(int v) {
        int parent = parents[v];
        while (parent != parents[parent]){
            parent = parents[parent];
        }
        return parent;
    }

    @Override
    public void union(int u, int v) {
        int firstParent = find(u);
        int secondParent = find(v);
        if (firstParent == secondParent) return;
        if (rank[firstParent] < rank[secondParent]){
            parents[firstParent] = secondParent;
        }else if (rank[firstParent] > rank[secondParent]){
            parents[secondParent] = firstParent;
        }else {
            parents[secondParent] = firstParent;
            rank[firstParent] ++;
        }
    }
}


/**
 * 秩+路径压缩
 */
class UnionFindUseRankAndCompress extends UnionFindUseRank{
    public UnionFindUseRankAndCompress(int size) {
        super(size);
    }

    @Override
    public int find(int v) {
        int parent = parents[v];
        while (parent != parents[parent]){
            parent = parents[parent];
        }
        int root = parent;
        int t = v;
        while (parents[t] != root){
            int x = parents[t];
            parents[t] = root;
            t = x;
        }
        return parent;
    }
}

public class 并查集 {

}
