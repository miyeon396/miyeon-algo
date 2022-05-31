package com.example.codete.section6SortSearch;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideoDecisionAlgorithm_9 {

    // 가수의 A의 라이브 동영상을 DVD로 만들어 판매하려고 한다.
    // DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지 되어야한다.
    // 순서가 바뀌는 것을 가수분이 굉장히 싫어하심.
    // 1번 노래 5번 노래 같은 DVD에 녹화하기 위해서는 1번과 5번 사의 모든 노래도 같은 DVD에 녹화해야한다.
    // 또한 한 노래를 쪼개서 두 DVD에 녹화하면 안된다.
    // 업체 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
    // M개 DVD에 모든 동영상을 녹화하기로 하였다.
    // 이때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
    // M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야함

    // 입력 설명
    // 첫줄 N개 곡(1<=N<=1000), M개DVD(1<=M<=N) / 다음줄 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로 주어짐 (곡 길이 10000분 안넘음)
    // 첫번째 줄부터 DVD의 최소 용량 크기를 출력
    // 9 3 / 1 2 3 4 5 6 7 8 9 -> 17
    // -> 3개의 DVD 용량이 17분짜리면 12345 67 89 이렇게 3개의 DVD로 녹음을 할 수 있다. 17분 용량보다 작은 용량으로는 3개의 DVD에 모든 영상을 녹화할 수 없다.???

    // 결정 알고리즘 -> 이분 검색을 이용하는 방법
    // 순서를 유지하면서 3장에 담아낼 수 있는 최소한의 분 구하는 것
    // lt부터 rt사이에서 우리가 찾고자 하는 답이 확실하게 있따 할 때 쓰는
    //곡들의 순서가 바뀌면 안됨. lt 9(가장큰값) / rt 45(전체 분을 더한 값) -> 이 사이에 무조건 값이 있다! 확실한 값
    // -> mid를 찾아라 -> 27 2장에까지 담을 수 있음 그렇단 이야기는 3장도 가능함 -> 최솟값을 찾으니 뒤에는 날리고 27보다 작은 곳을 찾기 시작. rt=26이됨 -> 9~26사이 체크 현재 답은 27이고, 저기서 더 좋은 답을 찾아라
    // -> 9 26의 mid -> 17 3장 됨. 27보다 더 좋음 answer이 17로 바꿈 -> 더 좋은 답이 있나 찾음 rt 16으로 바뀌고 9~16 사이 값 체크 -> 12네 5장이 필요함 -> lt 13 ~ rt 16 다시 체크
    // -> 이런게 반복되며 lt<=rt까지 구해서 답을 찾는 것

    public int count(int[] arr, int capacity) { //capa : dvd 용량 이거 일 때, 몇 장 가능하다 리턴하는 메서드
        int cnt = 1; //dvd 장수
        int sum = 0;
        for(int x : arr) {
            if(sum+x > capacity) {
                cnt++; //새로운 장이 필요하다
                sum=x; //새로운 놈부터 다시 시작
            } else {
                sum+=x;
            }
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); //최댓값
        int rt = Arrays.stream(arr).sum(); //전체 합

        while(lt<=rt) {
            int mid = (lt+rt) / 2;
            if(count(arr, mid) <= m) { //m이 3일 때 2장으로 가능하다면 당연히 3장으로도 가능한 것
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        MusicVideoDecisionAlgorithm_9 T = new MusicVideoDecisionAlgorithm_9();
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
