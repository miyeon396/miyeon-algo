package com.example.codete.section7RecurTreeGraphDFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchRouteAdjencyMatrixArrayList_13 {

    // 그래프 최단거리 (BFS) -> 최단거리는 BFS다  (1번에서 한번만에 가는 정점 2번만에 가는 정점 다 일케 찾으면 댄당!)
    // 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요
    // 1 <- 2 -> 5
    // |\    ^ ^ ^
    // V V    X  |
    // 3 -> 4 -> 6

//    ex) 0 -   1
//        1 - 3   4
//        2-    5   6
//        3          2 // -> 이렇게 레벨별로 할 수도 있찌만 이 예제에서는 배열을 사용해서 함
    // 배열로 하는 예제
    // dis(arr) 1 2 3 4 5 6 (dis[n]은 1번 정점에서 각 배열 정점까지 가는 최소 거리구해서 넣어줌 ) => dis[nv] = dis[v]+1
    // dis 0 3 1 1 2 2 일케 됨. BFS는 절대 돌아서 안감.

    // 입력 설정
    // 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M 줄에 걸쳐 연결정보가 주어진다.
    // ex ) 6 9 / 1 3 / 1 4 / 2 1 / 2 5 / 3 4 / 4 5 / 4 6 / 6 2 / 6 5
    // -> 2:3 / 3:1 / 4:1 / 5:2 / 6 : 2

    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;

    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)) {
                //방문햇냐 안햇냐만 보면 됨.
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv]+1;
                }
            }
        }

    }

    public static void main(String args[]) {
        SearchRouteAdjencyMatrixArrayList_13 T = new SearchRouteAdjencyMatrixArrayList_13();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 노드의 개수
        m = scanner.nextInt(); // 간선의 개수
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b); //3번 arrayList에 5를 add 시켜라 이런 의미
        }
        T.BFS(1); //너비 우선 탐색 1번 정점부터 출발해라
        for(int i=2; i<=n; i++) {
            System.out.println(i+ " : "+dis[i]);
        }
    }
}
