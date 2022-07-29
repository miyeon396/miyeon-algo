package com.example.codete.section9Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wedding_3 {
    // 현수는 담달에 결혼하는데 피로연 장소를 빌려 3일간 쉬지않고 하려고 함
    // 피로연에 참석하는 N명의 친구들의 참석 시간정보를 친구들에게 미리 요구함
    // 각 친구들이 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려줌
    // 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고함
    // 만약 친구가 오는시간이 13 가는 시간이 15라면 친구는 13시 정각에 피로 장소에 존재하는 것이고 15시 정각에는 존재하지 않는다라고 가정

    // 입력
    // 첫 줄에 피로연 참석 인원수 N(5<=N<=100000)이 주어짐
    // 두번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
    // 시간은 첫날 0시를0 마지막날 12시를 72로 하느 타임라인으로 오는시간이 음이 아닌 정수
    // 출력
    // 첫 줄에 피로연장에 동시에 존재하는 최대 인원 출력
    // ex) 5 / 14 18 / 12 15 / 15 20 / 20 30 / 5 14 -> 2

    // s,e 있을 때 e가는건 cnt 빼주고 s는 cnt 넣어주고 answer에 저장



    public int solution(ArrayList<WeddingTime> arr, int n) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0; // 현재 이순간에 몇명이 존재하느냐
        for(WeddingTime ob : arr) {
            if(ob.state == 's') {
                cnt++;
            } else {
                cnt--; //e일 때
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
    public static void main(String[] args) {
        Wedding_3 T = new Wedding_3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //회의 수
        ArrayList<WeddingTime> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int sT = scanner.nextInt();
            int eT = scanner.nextInt();
            arr.add(new WeddingTime(sT,'s'));
            arr.add(new WeddingTime(eT,'e'));
        }
        System.out.println(T.solution(arr,n));
    }

    static class WeddingTime implements Comparable<WeddingTime> {
        public int time;
        public char state; //s인지 e인지

        WeddingTime(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(WeddingTime ob) {
            if (this.time == ob.time) {
                return this.state - ob.state;
            } else {
                return this.time - ob.time;
            }
        }
    }
}
