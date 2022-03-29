package com.example.codete.section2arr;

import com.example.codete.TemplateArrVer;

import java.util.Scanner;

public class ShowStudent_2 {
    // 자기 앞에 서있는 모든 학생들보다 크면 보임. 앞의 학생들보다 작거나 같으면 안보임.
    // 5
    // 140 145 150 145 153 -> 4명 보임
    public int solution(int n, int[] arr) {
        int answer = 1;
        int max = arr[0];

        for(int i=1; i<n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        ShowStudent_2 T = new ShowStudent_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr));

    }
}
