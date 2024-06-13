package com.willd.sort;


import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3};
//        int[] arr2 = Arrays.copyOfRange(arr, 0, 3);
//        for (int a: arr2) {
//            System.out.println(a);
//        }

    }


    public int[] sol1(int[] arr, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            List<Integer> sortArr = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                sortArr.add(arr[i]);
            }
            Collections.sort(sortArr);
            result.add(sortArr.get(command[2] - 1));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int[] sol_1(int[] array, int[][] commands) {
        int[] aswer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            //substring 같은 원리
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            aswer[i] = temp[commands[i][2] - 1];
        }
        return aswer;
    }

    public int[] sol2(int[] numbers) {
        Set<Integer> sumSet = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[sumSet.size()];
        int index = 0;
        for (int num : sumSet) {
            answer[index++] = num;
        }
        return answer;
    }

    public int[] sol_2(int[] numbers) {
        Set<Integer> resultSet = new HashSet<>();
        combine(numbers, 0, 2, new int[2], resultSet);

        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public String sol3(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String sol_3(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new StringBuilder(String.valueOf(chars)).reverse().toString();
    }

    public String[] sol4(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);
            if (c1 == c2) {

                // s1이 s2보다 사전순으로 앞에 있느냐?
                // 아니다 -> -1
                // 맞다 -> 1
                // 사전순으로 같으면 0 반환

                // 이것의 원리는 사전순으로 나열
                return s1.compareTo(s2);
            } else {
                return c1 - c2;
            }
        });
        return strings;
    }

    /*
    문제) 정렬: 가장큰수
     */
    public String sol5(int[] numbers) {
        String[] nums = new String[numbers.length];
        int index = 0;
        for (int num : numbers) {
            nums[index++] = String.valueOf(num);
        }

        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();

        for (String num : nums) {
            sb.append(num);
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public boolean sol6(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public String sol7(String my_string) {
        Set<String> set = new LinkedHashSet<>();
        String[] chars = my_string.split("");

        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String sol_7(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (!answer.contains(String.valueOf(my_string.charAt(i)))) {
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }

    public int sol8(String before, String after) {
        char[] beforeChars = before.toCharArray();
        Arrays.sort(beforeChars);
        char[] afterChars = after.toCharArray();
        Arrays.sort(afterChars);
        for (int i = 0; i < beforeChars.length; i++) {
            if (beforeChars[i] != afterChars[i]) return 0;
        }
        return 1;
    }

    public int sol9(int[] numbers) {
        Set<Integer> all = new HashSet<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            set.add(num);
        }
        all.removeAll(set);

        int result = 0;
        for (int num : all) {
            result += num;
        }
        return result;
    }

    public String sol10(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) == 1) {
                return name;
            }
        }
        return "";
    }

    public boolean sol11(String s) {
        int cnt = 0;
        String[] chars = s.split("");

        for (int i = 0; i < s.length(); i++) {
            if (chars[i].equals("(")) {
                cnt++;
            } else if (chars[i].equals(")")) {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

    public int sol12(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String newString = s.substring(i) + s.substring(0, i);
            if (isValid(newString)) {
                count++;
            }
        }

        return count;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /*
    Tip)
    0. 문제 충분히 이해하기 [예시 많이 들어보기, 가능한 케이스, 불가능한 케이스]
    1. 유형 생각하기
    2. 자료구조 생각하기 [1개, 2개, 3개] / [List, Map, Set, Stack, Queue, Heap, Tree, 나만의 자료형]
    3. 예시 많이 들어보기 [테스트 케이스 많이 돌려보기
     */

    public int[] sol13(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i ++) {
            if (i == prices.length - 1) {
                result[i] = 0;
                break;
            }
            for (int j = i + 1; j < prices.length; j ++) {
                result[i] += 1;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return result;
    }

    public int[] sol14(int[] progresses, int[] speeds) {
        // [7, 3, 9]
        // [5, 10, 1, 1, 20, 1]
        int[] nums = new int[progresses.length];
        for (int i = 0; i < progresses.length; i ++) {
           nums[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }

        List<Integer> list = new ArrayList<>();
        int temp = 0;
        int cnt = 1;
        for (int i = temp; i < nums.length; i ++) {
            for (int j = temp + 1; j < nums.length; j ++) {
                if (nums[temp] >= nums[j]) {
                    cnt ++;
                    if (j == nums.length - 1) {
                        temp = j;
                        break;
                    }
                } else {
                    list.add(cnt);
                    cnt = 1;
                    temp = j;
                    break;
                }
            }
        }

        list.add(cnt);

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] sol15(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i ++) {
            if (operations[i].equals("D 1")) {
                if (!max.isEmpty()) {
                    Integer maxNum = max.poll();
                    min.remove(maxNum);
                }
            } else if (operations[i].equals("D -1")) {
                if (!min.isEmpty()) {
                    Integer minNum = min.poll();
                    max.remove(minNum);
                }
            } else if (operations[i].startsWith("I ")) {
                Integer num = Integer.parseInt(operations[i].substring(2));
                max.add(num);
                min.add(num);
            }
        }

        if (min.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{max.peek(), min.peek()};
    }

    private void combine(int[] numbers, int start, int r, int[] result, Set<Integer> set) {
        if (r == 0) {
            set.add(result[0] + result[1]);
            return;
        }
        for (int i = start; i <= numbers.length - r; i++) {
            result[result.length - r] = numbers[i];
            combine(numbers, i + 1, r - 1, result, set);
        }
    }
}
