package com.example.codete.section7RecurTreeGraphDFSBFS;


import java.util.LinkedList;
import java.util.Queue;

public class TreeUpToLowNodeShortestBFS_10 {

    // Tree 말단 노드까지의 가장 짧은 경로 (BFS)
    // 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짭은 길이를 구하는 프로그램
    // 각 경로의 길이는 루트노드에서 말단노드(자식 없는 노드)까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
    //       1
    //   2      3
    // 4   5
    // 가장 짧은 길이는 3번 노드까지의 길이이다.
    // -> 최단거리 문제는 BFS로 푸는게 정답이다.
    // 레벨 탐색 하다가 말단 노드 발견 했다 최초로 -> 최단거리 -> 얘 걍 리턴!




    Node3 root;
    public int BFS(Node3 root) {
        Queue<Node3> q = new LinkedList<>();
        q.offer(root);
        int l = 0; //level

        while(!q.isEmpty()) {
            int len = q.size(); //level의 길이
            for (int i=0; i<len; i++) {
                Node3 cur = q.poll(); //노드를 하나 꺼내서 얘가 말단 노드인지 체크
                if(cur.lt == null && cur.rt == null) {
                    return l;
                }
                if(cur.lt != null) {
                    q.offer(cur.lt);
                }
                if(cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            l++;
        }
        return 0; // 암것도 안하는 코드임...

    }

    public static void main(String args[]) {
        TreeUpToLowNodeShortestBFS_10 tree = new TreeUpToLowNodeShortestBFS_10();
        tree.root = new Node3(1);
        tree.root.lt = new Node3(2);
        tree.root.rt = new Node3(3);
        tree.root.lt.lt = new Node3(4);
        tree.root.lt.rt = new Node3(5);
        System.out.println(tree.BFS(tree.root));

    }


}

class Node3 {
    int data;
    Node3 lt;
    Node3 rt;

    public Node3(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}
