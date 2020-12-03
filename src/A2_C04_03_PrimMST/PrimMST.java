/*
Start with vertex 0 and greedily grow tree T.
Add to T the min weight edge with exactly one endpoint in T.
Repeat until V-1 Edges.
*/

package A2_C04_03_PrimMST;

public class PrimMST {

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                prim(G, v);
            }
        }
    }

    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e: G.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) {
                if (e.weight() < distTo[w]) {
                    edgeTo[w] = e;
                    distTo[w] = e.weight();
                    if (pq.contains(w)) {
                        pq.decreaseKey(w, distTo[w]);
                    } else {
                        pq.insert(w, distTo[w]);
                    }
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e: edges()) {
            weight += e.weight();
        }
        return weight;
    }

}
