package A2_C05_02_AcyclicSP;

public class Topological {

    private Iterable<Integer> order;

    public Topological(EdgeWeightedDigraph G) {
        DepthFirstOrder dfs = new DepthFirstOrder(G);
        order = dfs.reversePost();
    }

    public Iterable<Integer> order() {
        return order;
    }

}
