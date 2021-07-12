package com.jason.structure.nonlinearity.figure;


import com.jason.structure.linearity.queue.LinkedQueue;

/**
 * 图的常用方法。
 * <pre>
 *     图的遍历分两种：
 *          1.广度优先搜索 breadth first search （BFS）
 *          2.深度优先搜索 depth first search （DFS）
 *     这两种搜索适用于有向图和无向图。
 * </pre>
 *
 * @author WangChenHol
 * @date 2021/6/28 14:11
 **/
public class GraphUtil {

    /**
     * 图的广度优先搜索，适用于有向图、无向图、有向网、无向网。
     *
     * @param graph 图
     * @return 返回搜索的结果
     * @throws Exception 异常
     */
    public static String breadthFirstSearch(Graph<?> graph) throws Exception {
        if (graph == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[graph.getVertexNum()]; // 访问标志数组 默认每个元素值都是false
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < graph.getVertexNum(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.offer(i);
                builder.append(graph.getVertex(i).data).append(" ");
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    for (int index = graph.firstAdjacencyVertex(poll); index >= 0; index = graph.nextAdjacencyVertex(poll, index)) {
                        if (!visited[index]) {
                            queue.offer(index);
                            visited[index] = true;
                            builder.append(graph.getVertex(index).data).append(" ");
                        }
                    }
                }
            }
        }
        return builder.toString();
    }

    /**
     * 图的深度优先搜索。
     *
     * @param graph 图
     * @return 搜索结果
     * @throws Exception 异常
     */
    public static String depthFirstSearch(Graph<?> graph) throws Exception {
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[graph.getVertexNum()];

        for (int v = 0; v < graph.getVertexNum(); v++) {
            if (!visited[v]) {
                DFS(graph, visited, v, builder);
            }
        }
        return builder.toString();
    }

    private static void DFS(Graph<?> graph, boolean[] visited, int v, StringBuilder builder) throws Exception {
        visited[v] = true;
        builder.append(graph.getVertex(v).data).append(" ");
        for (int w = graph.firstAdjacencyVertex(v); w > 0; w = graph.nextAdjacencyVertex(v, w)) {
            if (!visited[w]) {
                DFS(graph, visited, w, builder);
            }
        }
    }


}
