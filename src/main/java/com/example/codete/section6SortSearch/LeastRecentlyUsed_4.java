package com.example.codete.section6SortSearch;

import java.util.Scanner;

public class LeastRecentlyUsed_4 {

    // 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로 CPU가 처리할 작업을 저장해 놓았다가 필요할 때 바로 사용해서 처리 속도 높이는 장치
    // 비싸고 용량 작아 효율적 사용 필요
    // 철수 컴퓨터는 캐시 메모리 사용 규칙이 LRU 알고리즘 따름
    // LRU : Least Recently Used의 약자로 가장 최근에 사용 되지 않은 것
    // 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거한다는 알고리즘

    // ex) 캐시 사이즈 5 / 작업 2 3 1 6 7 순 (맨 앞이 가장 최근에 쓰인 작업, 맨 뒤 가장 오랫동안 쓰이지 않은 작업)
    // Cache Miss : 해야할 작업이 캐시에 없는 상태로 위상태에서 만약 새로운 작업인 5번 작업을 CPU가 사용한다면 Cache Miss가 되고 모든 작업이 뒤로 밀리고 5번이 캐시 맨앞. 7은 삭제
    // 5 2 3 1 6
    // Cache Hit : 해야할 작업이 캐시에 있는 상태. 위 상태에서 만약 3번 작업을 CPu가 사용하게 되면 Cache는 Hit가 되고, 6 3 번 앞에 있는 5 2 작업은 한칸 밀리고 3이 맨 앞
    // -> 5 2 3 1 6 -> 3 5 2 1 6

    // 캐시의 크기가 주어지고 캐시가 비어있는 상테에서 N개의 작업을 CPU가 차례대로 처리한다면 N개의 작업을 처리한 후
    // 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램 작성
    // 첫줄 캐시 크기. 작업 개수 / 두번째 줄 작업 번호
    // ex) 5 9 / 1 2 3 2 6 2 3 5 7 -> 7 5 3 2 6

    // 배열을 하나 만들어서 ArrayList (삽입 정렬)
    // cache array 5로 만듦.
    // i는 4번째(0부터니까)부터 앞으로 오면서 하나씩 채워 넣음. 그때 c[i] = c[i-1]꺼를 복사해서 넣음(뒤로 하나씩 미는 것.) -
    // 이때 미스면 넣는 것. 히트가 났다면 히트난 지점부터 for 문 돌면서 c[i] = c[i-1] 다시

    // ex) 캐시의 메모리 상태 변화
    // 1 0 0 0 0
    // 2 1 0 0 0
    // 3 2 1 0 0
    // 2 3 1 0 0
    // 6 2 3 1 0
    // 2 6 3 1 0
    // 5 3 2 6 1
    // 7 5 3 2 6

    public int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for(int x: arr) {
            int pos = -1; //hit냐 miss냐 체크
            for(int i=0; i<size; i++) {
                if(x == cache[i]) {
                    pos = i;
                }
            }
            if(pos == -1) { //mis인 경우 쭉 하나씩 뒤로 이동하면서 맨 앞에 새로운 것 넣음
                for(int i=size-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            } else { //hit인 경우 pos를 앞으로 끌어 낼 거니까 pos부터 뒤로 하나씩 이동하면서 맨 앞에 x 넣음.
                for(int i=pos; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x; //맨 앞에 set하는건 mis나 hit나 같기 때문
        }

        return cache;
    }

    public static void main(String args[]) {
        LeastRecentlyUsed_4 T = new LeastRecentlyUsed_4();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int x : T.solution(s, n, arr)) {
            System.out.println(x+ " ");
        }


    }
}
