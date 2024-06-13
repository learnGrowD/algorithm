package com.willd.exhaustivesearch;

import java.lang.invoke.CallSite;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        List<List<Integer>> list2 = new ArrayList<>();
//        permutation(new ArrayList<>(), new int[]{1, 2, 3}, list2);
//        System.out.println(list2);

//        permutation(new ArrayList<>(), new int[]{1, 2, 3}, 3, new ArrayList<>());
//        combine(new ArrayList<>(), new int[]{1 ,2 ,3}, 2, 0, new ArrayList<>()); // r => 조합의 길이, 2개를 뽑갰다.
//        combine("", "abc", 2, 0, new ArrayList<>());
    }

    /*
    문제) 완점탐색: 모의고사
    정리)
    1. ArrayList to Array
    2. Map To ArrayList
    3. Set To ArrayList
     */
    public int[] sol1(int[] answers) {
        int[] per = new int[]{1, 2, 3, 4, 5};
        int[] per2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] per3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int[] oks = new int[]{0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == per[i % 5]) {
                oks[0]++;
            }

            if (answers[i] == per2[i % 8]) {
                oks[1]++;
            }

            if (answers[i] == per3[i % 10]) {
                oks[2]++;
            }
        }

        int maxScore = Math.max(oks[0], Math.max(oks[1], oks[2]));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < oks.length; i++) {
            if (oks[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    /*
    문제 2) 카펫
    Tip) 방정식을 세우면 가장 좋다.
    방정식을 세우고 방정식을 푸는 방법은 대입이다.
     */
    public int[] sol2(int brown, int yellow) {
        int total = brown + yellow;
        for (int width = 1; (double) total / (double) width >= 1; width++) {
            double height = (double) total / (double) width;
            if (height - Math.ceil(height) > 0) {
                continue;
            }
            if (yellow == (width - 2) * (height - 2)) {
                return new int[]{(int) height, width};
            }
        }
        return null;
    }

    /*
    소수 문제
     */
    public int sol3(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 순열
    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if (!prefix.isEmpty()) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }

    // 순열
    public static void permutation(List<Integer> prefix, int[] nums, List<List<Integer>> permutations) {
        if (prefix.size() == nums.length) {
            permutations.add(new ArrayList<>(prefix));
            return;
        }
        for (int num : nums) {
            if (!prefix.contains(num)) {
                prefix.add(num);
                permutation(prefix, nums, permutations);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    // 조합
    public static void combine(String prefix, String str, int r, int start, List<String> combines) {
        if (r == 0) {
            combines.add(prefix);
            return;
        }
        for (int i = start; i < str.length(); i++) {
            combine(prefix + str.charAt(i), str, r - 1, i + 1, combines);
        }
    }

    public static void combine(List<Integer> prefix, int[] nums, int r, int start, List<List<Integer>> combines) {
        if (r == 0) {
            combines.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            prefix.add(nums[i]);
            combine(prefix, nums, r - 1, i + 1, combines);
            prefix.remove(prefix.size() - 1);
        }

    }


}
