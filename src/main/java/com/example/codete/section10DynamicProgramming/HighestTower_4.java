package com.example.codete.section10DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighestTower_4 {
    // 가장 높은 탑 쌓기
    // 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어간다.
    // 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램

    // 입력 파일의 첫 줄에 벽돌 수 최대 100 / 둘째줄부터 벽돌에 관한 정보인 밑면의 넓이 높이 무게
    // 출력 첫 줄에 가장 높이 쌓을 수 있는 탑의 높이 출력

    // ex) 5 / 25 3 4 / 4 4 6 / 9 2 3 / 16 2 5 / 1 5 2 -> 10

    static int[] dy;
    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        answer = dy[0];

        for (int i=1; i<arr.size(); i++) {
            int max_h = 0;
            for (int j=i-1; j>=0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h+arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String args[]) {
        HighestTower_4 T = new HighestTower_4();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Brick> arr = new ArrayList<Brick>();
        dy = new int[n];
        for (int i=0; i<n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            arr.add(new Brick(a, b, c));
        }
        System.out.println(T.solution(arr));

    }

    static class Brick implements Comparable<Brick> {

        public int s, h, w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s; //s에의한 내림차순
        }
    }

}

