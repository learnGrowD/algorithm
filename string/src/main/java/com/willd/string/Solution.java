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

    /*
    문제) 문자열: 문자열 다루기 기본
    Tip) 범위 판단
     */

    public static boolean sol9(String s) {
        char[] chars = s.toCharArray();

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] >= 'A' && chars[i] <= 'z') {
                result = false;
            }
        }
        return result;


//        // 문자열의 길이가 4 또는 6인지 확인
//        if (s.length() != 4 && s.length() != 6) {
//            return false;
//        }
//
//        // 문자열이 숫자로만 구성되어 있는지 확인
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (c < '0' || c > '9') {
//                return false;
//            }
//        }
//
//        return true;
    }
    /*
    문제) 문자열: 신규 아이디 추천
    문자열은 패턴 매칭에 대해서 알아야 한다.
    Tip)
    1.	문자 클래스: 대괄호 [] 안에 문자를 나열하여 일치시킬 문자의 집합을 정의합니다.
    •	[abc]: ‘a’, ‘b’, ‘c’ 중 하나의 문자와 일치
	•	[a-z]: ‘a’부터 ‘z’까지의 소문자 중 하나와 일치
	•	[A-Z]: ‘A’부터 ‘Z’까지의 대문자 중 하나와 일치
	•	[0-9]: 숫자 ‘0’부터 ‘9’까지 중 하나와 일치
	•	[^...]: 대괄호 안에 나열된 문자 외의 문자와 일치

    2.	특수 문자:
	•	.: 모든 문자와 일치
	•	\\: 이스케이프 문자
	•	\\d: 숫자와 일치 (0-9와 동일)
	•	\\D: 숫자가 아닌 문자와 일치
	•	\\w: 영숫자 문자와 일치 (a-z, A-Z, 0-9, _)
	•	\\W: 영숫자가 아닌 문자와 일치
	•	\\s: 공백 문자와 일치 (스페이스, 탭, 줄 바꿈)
	•	\\S: 공백이 아닌 문자와 일치

	3.	경계:
	•	^: 문자열의 시작을 의미
	•	$: 문자열의 끝을 의미
	•	\\b: 단어 경계를 의미
	•	\\B: 단어 경계가 아님을 의미

	4.	반복:
	•	*: 0회 이상 반복
	•	+: 1회 이상 반복
	•	?: 0회 또는 1회 반복
	•	{n}: 정확히 n회 반복
	•	{n,}: n회 이상 반복
	•	{n,m}: n회 이상 m회 이하 반복

    // 문자열 패턴
    // 문자열 대체 replaceAll(); -> 패턴 매칭 사용가능
    	// 문자열 pattern matching: matches

	// *** 문자열 자르기 substring()
	// 문자열 자르기 split("")

	// 문자열 charAt();
	// 문자열 toCharArray();

	// 문자열 공백 제거 trim()

	// 문자열 변환 toUpperCase(), toLowerCase()
	// 문자열 변환 replace()

	// 문자열 검색 indexOf(String str)
	- 처음으로 문자열 str 등장하는 index 반환

	//compareTo(String anotherString): 두 문자열을 사전 순으로 비교합니다.
	주체가 (str1)이 비교 대상의 (str2)에 사전순으로 뒤에 있느냐?
	Ex)
	String str1 = "apple";
    String str2 = "banana";
    String str3 = "apple";


    // compareTo(String anotherString) 메서드를 사용하여 문자열 비교
    int result1 = str1.compareTo(str2);
    System.out.println("str1.compareTo(str2): " + result1); // 출력 결과: 음수 (-1)

    int result2 = str2.compareTo(str1);
    System.out.println("str2.compareTo(str1): " + result2); // 출력 결과: 양수 (1)

    int result3 = str1.compareTo(str3);
    System.out.println("str1.compareTo(str3): " + result3); // 출력 결과: 0

	예제) "\\bword\\b|^Hello|world$|\\Bword\\B"
	예제) "\\d{3}\\s\\w+\\s\\S+\\s\\."

	숫자 0 -> 48
	'A' -> 65
	'a' -> 97
     */
    public static String sol10(String new_id) {
        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");

        new_id = new_id.replaceAll("\\.{2,}", ".");

        new_id = new_id.replaceAll("^\\.|\\.$", "");

        if (new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }

        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }



}
