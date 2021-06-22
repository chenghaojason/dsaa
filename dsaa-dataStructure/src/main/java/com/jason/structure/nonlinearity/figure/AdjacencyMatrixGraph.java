package com.jason.structure.nonlinearity.figure;

import java.util.Arrays;

/**
 * 邻接矩阵存储图
 *
 * @author WangChenHol
 * @date 2021/6/20 9:22
 **/
public class AdjacencyMatrixGraph<T> implements Graph<T> {

    public final static int INFINITY = Integer.MAX_VALUE;
    private final GraphKind kind; // 图的种类
    private final int vertexNum; // 图的顶点数
    private final int edgeNum; // 图的边数
    private final int undirectedMaxEdgeNum; // 无向图的最大边数
    private final int directedMaxEdgeNum; // 有向图的最大变数
    private final T[] vertexs; // 顶点
    private final int[][] adjacencyMatrix; // 邻接矩阵
    private int vertexCount; // 目前的顶点数量
    private int edgeCount; // 统计目前边的数量

    public AdjacencyMatrixGraph(GraphKind kind, int vertexNum, int edgeNum) throws Exception {
        this(kind, vertexNum, edgeNum, null, null);
    }

    public AdjacencyMatrixGraph(GraphKind kind, int vertexNum, int edgeNum, T[] vertexs, int[][] adjacencyMatrix) throws Exception {
        if (kind == null) {
            throw new Exception("请选择创建图的类型");
        }
        if (vertexNum < 1) {
            throw new Exception("顶点必须大于0");
        }
        this.kind = kind;
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        this.vertexCount = 0;
        this.edgeCount = 0;
        this.undirectedMaxEdgeNum = vertexNum * (vertexNum - 1) / 2;
        this.directedMaxEdgeNum = vertexNum * (vertexNum - 1);
        if (vertexs == null) {
            this.vertexs = (T[]) new Object[vertexNum];
        } else {
            this.vertexs = vertexs;
            vertexCount = vertexNum;
        }
        this.adjacencyMatrix = adjacencyMatrix == null ? new int[vertexNum][vertexNum] : adjacencyMatrix;
    }


    /**
     * 添加顶点
     *
     * @param ver 顶点
     * @throws Exception 当顶点满了报异常
     */
    public void addVertex(T ver) throws Exception {
        if (vertexCount == vertexNum) {
            throw new Exception("顶点已满");
        }
        vertexs[vertexCount] = ver;
        vertexCount++;
    }

    /**
     * 给图创建边
     *
     * @param ver1 顶点1
     * @param ver2 顶点2
     * @throws Exception 异常
     */
    public void addEdge(T ver1, T ver2) throws Exception {
        if (ver1.equals(ver2)) {
            throw new Exception("同一个顶点不能创建边");
        }
        boolean flag = (kind == GraphKind.UDG && edgeCount == undirectedMaxEdgeNum) || (kind == GraphKind.DG && edgeCount == directedMaxEdgeNum);
        if (kind == GraphKind.UDN || kind == GraphKind.DN || flag) {
            throw new Exception("图的边数已到最大值");
        }
        int index1 = Arrays.binarySearch(vertexs, ver1);
        int index2 = Arrays.binarySearch(vertexs, ver2);
        if (index1 < 0 || index2 < 0) {
            throw new Exception("图的边创建失败，不存在的顶点");
        }
        adjacencyMatrix[index1][index2] = 1;
        if (kind == GraphKind.UDG) {
            adjacencyMatrix[index2][index1] = 1;
        }
        edgeCount++;
    }

    /**
     * 给网创建边
     *
     * @param ver1   顶点1
     * @param ver2   顶点2
     * @param weight 权重
     * @throws Exception 异常
     */
    public void addEdge(T ver1, T ver2, int weight) throws Exception {
        if (ver1.equals(ver2)) {
            throw new Exception("同一个顶点不能创建边");
        }
        boolean flag = (kind == GraphKind.UDN && edgeCount == undirectedMaxEdgeNum) || (kind == GraphKind.DN && edgeCount == directedMaxEdgeNum);
        if (kind == GraphKind.UDG || kind == GraphKind.DG || flag) {
            throw new Exception("图的边数已到最大值");
        }
        int index1 = Arrays.binarySearch(vertexs, ver1);
        int index2 = Arrays.binarySearch(vertexs, ver2);
        if (index1 < 0 || index2 < 0) {
            throw new Exception("网的边创建失败，不存在的顶点");
        }
        adjacencyMatrix[index1][index2] = weight;
        if (kind == GraphKind.UDN) {
            adjacencyMatrix[index2][index1] = weight;
        }
        edgeCount++;
    }

    /**
     * 删除顶点。
     * 同时删除与该顶点有关的所有边。
     *
     * @param vertex 顶点
     */
    public void deleteVertex(T vertex) {
        if (vertex == null) return;
        int index = -1;
        for (int i = 0; i < vertexNum; i++) {
            if (vertex.equals(vertexs[i])) {
                vertexs[i] = null;
                index = i;
            }
        }
        vertexCount--;
        for (int j = 0; j < vertexNum; j++) {
            if (index == j) {
                for (int k = 0; k < vertexNum; k++) {
                    if (adjacencyMatrix[j][k] != 0) {
                        adjacencyMatrix[j][k] = 0;
                        edgeCount--;
                    }
                }
            }
            if (adjacencyMatrix[j][index] != 0) {
                adjacencyMatrix[j][index] = 0;
                edgeCount--;
            }
        }
    }

    /**
     * 删除边。如果是无向的，则删除反向边，如果是有向的，则只删除一条边
     *
     * @param v1 顶底1
     * @param v2 顶点2
     */
    public void deleteEdge(T v1, T v2) throws Exception {
        if (v1 == null || v2 == null) {
            return;
        }
        int p1 = Arrays.binarySearch(vertexs, v1);
        int p2 = Arrays.binarySearch(vertexs, v2);
        if (p1 < 0 || p2 < 0) {
            throw new Exception("边 " + v1 + "——" + v2 + " 不存在");
        }
        adjacencyMatrix[p1][p2] = 0;
        if (kind == GraphKind.UDG || kind == GraphKind.UDN) {
            adjacencyMatrix[p2][p1] = 0;
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

    @Override
    public T getVertex(int position) throws Exception {
        if (position < 0 || position > vertexNum) {
            throw new Exception("第" + position + "个顶点不存在");
        }
        return vertexs[position];
    }

    /**
     * 该算法的时间复杂度是O(n)
     *
     * @param vertex 顶点值
     * @return -1：图中没有此顶点
     */
    @Override
    public int getPositon(T vertex) {
        for (int i = 0; i < vertexNum; i++) {
            if (vertex.equals(vertexs[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找position位置的第一个邻接点
     *
     * @param position 顶点 0 <= position <vertexNum
     * @return -1：表示无邻接点
     * @throws Exception 异常
     */
    @Override
    public int firstAdjacencyVertex(int position) throws Exception {
        if (position < 0 || position > vertexNum) {
            throw new Exception("第" + position + "个顶点不存在");
        }
        for (int i = 0; i < vertexNum; i++) {
            if (adjacencyMatrix[position][i] != 0 && adjacencyMatrix[position][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int nextAdjacencyVertex(T v, T w) throws Exception {
        int i = Arrays.binarySearch(vertexs, v);
        int j = Arrays.binarySearch(vertexs, w);
        if (i < 0) {
            throw new Exception("顶点" + v.toString() + "不存在");
        }
        for (int k = j + 1; k < vertexNum; k++) {
            if (adjacencyMatrix[i][k] != 0 && adjacencyMatrix[i][k] < INFINITY) {
                return k;
            }
        }
        return -1;
    }

    @Override
    public String display() {
        if (vertexNum == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder("邻接矩阵形式的");
        builder.append(kind.kindDec).append(":\r\n");
        for (int i = 0; i < vertexNum; i++) {
            builder.append("\t").append(vertexs[i] == null ? " " : vertexs[i]);
        }
        builder.append("\r\n");
        for (int j = 0; j < vertexNum; j++) {
            builder.append(vertexs[j] == null ? " " : vertexs[j]);
            for (int k = 0; k < vertexNum; k++) {
                int value = adjacencyMatrix[j][k];
                if ((kind == GraphKind.DN || kind == GraphKind.UDN) && value == 0) {
                    builder.append("\t").append("*");
                } else {
                    builder.append("\t").append(value);
                }
            }
            builder.append("\r\n");
        }
        builder.append("\r\n");
        return builder.toString();
    }

    public GraphKind getKind() {
        return kind;
    }

    public T[] getVertexs() {
        return vertexs;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }
}
