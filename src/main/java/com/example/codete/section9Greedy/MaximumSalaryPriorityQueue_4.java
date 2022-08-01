package com.example.codete.section9Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumSalaryPriorityQueue_4 {
    // 최대 수입 스케줄(PriorityQueue 응용 문제)
    // 유명한 강연자.
    // N개의 기업에서 강연을 요청해옴.
    // 각 기업은 D일 안에와서 강연을 해주면 M만큼의 강연료를 주기로 함
    // 각 기업이 요청한 D와 M을 바탕으로 가장 많은 돈을 벌 수 있는 강연 스케줄을 짜야함
    // 단 강연의 특성상 하루에 하나의 기업에서만 강연 할 수 있따.

    // 입력 설명
    // 첫줄에 자연수 N (1<=N<=10000) 다음줄에 N개의 줄에 M (1<=M<=10000)과 D(1<=D<=10000)가 차례로 주어짐
    // 출력 설명
    // 첫 줄에 최대로 벌 수 있는 수입을 출력함.

    // ex)
    // 6 / 50 2 / 20 1 / 40 2 / 60 3 / 30 3 / 30 1 -> 150

    static int n;
    static int max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); //큰 값을 우선순위로하는 priorityQueue Order
        Collections.sort(arr);
        int j = 0;
        for(int i=max; i>=1; i--) {
            for(; j<n; j++) {
                if(arr.get(j).time < i) {
                    break;
                }
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) {
                answer+=pQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MaximumSalaryPriorityQueue_4 T = new MaximumSalaryPriorityQueue_4();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //회의 수
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            arr.add(new Lecture(m, d)); //money , time
            if(d>max) {
                max = d;
            }
        }
        System.out.println(T.solution(arr));

    }

    static class Lecture implements Comparable<Lecture> {
        public int money;
        public int time;

        Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture ob) {
            return ob.time - this.time; //큰 값을 우선
        }
    }
}
