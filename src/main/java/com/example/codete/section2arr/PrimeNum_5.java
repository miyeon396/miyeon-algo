package com.example.codete.section2arr;

import java.util.Scanner;

public class PrimeNum_5 {
    //N까지의 소수 개수 출력. - 에라토스테네스
    public int solution(int n) {
        int answer = 0;
        //n+1만큼의 인덱스
        //어레이 하나씩 증가하면서 0이면 카운트 해주고 소수가 아닌경우는 1넣어주고, 그의 배수들도 1넣어줘서 다 걸러내는거

        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++) {
            if(ch[i]==0) {
                answer++;
                for (int j = i; j <= n; j = j + i) ch[j] = 1;
            }
        }


        return answer;
    }

    public static void main(String args[]) {
        PrimeNum_5 T = new PrimeNum_5();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));

    }
}
