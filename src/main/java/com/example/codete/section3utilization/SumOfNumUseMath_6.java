package com.example.codete.section3utilization;

import java.util.Scanner;

public class SumOfNumUseMath_6 {
    // 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 가짓수 출력
    // ex) n = 15 -> 7+8=15, 4+5+6=15, 1+2+3+4+5=15 -> 3
    // 여기서는 수학을 쓸 것임. 2개 더할 땐 -> 1 2 넣어주고 15-3 / 2 = 6 가넝, 1 2 3 넣어주고 15-6 / 3 = 3 가넝 / 1 2 3 4 넣어주고 15-10 / 4 = 1.xxx 불가넝 , 1 2 3 4 5 넣어주고 15-15 / 5 = 0 가넝

    public int solution(int n) {
        int answer = 0;
        int cnt = 1;
        n--; //n에서 1을 뺀 것.
        while(n > 0) {
            cnt++;
            n = n-cnt;
            if(n % cnt == 0) answer++;
        }

        return answer;
    }

    public static void main(String args[]) {
        SumOfNumUseMath_6 T = new SumOfNumUseMath_6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
        
    }
}
