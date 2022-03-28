package com.example.codete.section1string;

import java.util.Scanner;

public class PasswordStr {
    public String solution(int n, String str) {
        // 보낸 문자의 개수
        // 문자의 개수 일곱배 # 1 or * 0
        // 아스키에 맞게 변환
        // #****###**#####**#####**##**
        String answer = "";

        for(int i=0; i<n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            System.out.println("tmp=="+tmp+ " " + num);
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String args[]) {
        PasswordStr T = new PasswordStr();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(T.solution(n, str));

    }
}
