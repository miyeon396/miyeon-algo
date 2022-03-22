package com.example.codete.section1string;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplStr {
    //소문자 중복 제거. 입력시 원래 처음 존재했던 순으로 출력
    // asdaasdsfk -> asdfk
    // 짜개서 indexOf 사용 -> indexOf가 본인 것과 다르다 -> 처음이 아닌다 중복이다. (같으면 난 새거라 더할거야)

    public String solution(String str) {
        String answer = "";
        for(int i=0; i<str.length(); i++) {
            System.out.println(str.charAt(i)+ " "+ i + " " + str.indexOf(str.charAt(i)));

            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }

        //방법2 스트림써서 distinct 해버리는 법 어렵다.
        Character[] charObjectArray =
            str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        Stream<Character> characterStream = Arrays.stream(charObjectArray).distinct();
        String result2 = characterStream.map(String::valueOf).collect(Collectors.joining());
        String result3 = Arrays.stream(charObjectArray).distinct().map(String::valueOf).collect(Collectors.joining());
        System.out.println(result2+"="+result3);

        return answer;
    }

    public static void main(String args[]) {
        RemoveDuplStr T = new RemoveDuplStr();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));

    }
}
