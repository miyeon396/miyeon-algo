package com.example.codete.section5StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hospital_8 {

    // 메디컬 병원 응급실에는 의사가 한 명 밖에 없음
    // 응급실은 환자가 도착한 순서대로 진료를 진행
    // 위험도가 높은 환자는 빨리 응급 치려를 의사가 해야함.
    // 진료 우선순위
    // 1. 환자가 접수한 순서대로 목록에서 제일 앞에 있는 환자 목록을 꺼냄
    // 2. 나머지 대기 목록에서 꺼낸 환자보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣음. 그렇지 않으면 진료를 받음.
    // -> 대기 목록에 자기보다 위험도가 높은 환자가 없을 때 자신이 진료받는 구조

    // N명의 환자가 대기목록에 있음
    // N명의 대기 목록 순서의 환자 위험도가 주어지면 대기 목록 상의 M번째 환자는 몇 번쨰로 진료를 받는지 출력하는 프로그램
    // 대기 목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것.

    // 첫줄에 자연수 N과 M
    // 두번째 줄에 환자의 위험도 (위험도가 높을 수록 위험)
    // -> M번째 환자의 몇 번째로 진료받는지 출력. 5 2 / 60 50 70 80 90 -> 3  | 6 3 / 70 60 90 60 60 60 -> 4

    // queue 사용 (0, 60) (1, 50) (2, 70) (3, 80) (4, 90) -> (번째, 위험도)

    class Person {
        int id;
        int priority;
        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public int solution(int n, int m, int[] arr) {
        // n : 몇 명, m : 몇 번 놈, arr : 우선순위
        int answer = 0;
        Queue<Person> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            q.offer(new Person(i, arr[i])); //순서 , 걔의 위험도
        }

        while(!q.isEmpty()) {
            Person tmp = q.poll(); // 하나를 꺼내서 tmp라는 사람이 진료를 받을 수 있는지 없는지 체크
            for(Person x : q) {
                if(x.priority > tmp.priority) { //대기에 있는 놈이 더 높으면 다시 넣어라
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }

            if(tmp != null) { //tmp에 걔가 젤 우선순위가 높은애면
                answer++; // 몇 번째인지 체크하는 값임.
                if(tmp.id == m) {  // 우리가 구하는 애랑 같으면 끝
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        Hospital_8 T = new Hospital_8();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, m, arr));

    }
}
