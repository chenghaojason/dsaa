package com.jason.structure.nodes;

/**
 * 图的边结点
 *
 * @author WangChenHol
 * @date 2021/6/22 14:28
 **/
public class EdgeNode {
    public int adjacencyVertex; // 该边所指向的顶点在顶点表中的位置
    public int value; // 边的权值
    public EdgeNode nextEdge; // 指向下一条边，也就是当前顶点的其它边

    public EdgeNode() {
        this(-1, 0, null);
    }

    public EdgeNode(int adjacencyVertex) {
        this(adjacencyVertex, 0, null);
    }

    public EdgeNode(int adjacencyVertex, int value) {
        this(adjacencyVertex, value, null);
    }

    public EdgeNode(int adjacencyVertex, int value, EdgeNode nextEdge) {
        this.adjacencyVertex = adjacencyVertex;
        this.value = value;
        this.nextEdge = nextEdge;
    }
}
