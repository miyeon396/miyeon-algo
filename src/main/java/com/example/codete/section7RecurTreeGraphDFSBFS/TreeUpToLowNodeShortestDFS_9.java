package com.example.codete.section7RecurTreeGraphDFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUpToLowNodeShortestDFS_9 {

    // Tree 말단 노드까지의 가장 짧은 경로 (DFS)
    // 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짭은 길이를 구하는 프로그램
    // 각 경로의 길이는 루트노드에서 말단노드(자식 없는 노드)까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
    //       1
    //   2      3
    // 4   5
    // 가장 짧은 길이는 3번 노드까지의 길이이다.
    // -> 풀긴 DFS로 풀어봤찌만 사실 최단거리 문제는 BFS로 푸는게 정답이다.



    Node root;
    public int DFS(int l, Node root) {
        //root는 노드를 가리키는 것.
        if (root.lt == null && root.rt == null) {
            return l; //이 노드가 가리키는 레벨(=거리) 루트부터의 거리가 되겠죠
        } else {
            return Math.min(DFS(l+1, root.lt), DFS(l+1, root.rt)); // 둘 다로 뻗기 때문에 자식이 하나만 있으면 안됨.
        }
    }

    public static void main(String args[]) {
        TreeUpToLowNodeShortestDFS_9 tree = new TreeUpToLowNodeShortestDFS_9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));

    }


}

