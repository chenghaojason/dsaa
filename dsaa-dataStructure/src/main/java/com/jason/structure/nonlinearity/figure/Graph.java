package com.jason.structure.nonlinearity.figure;

/**
 * 图的接口.
 * <pre>
 *     图的存储有：
 *          1.邻接矩阵 AdjacencyMatrixGraph （其中无向图和无向网的邻接矩阵是对称矩阵，一般采用压缩存储；有向图和有向网的邻接矩阵不对称）。
 *          2.邻接表。 AdjacencyListGraph
 *          3.邻接多重表。
 *          4.十字链表。
 * </pre>
 *
 * @author WangChenHol
 * @date 2021/6/18 14:25
 **/
public interface Graph<T> {

    /**
     * 添加一个顶点
     *
     * @param ver 顶点
     * @throws Exception 异常
     */
    void addVertex(T ver) throws Exception;

    /**
     * 添加一个不带权值的边（图）。
     *
     * @param ver1 顶点1
     * @param ver2 顶点2
     * @throws Exception 异常
     */
    void addEdge(T ver1, T ver2) throws Exception;

    /**
     * 添加一个带权值的边（网）。
     *
     * @param ver1   顶点1
     * @param ver2   顶点2
     * @param weight 权值
     * @throws Exception 异常
     */
    void addEdge(T ver1, T ver2, int weight) throws Exception;

    /**
     * 删除一个顶点，并删除与该顶点有关的边
     *
     * @param vertex 顶点
     */
    void deleteVertex(T vertex);

    /**
     * 删除一条边，如果是无向图、网，则同时删除反向的边。
     *
     * @param v1 顶点1
     * @param v2 顶点2
     * @throws Exception 异常
     */
    void deleteEdge(T v1, T v2) throws Exception;

    /**
     * 返回图中的顶点数量
     *
     * @return 顶点数量
     */
    int getVertexNum();

    /**
     * 获取图的边数
     *
     * @return 边数
     */
    int getEdgeNum();

    /**
     * 根据给定顶点的位置position，返回其在图中的顶点值
     *
     * @param position 位置信息，0 <= position <vertexNum
     * @return 顶点值
     * @throws Exception 位置不合法异常
     */
    T getVertex(int position) throws Exception;

    /**
     * 求某个顶点值在图中的位置
     *
     * @param vertex 顶点值
     * @return 位置
     */
    int getPositon(T vertex);

    /**
     * 返回position的第一个邻接点，如没有邻接点，则返回-1
     *
     * @param position 顶点 0 <= position <vertexNum
     * @return 邻接点
     */
    int firstAdjacencyVertex(int position) throws Exception;

    /**
     * 返回v相对于w的下一个邻接点，如没有邻接点，则返回-1
     *
     * @param v 顶点
     * @param w 顶点
     * @return 邻接点
     */
    int nextAdjacencyVertex(T v, T w) throws Exception;

    /**
     * 展示输出
     */
    String display() throws Exception;

}
