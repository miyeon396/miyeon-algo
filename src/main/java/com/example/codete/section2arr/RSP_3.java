package com.example.codete.section2arr;

import java.util.Scanner;

public class RSP_3 {
    //두명 가위바위보
    //N번 게임 A이김 A출력, B이김 B출력, 비김 D출력
    //가위1바위2보3
    //가위바위보 정보 입력 시 누가 이겼는지 출력하는 프로그램.
    //첫줄 게임횟수
    //둘째줄 A가 낸거 셋째줄 B가 낸거
    //결과 return
    //3 -> 2 3 3 -> 1 1 3 입력 -> 출력 A B D
    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        for(int i=0; i<n; i++) {
            if(a[i] == b[i]) answer+="D";
            else if(a[i] == 1 && b[i] == 3) answer+="A";
            else if(a[i] == 2 && b[i] == 1) answer+="A";
            else if(a[i] == 3 && b[i] == 2) answer+="A";
            else answer+="B";
        }

        //n바퀴 돌면서 if 체크

       return answer;
    }

    public static void main(String args[]) {
        RSP_3 T = new RSP_3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, a, b));
        
    }
}
