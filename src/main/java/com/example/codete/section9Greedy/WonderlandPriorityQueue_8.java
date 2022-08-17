package com.example.codete.section9Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WonderlandPriorityQueue_8 {
    // 원더랜드 (최소스패닝트리 : 프림, PriorityQueue)
    // 원더랜드에 문제가 생겼다. 원더랜드 각 도로를 유지보수하는 재정이 바닥난 것
    // 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
    // 아래는 그 예를 설명
    // 위의 지도는 각 도시가 1부터9까지 표현되었고 지도의 오른쪽은 최소비용 196으로 모든 도시

    // 모든 지역이 연결되어있는 트리를 하나 뽑아내는데 그중에서 비용이 젤 최소인걸 뽑아내는게 -> 최소스패닝트리

    // 그래프 : 회로가 있음. 돌아올수있는길이있음 연결된 길이있음
    // 트리 : 한선으로만 연결되어있음 / 간선 = 정점 - 1

    // 체크 배열이 하나 필요함. 0부터 9까지 있고 다 0으로 초기화
    // 1번 정점(객체)를 PQ에 넣음 (1,0) 0의 비용으로 1번 정점에 왔다. 그리구 폴
    // 1에서 가는거 다 넣어줌 (2, 12) , (9,25) 2로가는데 비용 12 / 9로 가는데 비용 25
    // answer에 비용을 더해줌
    // 현재 원소에서 갈 수 있는 간선중 가장 작은거를 poll 해줌 -> 2,12가 폴됨. -> 트리의 원소인가아닌가 체크배열 보니 0 아직 아님 1로 체크 -> 2번 정점이 트리의 원소로 추가가 된 것
    // 또 2에서 갈 수 있는 것들 다 넣어줌. 체크배열이 0인 것들만 넣어줌. (9,8), (8,17), (3,10)을 넣어줌 (9,25)까지 있음 젤 비용작은거 폴함 -> 9,8
    // 이제 9번 정점 또 선택 가능한지 보고 0이니 체크 가능 1로 변경 비용 answer에 +1
    // 반복
    // 큐에 들어간 간선들은 트리에 연결된 정점에서 뻗어나갈 수 잇는 간선. 그중에서 최소를 선택해 나가는 것.

    // ex)
    // 9 12 / 1 2 12 / 1 9 25 / 2 3 10 / 2 8 17 / 2 9 8/ 3 4 18 / 3 7 55/ 4 5 44 / 5 6 50 / 5 7 38 / 7 8 35 / 8 9 15
    // -> 196

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //도시 정점개수
        int m = scanner.nextInt(); //도로 간선
        ArrayList<ArrayList<EdgeP>> graph = new ArrayList<>(); // 인접리스트

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<EdgeP>());
        }
        int[] ch = new int[n+1]; //체크 배열 초기값0 방문한 정점이면 1로 변경

        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(a).add(new EdgeP(b,c)); //abc 받으면 a라는 정점에서 b라는 정점에 가는데 비용이 c다.
            graph.get(b).add(new EdgeP(a,c)); //b에서 a도 갈 수 있으니 하나 더 추가해줘야함
            // 다익스트라는 방향이 있어서 하나지만 이건 무방향이기때문에 반대도 필요
        }

        int answer = 0;
        PriorityQueue<EdgeP> pQ = new PriorityQueue<>();
        pQ.offer(new EdgeP(1,0)); //최초값 넣고 출발
        while(!pQ.isEmpty()) { //pQ가 비면 멈춤
            EdgeP tmp = pQ.poll();
            int ev = tmp.vex; // 도착정점
            if(ch[ev]==0) {
                ch[ev] = 1;
                answer+=tmp.cost;
                for(EdgeP ob : graph.get(ev)) {
                    if(ch[ob.vex]==0) {
                        pQ.offer(new EdgeP(ob.vex, ob.cost));
                    }
                }
            }
        }
        System.out.println(answer);

    }


}

class EdgeP implements Comparable<EdgeP> {
    public int vex; //정점
    public int cost;
    EdgeP(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(EdgeP o) {
        return this.cost - o.cost; //간선 작은 것 부터 오름차순 정
    }
}
