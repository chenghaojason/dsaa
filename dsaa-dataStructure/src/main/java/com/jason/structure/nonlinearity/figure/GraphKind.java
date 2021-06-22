package com.jason.structure.nonlinearity.figure;

/**
 * @author WangChenHol
 * @date 2021/6/18 15:51
 **/
public enum GraphKind {
    UDG("Undirected Graph", "无向图"),
    DG("Directed Graph", "有向图"),
    UDN("Undirected Network", "无向网"),
    DN("Directed Network", "有向网");
    public final String kindName;
    public final String kindDec;

    GraphKind(String kindName, String kindDec) {
        this.kindName = kindName;
        this.kindDec = kindDec;
    }

}
