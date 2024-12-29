public class QuickFIndDS implements DisjointSets {
    private int[] id;

    /* O(N) */
    public QuickFIndDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /* need to iterate through the array => 0(N) */
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /* O(1)*/
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}