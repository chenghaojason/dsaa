package com.jason.structure.nodes;

/**
 * 图的顶点结点
 *
 * @author WangChenHol
 * @date 2021/6/22 14:26
 **/
public class VertexNode<V> {
    public V data; // 顶点的值
    public EdgeNode firstEdge; // 指向第一条依附于该顶点的边

    public VertexNode() {
        this(null, null);
    }

    public VertexNode(V data) {
        this(data, null);
    }

    public VertexNode(V data, EdgeNode firstEdge) {
        this.data = data;
        this.firstEdge = firstEdge;
    }
}
