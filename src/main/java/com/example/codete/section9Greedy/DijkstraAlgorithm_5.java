package com.example.codete.section9Greedy;

import java.util.*;

public class DijkstraAlgorithm_5 {
    // 다익스트라 알고리즘

    // 아래 가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요 (경로가 없으면 impossible를 출력한다.)
    //     1  <-(2)    2  ->(5) 5
    // (4) | ->(12) /  ^      ^ (5)
    //     V      V(5) | (2) /
    //     3    ->(5)   4  <- (5) 6

    // 첫 줄에 정점의 수 N (1<=N<=20)와 간선의 수 M가 주어짐. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어짐
    // 1번 정점부터 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력

    // -> 가중치 방향 그래프

    // ex)
    // 6 9 / 1 2 12 (1번정점에서 2번 정점으로 가는에 12의 비용이 든다.) / 1 3 4 / 2 1 2 / 2 3 5 / 2 5 5 / 3 4 5 / 4 2 2 / 4 5 5 / 6 4 5
    // -> 2 : 11 / 3 : 4 / 4 : 9 / 5 : 14 / 6 : impossible

    // 1차원 배열을 만들고 정점개수만큼
    // 1번부터 시작해서 각 번호로 갈때 안에 있는 값보다 작다면 갱신
    static int n;
    static int m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        pQ.offer(new Edge(v,0));
        dis[v] = 0;
        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost > dis[now]) {
                continue;
            }

            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }

    }

    public static void main(String[] args) {
        DijkstraAlgorithm_5 T = new DijkstraAlgorithm_5();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        T.solution(1);
        for (int i=2; i<=n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i+" : "+dis[i]);
            } else {
                System.out.println(i+" : impossible");
            }
        }

    }

    static class Edge implements Comparable<Edge> {
        public int vex; //정점 번호
        public int cost; // 간선의 가중치 값

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost; // 오름차순 가장 작은값을 우선으로
        }
    }
}
