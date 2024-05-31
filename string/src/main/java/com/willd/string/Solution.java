package com.willd.string;

import java.util.Map;

public class Solution {

    public static void main(String[] args) {

    }

    /*
    문제: 자연수 뒤집어 배열로 만들기
    Tip)
    숫자 각각의 것을 판단해야 한다면 문자열 문제이다.
    주요 개념:
    1) primitive and reference type 은 호환이 가능하다.
    ex) Long long = 10L, Integer int = 10
    2) primitive 형변환: (int), (flot), (double), (long), (char)
    3) reference 형볂롼: xxxValue()
    참고)
     Integer i = (int) 'A' // 65
     Character c = 65; // 'A'
    ----
    1) String -> int, long, flot, double, char: XXX.parseXXX() 사용
    참고) 주요 String 연산자: length, charAt, toCharArray, split, replace, startWith
    2) int, long, flot, double, char -> String: String.valueOf() 함수 사용
    3) 문자열 뒤집기: new StringBuilder("HELLO").revers().toString();
    4) char 그 숫자 그대로 출력하기 -> Character.getNumericValue('1'); // 결과 1
     */
    public static int[] sol(long n) {

//        Integer ib = 10;
//        Integer ic = Integer.parseInt("10");
//
//        ic.doubleValue();
//        ic.floatValue();
//        ic.longValue();
//
//        Long lb = 10L;
//        Long lc = Long.parseLong("10");
//
//        lc.intValue();
//        lc.doubleValue();
//        lc.floatValue();
//
//
//        String a = String.valueOf(10);
//        String.valueOf(10L);
//        String.valueOf(10F);
//        String.valueOf(3.3F);
//        String.valueOf('c');
//
//        a.length();
//        a.charAt(0);
//        a.toCharArray();
//        a.split("");
//        a.replace("", "");
//        a.startsWith("");
//
//        new StringBuffer("HELLO").reverse().toString();

//        Integer i = Character.getNumericValue('1'); // 결과 1

//        Integer aka = (int) 'A'; // 'A' -> 65 변환
//        Character bka = 65; // 65 -> 'A' 변환

        String reverseStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        char[] chars = reverseStr.toCharArray();

        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i ++) {
            result[i] = Character.getNumericValue(chars[i]);
        }

        return result;
    }

    /*
    문제: 시저 암호
    Tip )
     문자열 -> 배열로 변환
     char + 숫자 더하기
     경계 파악하기
    주요 개념)
    1. char[] to String: String.valueOf(chars);
     */
    public static String sol2(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (chars[i] + n > 'Z') {
                    chars[i] = (char) ('A' + ((chars[i] + n) - 'Z' - 1));
                } else {
                    chars[i] = (char) (chars[i] + n);
                }
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                if (chars[i] + n > 'z') {
                    chars[i] = (char) ('a' + ((chars[i] + n) - 'z' - 1));
                } else {
                    chars[i] = (char) (chars[i] + n);
                }
            }
        }
        return String.valueOf(chars);
    }

    /*
    문제) 문자열: 이상한 문자 만들기
    Tip)
    기준이 달라진다면 반목문 밖의 기준 변수를 생각하라 (* 초기화 해주는 것이 핵심)
    짤랐다가 다시 붙여주는것이 더 힘들다 그 상태로 해결 할 수 있는 방법이 있는가
     */
    public static String sol3(String s) {
        char[] chars = s.toCharArray();

        int sd = 0;
        for (int i = 0; i < chars.length; i ++) {
            if (String.valueOf(chars[i]).equals(" ")) {
                sd = 0;
                continue;
            }
            if (sd % 2 == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            sd ++;
        }
        return String.valueOf(chars);
    }

    /*
    문제) 문자열: 문자열 압축
    Tip)
    정리)
    Math.round() -> 반올림
    Math.ceil() -> 무조건 올린다.
    Math.floor() -> 무조건 내린다.

    절대값
    Match.abs()
    Match.min()
    Match.max()

    제곱근 구하기 (square root)
    Match.sqrt(25) 루트 25 -> 5.0

    거듭제곱 구하기
    Match.pow(2, 3) 2의 3제곱

    삼각함수
    Math.sin(Match.PI / 6) sin(30도)
    Math.cos(Match.PI / 3); cos(60도)
    Match.tan(Match.PI / 4); tan(45도)


     */
    public static int sol4(String s) {
        int result = 0;
        for (int i = 2; i <= s.length() / 2; i ++) {
            int size = (int) Math.ceil((double) s.length() / i);
            List<String> compares = new ArrayList<>();
            for (int j = 0; j < size; j += i) {
            }
        }
        return result;
    }

    /*
    문제) 문자열: 3진법 뒤집기
    Tip)
    1. 숫자를 3진법으로 변환
    2. 문자열 치환 뒤집기
    3. 뒤집은 문자열 10진법으로 변환

    정리)
    1. 10진법 -> 3진법으로 치환하는 방법
    2. 3진법 -> 10진법으로 치환하는 방법
    3. 문자열 뒤집기: StringBuilder("HELLO").revers.toString();
     */
    public static int sol5(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;

        }
        char[] chars = sb.reverse().toString().toCharArray();
        //1200
        int result = 0;
        for (int i = chars.length - 1; i >= 0; i --) {
            Integer num = Character.getNumericValue(chars[i]);
            Integer power = 1;
            for (int j = 1; j <= i; j++) {
                power *= 3;
            }
            result += power * num;
        }
        return result;
    }

    /*
    문제) 이진 변환 반복하기
    Tip)
    1. 반복문이 종료되는 경계를 찾는다.
    2. 반복문을 실행한다는 것은 변환을 하는 행위로 간주 할 수 있다. -> 증가
    3. replace 했을때 변환한 새로운 String 알 수 있다.
    4. 이 길이를 통해서 0의 개수를 증가한다.
    5. s를 초기화 하여 조건에 한번더 태운다. 그리고 이 과정을 반복한다.
     */
    public static int[] sol6(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            answer[0] += 1;

            String replaceStr = s.replace("0", "");
            answer[1] += s.length() - replaceStr.length();

            s = Integer.toBinaryString(replaceStr.length());
        }

        return answer;
    }

    /*
    문제) 문자열 내 p와 y의 개수
    Tip)
    1. 모두 소문자로 치환한다.
    2. p를 뽑아낸다.
    3. y를 뽑아낸다.
     */
    // 다시 한번 보자 다른 아이디어를 통해 문제를 풀 수 있어야 한다.
    // 지금 현재 완전 탐색만 진행하고 있다.
    public static boolean sol7(String s) {
        String lowStr =s.toLowerCase();
        int[] arr = new int[2];

        String[] strs = lowStr.split("");

        for (int i = 0; i < lowStr.length(); i ++) {
            if (strs[i].equals("p")) {
                arr[0] += 1;
            } else if (strs[i].equals("y")) {
                arr[1] += 1;
            }
        }
        if (arr[0] == 0 && arr[1] == 0) {
            return true;
        }
        return arr[0] == arr[1];
    }

    public static int sol8(String s) {
//        String[][] compares = new String[][] {
//                {"zero","0"},
//                {"one","1"},
//                {"two","2"},
//                {"three","3"},
//                {"four","4"},
//                {"five","5"},
//                {"six","6"},
//                {"seven","7"},
//                {"eight","8"},
//                {"nine","9"},
//        };
//        for (String[] strs: compares ) {
//            s = s.replace(strs[0], strs[1]);
//        }
//        return Integer.parseInt(s);

        String[] strArr = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };

        for (int i = 0; i < strArr.length; i++) {
            s = s.replace(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);

    }



}
