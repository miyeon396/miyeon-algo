package com.example.codete.section4HashTree;

import java.util.HashMap;
import java.util.Scanner;

public class ClassZzangHash_1 {
    // 회장후보 ABCDE
    // 뽑을사람 적고 회장 출력
    // ex ) 15 학생수 / BACBAAAADEAAAAA -> A
    // HashMap을 사용 A : 3 B : 5 뭐일케... 각각 카운팅.
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character,Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for(char key : str.toCharArray()) {
            map.put(key, map.getOrDefault(key,0)+1);
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(map.containsKey('A'));
//        System.out.println(map.size());
//        System.out.println(map.remove('A')); //A라는 키의 value 값 리턴

        return answer;
    }

    public static void main(String args[]) {
        ClassZzangHash_1 T = new ClassZzangHash_1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(T.solution(n, str));

    }
}
