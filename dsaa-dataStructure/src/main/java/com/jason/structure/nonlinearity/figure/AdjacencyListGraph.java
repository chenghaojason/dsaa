package com.jason.structure.nonlinearity.figure;

import com.jason.structure.nodes.EdgeNode;
import com.jason.structure.nodes.VertexNode;

/**
 * 邻接表图。
 * <pre>
 *     邻接表是图的一种 链式存储方法。
 *     邻接表是由一个顺序存储的顶点表和n个链式存储的边表组成。
 *     其中顶点表由顶点结点组成，边表由边结点组成。
 * </pre>
 *
 * @author WangChenHol
 * @date 2021/6/22 14:46
 **/
public class AdjacencyListGraph<T> implements Graph<T> {
    private final GraphKind kind;  // 图的种类
    private final int vertexNum; // 顶点数
    private final int edgeNum; // 边数
    private VertexNode<T>[] vertexNodes; // 顶点集合
    private int vertexCount = 0; // 当前顶点数
    private int edgeCount = 0; // 当前边数

    public AdjacencyListGraph(GraphKind kind, int vertexNum, int edgeNum) {
        this(kind, vertexNum, edgeNum, null);
        vertexNodes = new VertexNode[vertexNum];
    }

    public AdjacencyListGraph(GraphKind kind, int vertexNum, int edgeNum, VertexNode<T>[] vertexNodes) {
        this.kind = kind;
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        this.vertexNodes = vertexNodes;
        if (vertexNodes != null) {
            for (VertexNode<T> vertexNode : vertexNodes) {
                if (vertexNode != null) {
                    vertexCount++;
                }
            }
        }
    }

    @Override
    public void addVertex(T ver) throws Exception {
        if (vertexNum == vertexCount) {
            throw new Exception("该图顶点已满");
        }
        VertexNode<T> node = new VertexNode<>(ver);
        vertexNodes[vertexCount] = node;
        vertexCount++;
    }

    @Override
    public void addEdge(T ver1, T ver2) throws Exception {
        if (kind == GraphKind.DN || kind == GraphKind.UDN) {
            throw new Exception("不允许在图中添加网边");
        }
        add(ver1, ver2, -1);
    }

    @Override
    public void addEdge(T ver1, T ver2, int weight) throws Exception {
        if (kind == GraphKind.UDG || kind == GraphKind.DG) {
            throw new Exception("不允许在网中添加图的边");
        }
        add(ver1, ver2, weight);
    }

    private void add(T ver1, T ver2, int weight) throws Exception {

        if (ver1 == null || ver2 == null) {
            throw new NullPointerException("添加的边不存在");
        }
        if ((kind == GraphKind.DG || kind == GraphKind.DN) && weight < 1) {
            throw new IllegalArgumentException("边的权重值不合法");
        }
        int p1 = getPositon(ver1);
        int p2 = getPositon(ver2);
        if (p1 < 0 || p2 < 0) {
            throw new Exception("顶点" + ver1 + "或" + ver2 + "不存在");
        }
        createEdge(weight, p1, p2);
        // 如果是无向图或无向网的话，再增加一条反向的边
        if (kind == GraphKind.UDN || kind == GraphKind.UDG) {
            createEdge(weight, p2, p1);
        }
    }

    private void createEdge(int weight, int from, int to) {
        VertexNode<T> reverseVertexNode = vertexNodes[from];
        EdgeNode edgeNode = weight < 0 ? new EdgeNode(to) : new EdgeNode(to, weight);
        edgeNode.nextEdge = reverseVertexNode.firstEdge;
        vertexNodes[from].firstEdge = edgeNode;
        edgeCount++;
    }

    @Override
    public void deleteVertex(T vertex) {
        int index = getPositon(vertex);
        if (vertex == null || index < 0) {
            return;
        }

        for (int i = 0; i < vertexNum; i++) {
            EdgeNode edgeNode = vertexNodes[i].firstEdge;
            if (edgeNode == null) {
                continue;
            }
            if (edgeNode.adjacencyVertex == index) {
                vertexNodes[i].firstEdge = edgeNode.nextEdge;
            } else {
                EdgeNode nextEdge = edgeNode.nextEdge; // 下一个需要判断的边结点
                while (nextEdge != null) {
                    if (nextEdge.adjacencyVertex == index) {
                        edgeNode.nextEdge = nextEdge.nextEdge;
                        break;
                    }
                    edgeNode = nextEdge;
                    nextEdge = nextEdge.nextEdge;
                }
            }
        }
        vertexNodes[index] = null;
    }

    @Override
    public void deleteEdge(T v1, T v2) throws Exception {
        if (v1 == null || v2 == null) {
            throw new Exception("被删除的边不能为空");
        }

        int p1 = getPositon(v1);
        int p2 = getPositon(v2);
        if (p1 < 0 || p2 < 0) {
            throw new Exception("被删除的边不存在");
        }
        delete(p1, p2);
        if (kind == GraphKind.UDG || kind == GraphKind.UDN) {
            delete(p2, p1);
        }
    }

    private void delete(int p1, int p2) throws Exception {
        VertexNode<T> vertexNode = vertexNodes[p1];
        EdgeNode edgeNode = vertexNode.firstEdge;
        if (edgeNode == null) {
            throw new Exception("此边不存在");
        }
        boolean deleteFlag = false;
        if (edgeNode.adjacencyVertex == p2) {
            vertexNodes[p1].firstEdge = edgeNode.nextEdge;
        } else {
            EdgeNode nextEdge = edgeNode.nextEdge;
            while (nextEdge != null) {
                if (nextEdge.adjacencyVertex == p2) {
                    edgeNode.nextEdge = nextEdge.nextEdge;
                    deleteFlag = true;
                    break;
                } else {
                    edgeNode = nextEdge;
                    nextEdge = nextEdge.nextEdge;
                }
            }
        }
        vertexNodes[p1] = vertexNode;
        if (!deleteFlag) {
            throw new NullPointerException("被删除的边不存在");
        }
    }

    @Override
    public int getVertexNum() {
        return vertexNum;
    }

    @Override
    public int getEdgeNum() {
        return edgeNum;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    @Override
    public VertexNode<T> getVertex(int position) throws Exception {
        if (position < 0 || position > vertexNum) {
            throw new Exception("第" + position + "个顶点不存在");
        }
        if (vertexNodes[position] == null) {
            return null;
        }
        return vertexNodes[position];
    }

    @Override
    public int getPositon(T vertex) {
        for (int i = 0; i < vertexNum; i++) {
            if (vertexNodes[i].data.equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int firstAdjacencyVertex(int position) throws Exception {
        if (position < 0 || position > vertexNum) {
            throw new Exception("第" + position + "个顶点不存在");
        }
        VertexNode<T> node = vertexNodes[position];
        if (node.firstEdge != null) {
            return node.firstEdge.adjacencyVertex;
        }
        return -1;
    }

    @Override
    public int nextAdjacencyVertex(T v, T w) throws Exception {
        if (v == null) {
            throw new NullPointerException("请选择顶点");
        }
        int pv = getPositon(v);
        int pw = getPositon(w);
        if (pv < 0) {
            throw new Exception("顶点：" + v + "不存在");
        }
        if (pw < 0) {
            return -1;
        }

        return nextAdjacencyVertex(pv, pw);
    }

    @Override
    public int nextAdjacencyVertex(int start, int from) throws IllegalArgumentException {
        if (start < 0 || start > vertexNum || from > vertexNum) {
            throw new IllegalArgumentException("位置不合法");
        }
        VertexNode<T> vertexNode = vertexNodes[start];
        EdgeNode aim = null;
        for (EdgeNode edgeNode = vertexNode.firstEdge; edgeNode != null; edgeNode = edgeNode.nextEdge) {
            if (edgeNode.adjacencyVertex == from) {
                aim = edgeNode;
                break;
            }
        }
        if (aim != null && aim.nextEdge != null) {
            return aim.nextEdge.adjacencyVertex;
        } else {
            return -1;
        }
    }

    @Override
    public String display() throws Exception {
        StringBuilder builder = new StringBuilder("图/网的邻接表存储展示：\r\n");
        builder.append("顶点序号\t顶点信息\t边\r\n");
        for (int i = 0; i < vertexNum; i++) {
            builder.append("  ").append(i).append("\t\t");
            VertexNode<T> vertexNode = vertexNodes[i];
            if (vertexNode != null) {
                builder.append("  ").append(vertexNode.data); // 打印顶点信息
                if (vertexNode.firstEdge == null) {
                    builder.append(" ^"); // 该顶点无相关联的边
                } else {
                    builder.append("   ");
                    EdgeNode edgeNode = vertexNode.firstEdge;
                    while (edgeNode != null) {
                        builder.append("——>\t"); // 指向下一个边
                        builder.append(getVertex(edgeNode.adjacencyVertex).data);
                        if (kind == GraphKind.DN || kind == GraphKind.UDN) {
                            builder.append(" ").append(edgeNode.value);
                        }
                        builder.append("\t");
                        edgeNode = edgeNode.nextEdge;
                    }
                    builder.append("^");
                }
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

    public GraphKind getKind() {
        return kind;
    }
}
