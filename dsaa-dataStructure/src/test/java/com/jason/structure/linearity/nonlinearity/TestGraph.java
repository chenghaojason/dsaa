package com.jason.structure.linearity.nonlinearity;

import com.jason.structure.nonlinearity.figure.AdjacencyListGraph;
import com.jason.structure.nonlinearity.figure.AdjacencyMatrixGraph;
import com.jason.structure.nonlinearity.figure.GraphKind;
import org.junit.Test;

/**
 * 网和图测试
 *
 * @author WangChenHol
 * @date 2021/6/21 14:37
 **/
public class TestGraph {

    // 测试图的邻接矩阵存储
    @Test
    public void testAdjacencyMatrixGraph() throws Exception {
        // 无向图
        AdjacencyMatrixGraph<Integer> undirectedGraph = new AdjacencyMatrixGraph<>(GraphKind.UDG, 5, 5);
        undirectedGraph.addVertex(0);
        undirectedGraph.addVertex(1);
        undirectedGraph.addVertex(2);
        undirectedGraph.addVertex(3);
        undirectedGraph.addVertex(4);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(1, 4);
        System.out.println(undirectedGraph.display());
//        undirectedGraph.deleteEdge(1,2);
//        System.out.println(undirectedGraph.display());

        // 有向图
        AdjacencyMatrixGraph<String> directedGraph = new AdjacencyMatrixGraph<>(GraphKind.DG, 5, 5);
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addVertex("D");
        directedGraph.addVertex("E");
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "C");
        directedGraph.addEdge("C", "D");
        directedGraph.addEdge("D", "A");
        directedGraph.addEdge("D", "E");
        System.out.println(directedGraph.display());
        directedGraph.deleteEdge("D", "F");
        System.out.println(directedGraph.display());

        // 无向网
        AdjacencyMatrixGraph<String> undirectedNetwork = new AdjacencyMatrixGraph<>(GraphKind.UDN, 6, 6);
        undirectedNetwork.addVertex("A");
        undirectedNetwork.addVertex("B");
        undirectedNetwork.addVertex("C");
        undirectedNetwork.addVertex("D");
        undirectedNetwork.addVertex("E");
        undirectedNetwork.addVertex("F");
        undirectedNetwork.addEdge("C", "A", 2);
        undirectedNetwork.addEdge("A", "B", 10);
        undirectedNetwork.addEdge("B", "D", 7);
        undirectedNetwork.addEdge("B", "F", 5);
        undirectedNetwork.addEdge("D", "E", 2);
        undirectedNetwork.addEdge("E", "F", 5);
        System.out.println(undirectedNetwork.display());

        // 有向网
        AdjacencyMatrixGraph<String> directedNetwork = new AdjacencyMatrixGraph<>(GraphKind.DN, 4, 5);
        directedNetwork.addVertex("A");
        directedNetwork.addVertex("B");
        directedNetwork.addVertex("C");
        directedNetwork.addVertex("D");
        directedNetwork.addEdge("A", "B", 1);
        directedNetwork.addEdge("A", "C", 4);
        directedNetwork.addEdge("C", "D", 7);
        directedNetwork.addEdge("D", "C", 4);
        directedNetwork.addEdge("D", "A", 6);
        System.out.println(directedNetwork.display());
        System.out.println(directedNetwork.getPositon("B"));
//        directedNetwork.deleteVertex("A");
        System.out.println(directedNetwork.display());
    }

    // 测试图的邻接表存储
    @Test
    public void testAdjacencyListGraph() throws Exception {

        // 无向图
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(GraphKind.UDG, 5, 5);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);

//        graph.deleteVertex(1);
//        graph.deleteEdge(2, 1);
        System.out.println(graph.display());

        // 有向图
        AdjacencyListGraph<String> directedGraph = new AdjacencyListGraph<>(GraphKind.DG, 5, 5);
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addVertex("D");
        directedGraph.addVertex("E");

        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "C");
        directedGraph.addEdge("C", "D");
        directedGraph.addEdge("D", "A");
        directedGraph.addEdge("D", "E");
        System.out.println(directedGraph.display());
//        directedGraph.deleteVertex("A");
        directedGraph.deleteEdge("C", "D");
        System.out.println(directedGraph.display());

    }

    /**
     * 测试无向网的邻接表存储操作
     */
    @Test
    public void testAdjacencyListGraphUndirectedNetwork() throws Exception {
        AdjacencyListGraph<String> network = new AdjacencyListGraph<>(GraphKind.UDN, 6, 9);
        network.addVertex("A");
        network.addVertex("B");
        network.addVertex("C");
        network.addVertex("D");
        network.addVertex("E");
        network.addVertex("F");
        network.addEdge("A", "B", 2);
        network.addEdge("A", "C", 7);
        network.addEdge("B", "C", 10);
        network.addEdge("B", "D", 9);
        network.addEdge("B", "E", 5);
        network.addEdge("C", "D", 1);
        network.addEdge("D", "E", 3);
        network.addEdge("D", "F", 8);
        network.addEdge("E", "F", 4);
        System.out.println(network.display());
//        network.deleteVertex("B");
//        network.deleteEdge("D", "C");
        System.out.println(network.display());
        System.out.println(network.firstAdjacencyVertex(2));
        System.out.println("总顶点数：" + network.getVertexCount() + "   总边数：" + network.getEdgeCount());
        System.out.println("顶点数：" + network.getVertexNum() + "   边数：" + network.getEdgeNum());
        System.out.println("查找在顶点B中邻接点D的下一个邻接点：" + network.nextAdjacencyVertex("B", "D"));
    }

    /**
     * 测试有向网的邻接表存储的操作
     */
    @Test
    public void testAdjacencyListGraphDirectedNetwork() throws Exception {
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>(GraphKind.DN, 6, 7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "E", 2);
        graph.addEdge("D", "B", 4);
        graph.addEdge("E", "D", 8);
        graph.addEdge("E", "F", 7);
        graph.addEdge("F", "D", 9);
        System.out.println(graph.display());
//        graph.deleteVertex("D");
        graph.deleteEdge("E", "B");
        System.out.println(graph.display());

    }


}
