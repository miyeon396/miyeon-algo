package com.example.codete.section9Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MeetingRoom_2 {
    // 한개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대해서 회의실 사용표를 만들려고 함
    // 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
    // 단 회의는 한번 시작하면 중간에 중단 불가 한회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

    // 입력
    // 첫 줄에 회의 수 N (1<=n<=100000)
    // 둘째 줄 부터 n+1줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어짐
    // 회의 시간은 0시부터 시작
    // 회의의 시작시간과 끝나는 시간의 조건은 (시작<=끝)이다.

    // 출력
    // 첫 줄에 최대 사용할 수 있는 회의 수 출력

    // ex)
    // 5
    // 1 4 / 2 3 / 3 5 / 4 6 / 5 7
    // -> 3 (2,3) (3,5) (5,7)
    // 2
    // 3 3 / 1 3 / 2 3
    // -> 2

    // 최대 회의수니까 끝나는 시간 정렬을 해서 빨리 끝나는거부터 선택해나가면 최상의 효과
    // 다음거 시작시간이 크거나 같으면 가능 아님 패스
    // 그치만 끝나는 시간이 같다면 시작시간을 오름차순으로 세워야함



    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0; // 선발되는 인원수

        Collections.sort(arr); // 정렬작업
        int et=0; //endtime
        for(Time ob : arr) {
            if(ob.s >= et) {
                cnt ++; //회의는 진행한다.
                et = ob.e; //회의를 진행하니 endTime을 업데이트 해준다.
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        MeetingRoom_2 T = new MeetingRoom_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //회의 수
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr.add(new Time(x,y));
        }
        System.out.println(T.solution(arr,n));
    }

    static class Time implements Comparable<Time> {
        public int s;
        public int e;
        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if (this.e == o.e) {
                return this.s-o.s;
            } else {
                return this.e-o.e;
            }
        }
    }
}
