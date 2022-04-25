package com.example.codete.template;

import java.util.Scanner;

public class TemplateArrVer {
    public int solution(int n, int[] arr) {
        int answer = 0;

        return answer;
    }

    public static void main(String args[]) {
        TemplateArrVer T = new TemplateArrVer();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr));
        
    }
}
