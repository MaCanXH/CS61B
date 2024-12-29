public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    private int root(int p){
        while (parent[p] != -1) {
            p = parent[p];
        }
        return p;
    }
    @Override
    public void connect(int p, int q) {
        int i = root(p);
        int j = root(q);
        parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(q) == root(p);
    }
}
