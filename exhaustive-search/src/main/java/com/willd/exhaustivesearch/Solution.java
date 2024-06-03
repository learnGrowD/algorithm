package com.willd.exhaustivesearch;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

    }

    /*
    문제) 완점탐색: 모의고사
    정리)
    1. ArrayList to Array
    2. Map To ArrayList
    3. Set To ArrayList
     */
    public int[] sol1(int[] answers) {
        int[] per = new int[] {1, 2, 3, 4, 5};
        int[] per2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] per3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int[] oks = new int[] {0, 0, 0};
        for (int i = 0; i < answers.length; i ++) {
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
        for (int width = 1; (double) total / (double) width >= 1; width ++) {
            double height = (double) total / (double) width;
            if (height - Math.ceil(height) > 0) {
                continue;
            }
            if (yellow == (width - 2) * (height - 2)) {
                return new int[] {(int) height, width};
            }
        }
        return null;
    }


}
