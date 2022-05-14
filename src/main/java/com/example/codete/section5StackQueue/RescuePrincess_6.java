package com.example.codete.section5StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RescuePrincess_6 {
    // 왕자 N명이 공주 구하러 가겠다함.
    // 나이순으로 1~N 번호 매김. 1부터 N까지 동그랗게 앉음. 한 왕자가 K(특정숫자) 외치면 그 왕자는 공주 구하러 가는데 제외 원밖으로 나옴
    // 그 다음 왕자부터 다시 1부터 시작해서 번호 외침.
    // 마지막 남은 왕자가 공주 구하러 감.
    // N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력.
    // 큐를 사용 FIFO
    // 큐에 넣고 while 돌면서..?

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) { //queue에 미리 세팅
            q.offer(i);
        }

        while(!q.isEmpty()) { // 비면 멈춤
            for(int i=1; i<k; i++) {
                q.offer(q.poll()); //앞에껄 꺼내서 뒤에다가 넣음. poll은 꺼내고 return 받음.
            }
            q.poll();
            if(q.size()==1) {
                answer = q.poll(); //마지막 하나 남은건 queue에 넣어줌
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        RescuePrincess_6 T = new RescuePrincess_6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(T.solution(n, k));

    }
}
