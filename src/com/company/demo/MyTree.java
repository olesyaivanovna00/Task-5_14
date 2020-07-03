package com.company.demo;

import com.company.DefaultBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MyTree implements DefaultBinaryTree<Integer> {

    protected class SimpleTreeNode implements DefaultBinaryTree.TreeNode<Integer> {
        public Integer value;
        public SimpleTreeNode left;
        public SimpleTreeNode right;

        public SimpleTreeNode(Integer value, SimpleTreeNode left, SimpleTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public SimpleTreeNode(Integer value) {
            this(value, null, null);
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public TreeNode<Integer> getLeft() {
            return left;
        }

        @Override
        public TreeNode<Integer> getRight() {
            return right;
        }
    }

    private SimpleTreeNode root;

    public MyTree(){
    }

    @Override
    public TreeNode<Integer> getRoot() {
        return root;
    }

    public void createTree(int number) throws Exception {
        number = f(number);
        if(number == 0){
            root = new SimpleTreeNode(0,null,null);
        }

        int newNumber = 0;
        int nextNumber = 1;
        int buffer = 0;

        List<Integer> list = new ArrayList<>();
        list.add(nextNumber);

        while (nextNumber < number){
            buffer = nextNumber;
            nextNumber = newNumber + nextNumber;
            newNumber = buffer;
            list.add(nextNumber);
        }

        if(nextNumber > number){
            throw new Exception("Это не число Фибаначи");
        }
        root = addNumber(list.size() - 1, list);
    }

    private SimpleTreeNode addNumber(int index, List<Integer> list){
        if(index < 2){
            return new SimpleTreeNode(1,null,null);
        }
        return new SimpleTreeNode(list.get(index), addNumber(index - 2,list),addNumber(index-1,list));
    }

    public static int f(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return f(n - 1) + f(n - 2);
    }
}
