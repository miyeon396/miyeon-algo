package com.example.codete.section6SortSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SelectHorseHouseDecisionAlgorithm_10 {

    // N개의 마구간이 수직 선상에 있음. 각 마구간은 x1, x2, x3, ..., xN의 좌표를 가짐
    // 마표 구간간에 좌표가 중복되는 일은 없음
    // C마리의 말을 가지고 있는데 이 말들은 서로 가까이 있는거 싫어함
    // 각 마구간에는 한마리 말만 넣을 수 있고 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶음
    // C마리의 말을 N개의 마구간에 배치 했을 때, 가장 가까운 두 말의 거리가 최대가 되는 그 최댓값을 출력하는 프로그램

    // 입력 예제
    // 첫줄 자연수 마구간N(3<=N<=200000), 말마리C(2<=C<=N) 공백을 사이에 두고 주어짐
    // 둘째줄 마구간 좌표 xi(0<=xi<=1000000000)가 차례로 주어짐
    // 첫줄에 가장 가까운 두 말의 최대 거리
    // ex) 5 3 / 1 2 8 4 9 -> 3

    // 좌표는 정렬되서 들어오진 않음. 우리가 정렬해야함.
    // 첫번째 마구간 1 두번째 마구간 2 세번째 마구간 4 네번째 마구간 8 다섯번째 마구간 9 일케 되어 있음
    // lt, rt 놓고 두 말사이의 거리가 젤 작은거 1=lt, 젤 큰거 rt=9 -> mid=5 가장가까운거리가 5라고놓고 3마리를 배치해보는 것 -> 몇마리 가능한지 구하는 메서드에서 체크 -> 안되네?
    // 거리가 더 큰쪽은 안되니까 5보다 작은 쪽으로 다시 체크 rt를 mid-1 줄임 lt=1, rt=4 mid=2 체크하니 3마리 되네 일단 넣어둠.
    // 근데 우린 더 좋은 답을 찾는거니까 그 앞쪽은 다 날리고 mid+1=3을 lt로 놓고 다시 체크 lt=3, rt=4 -> mid=3 -> 3으로 되나 체크 되네 -> 3이 answer로 바꿈
    // -> 나중에 유효한 값으로 answer를 바꿔나감

    public int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }


    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(count(arr,mid) >= c) { // 더 크거나 같으니 작은쪽은 날리고 더 뒷쪽에서 비교
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1; // 더 작으니 큰쪽은 날리고 앞쪽에서 비교
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        SelectHorseHouseDecisionAlgorithm_10 T = new SelectHorseHouseDecisionAlgorithm_10();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 마구간 개수
        int c = scanner.nextInt(); // 말 마리수
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, c, arr));

    }
}
