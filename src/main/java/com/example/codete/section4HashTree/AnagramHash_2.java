package com.example.codete.section4HashTree;

import java.util.HashMap;
import java.util.Scanner;

public class AnagramHash_2 {
    // 아나그램 : 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램
    // ex) AbaAeCe, baeeACA는 나열 순서는 다르지만 A2 a1 b1 C1 e2로 개수 일치.
    // 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램. 판별 시 대소문자가 구분.
    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : s2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x)-1);
        }


        return answer;
    }

    public static void main(String args[]) {
        AnagramHash_2 T = new AnagramHash_2();
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(T.solution(a,b));

    }
}
