package com.jason.structure.linearity.nonlinearity;

import com.jason.structure.nonlinearity.figure.AdjacencyMatrixGraph;
import com.jason.structure.nonlinearity.figure.GraphKind;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

/**
 * 网和图测试
 *
 * @author WangChenHol
 * @date 2021/6/21 14:37
 **/
public class TestGraph {

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
        directedGraph.deleteEdge("D","F");
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
}
