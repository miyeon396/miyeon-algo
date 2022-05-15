package com.example.codete.section5StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArchitectOfEdu_7 {

    // 필수과목 반드시 이수 및 순서 주어져 있음
    // ex) ABCDEFG -> CBA 필수 과목 순서대로 들어야함
    // CBDAGE 제대로 된 설계임 / CGEADB 잘못된 설계임
    // 필수 과목 순서 주어질 때 N개의 수업 설계가 잘된거면 Yes 잘못된 거면 No Return
    // 입력 예제 CBA / CBDAGE
    // Queue 사용
    // 필수과목 순서 queue에 넣어놓음. 나머지꺼에서 큐에 있나 확인 . 잘 순서가 맞으면 들엇으면 팝을 해버림.
    // 필수과목인데 제일 앞에 있찌 않으면 Return No 해버림.

    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();

        // 1. 일단 모든 필수과목들을 큐에 넣어줌
        for(char x : need.toCharArray()) {
            q.offer(x);
        }

        // 2. 과목별로 돌면서 필수 값이 젤 앞에 순서대로 있는지 체크
        for(char x : plan.toCharArray()) {
            if(q.contains(x)) {
                if(x != q.poll()) return "NO"; // 필수값이지만 맨앞에 있지 않으면 no
            }
        }
        if(!q.isEmpty()) return "NO"; // 큐가 비어있지 않고 필수과목 남아있다면 안들은거니까 no

        return answer;
    }

    public static void main(String args[]) {
        ArchitectOfEdu_7 T = new ArchitectOfEdu_7();
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        System.out.println(T.solution(a, b));

    }
}
