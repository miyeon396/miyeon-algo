package com.example.codete.section7RecurTreeGraphDFSBFS;

public class BinaryTreeDFS_5 {

    // 이진트리순회(DFS - Depth-First Search)
    // 이진트리를 전위순회와 후위순회를 연습하세요
    //     1
    //  2     3
    // 4 5   6 7
    // 전위 순회 : 1 2 4 5 3 6 7
    // 중위 순회 : 4 2 5 1 6 3 7
    // 후위 순회 : 4 5 2 6 7 3 1

    // DFS : 깊이 우선 탐색
    // 전위 : 부모 - 왼쪽 자식 - 오른쪽 자식
    // 중위 : 왼쪽 자식 - 부모 - 오른쪽 자식
    // 후위 : 왼쪽 자식 - 오른쪽 자식 - 부모

    Node root;
    public void DFS(Node root) {
        if(root == null) {
            return;
        } else {
            //두가닥으로 뻗음
            System.out.println("전위 "+root.data+ " "); // 전위 순회
            DFS(root.lt);
            System.out.println("중위 "+root.data+ " "); // 중위 순회
            DFS(root.rt);
            System.out.println("후위 "+root.data+ " "); // 후위 순회
        }

    }

    public static void main(String args[]) {
        BinaryTreeDFS_5 tree = new BinaryTreeDFS_5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);

    }
}

class Node {
    int data;
    Node lt;
    Node rt;
    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}
