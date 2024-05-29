package com.willd.string;

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
}
