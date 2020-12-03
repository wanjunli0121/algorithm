package A2_C06_01_FordFulkerson;

public class FlowNetwork {

    private final int V;
    private final Bag<FlowEdge>[] adj;

    public FlowNetwork(int V) {
        this.V = V;
        adj = (Bag<FlowEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<FlowEdge>();
        }
    }

    public void addEdge(FlowEdge e) {
        int v = e.from(), w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

}
