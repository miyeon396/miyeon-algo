package com.example.codete.section9Greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WrestlingPlayer_1 {
    // 씨름 감독이 선수 선발 공고냄.
    // N명의 지원자가 지원. 각 지원자의 키와 몸무게 알고픔
    // 씨름 선수 선발원칙을 다음과 같이 정함
    // A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자보다 높은(크고, 무겁다) 지원자가 존재하면 A는 탈락이고, 그렇지 않으면 선발된다.
    // N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇명의 선수를 선발할 수 있는지 알아내는 프로그램 작성.

    // 입력 설명
    // 첫 줄에 지원자 수 N(5<=N<=30000)
    // 두번 째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어짐. 각선수의 돌 능력시는 모두 다름 능력치 값은 1000000이하의 자연수

    // 출력 설명
    // 첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력

    // ex)
    // 5
    // 172 67
    // 183 65
    // 180 70
    // 170 72
    // 181 60
    // -> 3
    // 183, 65 / 180, 70 / 170, 72 가 선발. 181,60은 183 65보다 키와 몸무게 모두 낮기 떄문에 탈락, 172, 67은 180, 70 때문에 탈락

    // 좌표 정렬을 복습해야함. 얘도 좌표 정렬처럼 정렬해야함 body라는 클래스를 만들어서 넣어놓고 키를 기준으로 내림차순 정렬. 이제 몸무게만 가지고 for문 한번 on으로 끝내 버릴 수 있음.
    // Greedy -> 지금 이순간에 최선의 이득일 때 선택하는 것.
    // 정렬 해 놓고 맨 위의 친구는 하나 카운트 해야함.
    // Max를 하나 만들고 무조건 맨위 몸무게 넣음.
    // 다음 쭉쭉 감. 키는 졌으니 이제 몸무게는 무조건 이겨야함. 그런애들 선발.
    // 최대값이 되는 사람들 선발하는 원리



    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0; // 선발되는 인원수
        Collections.sort(arr); //키 정렬해놓고
        int max = Integer.MIN_VALUE;

        for(Body obj : arr) { // 이제 몸무게만 돌면 됨. 무조건 크면 count ++
            if(obj.w > max) {
                max = obj.w;
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        WrestlingPlayer_1 T = new WrestlingPlayer_1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //지원자 수
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(T.solution(arr,n));
    }

    static class Body implements Comparable<Body> {
        public int h;
        public int w;
        Body(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Body o) { //키 내림차순
            return o.h-this.h;
        }
    }
}
