package com.example.codete.section2arr;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePrimeNum_6 {
    //N입력 후 N개만큼 숫자 입력 받음. 숫자 뒤집었을 때 소수면 소수를 출력
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> answer2 = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int temp = arr[i];
            String tmpStr = String.valueOf(temp);
            StringBuilder builder = new StringBuilder(tmpStr);
            int res = Integer.parseInt(builder.reverse().toString());
            if(isPrime(res)) answer.add(res);
        }

        //case 2. 해설방법은 10으로 나눠서 나머지 더하는 방식인데.. 그냥 reverse가 더 단순해서 아래 해설은 참고
        for(int i=0; i<n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(res)) answer2.add(res);
        }

        return answer;
    }

    public boolean isPrime(int num) {
        //소수 체크
        //2보다 클때 자기자신 전까지 약수가 발견 되면 소수가 아님
        if(num == 1) return false;
        for(int i=2; i<num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        ReversePrimeNum_6 T = new ReversePrimeNum_6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int x : T.solution(n, arr)) {
            System.out.print(x+" ");
        }

        
    }
}
