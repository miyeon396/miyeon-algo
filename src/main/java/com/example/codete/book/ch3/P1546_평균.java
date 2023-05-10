package com.example.codete.book.ch3;

import java.util.Scanner;

public class P1546_평균 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i < n; i++) { //array 원소 입력시에는 인덱스 지정이 꼭 필요하니까 foreach 쓰지 말고 인덱스 포문 쓰세요
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;
        for ( int score : arr) {
            if ( score > max ) {
                max = score;
            }
            sum += score;
        }

        // 수식 : 전체 점수 / 최고점수 * 100 / 과목수
        System.out.println(sum  * 100.0  / max/ n); //곱하기와 나누기 순서도 중요함 곱하기부터..
        //sum / max * 100.0 / n // -> 일케 했더니 경고 'sum / max': integer division in floating-point context



    }
}
