package com.yisu.algorithm.num1;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {


    static  List<List<Integer>> list=new ArrayList<>();
    public static void main(String[] args) {
        list.clear();
        TreeNode treeNode = treeSet();
        if(null== treeNode){
            System.out.println(list);
        }
        deal(treeNode,0);
        System.out.println(list);

    }

    public static void deal(TreeNode node, int level){
        if (list.size() == level)
            list.add(new ArrayList<>());

        if(null!=node.val) {
            list.get(level).add(node.val);
        }

        if(node.left != null)
            deal(node.left, level + 1);

        if(node.right != null)
            deal(node.right, level + 1);
    }

    // 构造二叉树，返回根节点
    public static TreeNode treeSet() {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(null);
        TreeNode d = new TreeNode(null);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(7);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        return root;
    }
}
