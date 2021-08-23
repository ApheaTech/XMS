package com.aphea.xmssrv.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 13:53
 */
@Data
@NoArgsConstructor
public class Tree {
    private String ID;
    private String fatherID;
    private String label;
    private List<Tree> children = new ArrayList<>();

    public Tree(String ID, String fatherID, String fullName) {

        this.ID = ID;
        this.fatherID = fatherID;
        this.label = fullName;
    }

    public void addTreeNode(Tree t) {

        this.children.add(t);
    }

    public static Tree buildTree(HashMap<String, List> origin) {

        // 建造节点集合
        HashMap<String, Tree> nodes = new HashMap<>();
        for (Map.Entry<String, List> item : origin.entrySet()) {
            String ID = item.getKey();
            String fatherID = (String) item.getValue().get(0);
            String fullName = (String) item.getValue().get(1);
            nodes.put(ID, new Tree(ID, fatherID, fullName));
        }

        // 建造树
        Tree tree = new Tree();
        for (Map.Entry<String, Tree> node : nodes.entrySet()) {
            Tree currentNode = node.getValue();
            if (currentNode.getFatherID().equals("0") || currentNode.getFatherID().isEmpty()) {
                tree = currentNode;
            }else {
                nodes.get(currentNode.getFatherID()).addTreeNode(currentNode);
            }
        }

        return tree;
    }


}
