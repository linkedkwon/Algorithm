package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991 {

    static class Node{
        char data;
        Node left, right;

        public Node(char data){
            this.data = data;
        }
    }

    static class Tree{
        Node root;

        public void add(char data, char leftData, char rightData){
            if(root == null){
                if(data != '.') root = new Node(data);
                if(leftData != '.') root.left = new Node(leftData);
                if(rightData != '.') root.right = new Node(rightData);
            }
            else{
                search(root, data, leftData, rightData);
            }
        }

        public void search(Node root, char data, char leftData, char rightData){
            if(root == null) return;
            else if(root.data == data){
                if(leftData != '.') root.left = new Node(leftData);
                if(rightData != '.') root.right = new Node(rightData);

            }
            else{
                search(root.left, data, leftData, rightData);
                search(root.right, data, leftData, rightData);
            }
        }

        public void preOrder(Node root){
            sb.append(root.data);
            if(root.left != null) preOrder(root.left);
            if(root.right != null) preOrder(root.right);
        }

        public void inOrder(Node root){
            if(root.left != null) inOrder(root.left);
            sb.append(root.data);
            if(root.right != null) inOrder(root.right);
        }

        public void postOrder(Node root){
            if(root.left != null) postOrder(root.left);
            if(root.right != null) postOrder(root.right);
            sb.append(root.data);
        }
    }

    static Tree tree = new Tree();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        preProcess();
        process();
        System.out.println(sb);
    }

    static void preProcess() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }
        br.close();
    }

    static void process(){
        tree.preOrder(tree.root);
        sb.append('\n');
        tree.inOrder(tree.root);
        sb.append('\n');
        tree.postOrder(tree.root);
    }

}