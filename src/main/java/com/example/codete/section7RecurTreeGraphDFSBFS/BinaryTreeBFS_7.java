package com.example.codete.section7RecurTreeGraphDFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS_7 {

    // 이진트리순회(BFS - Depth-First Search : Level 탐색)
    //     1
    //  2     3
    // 4 5   6 7
    // 레벨 탐색 순회 출력 : 1 2 3 4 5 6 7

    Node2 root;
    public void DFS(Node2 root) {
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while(!q.isEmpty()) { //빌때까지돌기
            int len = q.size();
            System.out.print(l+ " : "); //
            for (int i=0; i<len; i++) {
                Node2 cur = q.poll(); //level 출력
                System.out.print(cur.data+" "); // 나오고 연결된건 큐에 넣는 거

                if(cur.lt != null) {
                    q.offer(cur.lt);
                }
                if(cur.rt != null) {
                    q.offer(cur.rt);
                }

            } // level이 끝난거
            l++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        BinaryTreeBFS_7 tree = new BinaryTreeBFS_7();
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        tree.root.rt.lt = new Node2(6);
        tree.root.rt.rt = new Node2(7);

        tree.DFS(tree.root);

    }


}
class Node2 {
    int data;
    Node2 lt;
    Node2 rt;
    public Node2(int val) {
        data = val;
        lt=null;
        rt=null;
    }

}
