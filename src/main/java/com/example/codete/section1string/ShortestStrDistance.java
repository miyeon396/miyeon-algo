package com.example.codete.section1string;

import java.util.Scanner;

public class ShortestStrDistance {
    //문자열이 특정문자(e)로부터 더 가깝게 떨어진 거리
    public int[] solution(String str, char c) {
        //나 기준 왼쪽의 특정문자 위치 구함
        //나 기준 오른쪽의 특정문자 위치 구함 더 작다면 갈아치움
        int[] answer = new int[str.length()];

        int p = 1000;

        //1. 왼쪽의 특정문자로부터 떨어진 거리
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        //2. 초기화 후 오른쪽 기준으로 다시 돌려서 작은 값을 넣어줌.
        p=1000;
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == c) p=0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        ShortestStrDistance T = new ShortestStrDistance();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        for(int i: T.solution(str, c)) {
            System.out.println(i + " ");
        }

    }
}
