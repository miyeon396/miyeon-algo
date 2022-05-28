package com.example.codete.section6SortSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Child_6 {

    // N명의 학생 있음. 번호 정하기 위해 키순으로 작은 순서대로 세움
    // 가장 작은 학생부터 1번~N번
    // 철수는 짝꿍보다 키가 큼. 철수는 앞번호 받고 싶어서 짝꿍가 자리 바꿈
    // 선생님은 이 사실 모르고 학생 서있는 순서대로 번호 부여
    // 철수와 짝꿍이 자리 바꾼 반 학생들의 일렬로 서있는 키 정보 주어질 때, 철수가 받은 번호와 철수 짝꿍이 받은 번호를 차례로 출력

    // 입력 예시 첫줄 자연수 둘째쭐 젤 앞부터 일렬로 서있는 학생 키
    // 철수의 반 번호, 짝꿍 반 번호 차례로 출력
    // -> 정렬 생각하면 아주 쉽게 풀 수 있는 문제

    // ex) 9 / 120 125 152 130 135 135 143 127 160 -> 3 8 (철수 152 짝꿍 127)
    // ex) 6 / 120 130 150 150 130 150 -> 3 5

    //arr에 넣고 tmp에 복사해놓음. 그리고 오름차순으로 정렬 i부터 쭉 돌면서 arr[i] tmp[i] 비교해서 다른걸 찾아야함
    // 자리를 안바꾼 학생은 그대로 있을 것이며, 자리를 바꾼 학생은 arr과 tmp가 다를 것임.
    // 다른거 두개 출력해버리면 철수와 짝꿍이 걸림.


  public ArrayList<Integer> solution(int n, int[] arr) {
       ArrayList<Integer> answer = new ArrayList<>();
       int[] tmp = arr.clone(); // deep copy
      Arrays.sort(tmp);
      for(int i=0; i<n; i++) {
          if(arr[i] != tmp[i]) answer.add(i+1);
      }

        return answer;
    }

    public static void main(String args[]) {
        Child_6 T = new Child_6();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }

    }
}
