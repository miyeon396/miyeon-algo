package com.example.codete.section4HashTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetAllAnagram_4 {
    // S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열 개수를 구하는 프로그램.
    // 대소문자 구분. 연속된 문자열
    // S 입력, T 입력(S보다 길이가 작거나 같음) 부분문자열 개수 출력 -> bacaAacba abc -> 3
    // 2pointer althrithm, hash, sliding windows
    // 2포인터로 뒤에 길이 갖고 창문으로 밀고 가면서 체크하면 되는 것.
    // bmap, amap에 넣고 비교 am.equals(bm) -> 아나그램 lt, rt 증가 시키면서 , 0일땐 제거하구
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0)+1);
        }
        int l = b.length()-1;
        for(int i=0; i<l; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
        }
        //사전 세팅 끝.

        int lt = 0;
        for(int rt = l; rt<a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String args[]) {
        GetAllAnagram_4 T = new GetAllAnagram_4();
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        System.out.println(T.solution(a,b));

    }
}
