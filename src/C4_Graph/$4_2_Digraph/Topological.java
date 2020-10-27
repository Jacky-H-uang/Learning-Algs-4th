package C4_Graph.$4_2_Digraph;


import C4_Graph.$4_4_ShortestPath.EdgeWeightedDigraph;

/**
 * 拓扑排序 ： 给定一副有向图，将所有顶点排序，使得所有的有向边均从排在前面的元素指向排在后面的元素
 *          (注意：只有无环的有向图才有拓扑排序)
 */

public class Topological
{
    private Iterable<Integer> order;        // 顶点的拓扑排序

    public Topological(EdgeWeightedDigraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    // 返回所有顶点的逆后序排序   --(即拓扑排序)
    public Iterable<Integer> order() {
        return order;
    }

    // DAG : 有向无环图
    public boolean isDAG() {
        return order != null;
    }
}