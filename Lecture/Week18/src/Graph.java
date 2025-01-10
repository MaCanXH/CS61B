public interface Graph {
    /**
     * add an edge v-w
     */
    public void addEdge(int v, int w);
    /**
     * vertices adjacent to V
     */
    Iterable<Integer> adj(int v);

    /**
     * number of veritces
     */
    int V();

    /**
     * number of edges
     */
    int E();
}
