package com.example.codete.section8DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PizzaDFS_15 {
    // 피자 배달 거리 (DFS 활용)
    // N * N 크기의 도시지도. 1x1 격자칸으로 이루어짐
    // 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됨.
    // 각 격자칸은 좌표(행번호,열번호)로 표시됨.
    // 행번호는 1~N까지 열 번호도 1~N까지 있음
    // 도시에는 각 집마다 피자배달거리가 있는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는 피자집들과의 거리 중 최소값을 해당 집의 피자배달거리라고 함 // -> 집이 주체.
    // 집과 피자 집의 배달거리는 |x1-x2|+|y1-y2| 이다.
    // 예를 들어, 도시의 지도가 아래와 같다면
    // 0 1 0 0
    // 0 0 2 1
    // 0 0 1 0
    // 1 2 0 2
    // (1,2)에 있는 집과 (2,3)에 있는 피자집과의 피자 배달 거리는 |1-2|+|2-3| = 2가 된다.
    // 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있다.
    // 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 함.
    // 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 함.
    // 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말함.

    // ex)
    // 4 4
    // 0 1 2 0
    // 1 0 2 1
    // 0 2 1 2
    // 2 0 1 2
    // -> 6


    static int n;
    static int m; // 도시에서 살려야할 피자 집들
    static int len;
    static int answer = Integer.MAX_VALUE; //도시의 피자거리 최솟값
    static int[] combi; // 조합을 여기다가 저장할 것임
    static ArrayList<PointPizza> pz; // 피자집의 좌표 다넣음
    static ArrayList<PointPizza> hs; // 집의 좌표 다넣음
    public void DFS(int L, int s) {
        // 조합은 거의 외우다 시피 하세요
        if(L==m) {
            // 조합이 하나 완성 되는 것
            int sum = 0;
            for (PointPizza h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i: combi) { //h의 집과 살아남은 피자집을 다 도는 것.
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x)+Math.abs(h.y - pz.get(i).y));
                }
                // for무니 끝나고 나면 이 집의 피자 거리
                sum+=dis; // 어떤 조합이 만들어 졌을 때 도시의 피자 거리

            }
            answer = Math.min(answer, sum);

        } else {
            for (int i=s; i<len; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }

    }

    public static void main(String[] args) {
        PizzaDFS_15 T = new PizzaDFS_15();
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int tmp = scanner.nextInt();
                if (tmp == 1) {
                    hs.add(new PointPizza(i,j)); //집
                } else if (tmp ==2) {
                    pz.add(new PointPizza(i,j)); //피자집
                }

            }
        }
        len = pz.size(); // 도시에 있는 피자집의 개수 lenCm
        combi = new int[m];
        T.DFS(0,0);
        System.out.println(answer);

    }

    static class PointPizza {
        public int x;
        public int y;
        PointPizza(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
