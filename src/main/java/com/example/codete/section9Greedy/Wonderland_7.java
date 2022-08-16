package com.example.codete.section9Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wonderland_7 {
    // 원더랜드 (최소스패닝트리 : 크루스칼, union find 활용)
    // 원더랜드에 문제가 생겼다. 원더랜드 각 도로를 유지보수하는 재정이 바닥난 것
    // 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
    // 아래는 그 예를 설명
    // 위의 지도는 각 도시가 1부터9까지 표현되었고 지도의 오른쪽은 최소비용 196으로 모든 도시

    // 모든 지역이 연결되어있는 트리를 하나 뽑아내는데 그중에서 비용이 젤 최소인걸 뽑아내는게 -> 최소스패닝트리

    // 그래프 : 회로가 있음. 돌아올수있는길이있음 연결된 길이있음
    // 트리 : 한선으로만 연결되어있음 / 간선 = 정점 - 1

    // v1 v2 cost 클래스를 하나 만들어서 저장 ( 2 9 8 / 2 3 10 ... etc)
    // 비용 오름차순으로 정렬 -> 트리가 될 때까지 가장 작은값 선택해 나가면 됨.
    // 회로가 되면 안된다. find로 회로인지 아닌지 판별. (이미 있는지 없는지를 체크하는 것 같음)

    // ex)
    // 9 12 / 1 2 12 / 1 9 25 / 2 3 10 / 2 8 17 / 2 9 8/ 3 4 18 / 3 7 55/ 4 5 44 / 5 6 50 / 5 7 38 / 7 8 35 / 8 9 15
    // -> 196

    static int[] unf;

    //Union & Find는 늘 이런식으로 작성될 것이니 외워두세요
    public static int Find2(int v) {
        if(v==unf[v]) {
            return v;
        } else {
            return unf[v] = Find2(unf[v]);
        }
    }

    public static void Union2(int a, int b) {
        int fa = Find2(a);
        int fb = Find2(b);
        if(fa!=fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //도시 정점개수
        int m = scanner.nextInt(); //도로 간선
        unf = new int[n+1];
        ArrayList<Edge> arr = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            unf[i] = i; //초기화
        }

        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            arr.add(new Edge(a,b,c));
        }

        int answer = 0;
        Collections.sort(arr); //cost 오름 차순
        for(Edge ob: arr) {
            int fv1 = Find2(ob.v1);
            int fv2 = Find2(ob.v2);
            if(fv1!=fv2) {
                answer+=ob.cost;
                Union2(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);

    }


}

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost; //간선 작은 것 부터 오름차순 정
    }
}
