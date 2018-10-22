package com.tjlcast.Interview_Code.wangyi_youdao;

import java.util.*;

/**
 * @author by tangjialiang
 *         时间 2018/9/28.
 *         说明 ...
15 10
DZFDFZDFDDDDDDF
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        Long n = Long.parseLong(s1.split(" ")[0]);
        Long k = Long.parseLong(s1.split(" ")[1]);
        String s2 = scanner.nextLine();

        HashMap<Character, Long> counts = new HashMap<>();
        for (Character c : s2.toCharArray()) {
            Long orDefault = counts.getOrDefault(c, 0L);
            counts.put(c, orDefault+1);
        }

        PriorityQueue<Map.Entry<Character, Long>> integerCharacterTreeMap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Long>>() {
            @Override
            public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                return (int)(o2.getValue() - o1.getValue());
            }
        });
        for (Map.Entry<Character, Long> entry : counts.entrySet()) {
            integerCharacterTreeMap.add(entry);
        }

        Long total = 0L;
        for (Map.Entry<Character, Long> entry : integerCharacterTreeMap) {
            Long time = entry.getValue();
            if (k >= time) {
                total += (time * time);
                k -= time;
            } else {
                total += (k * k);
                k = 0L;
            }
        }

        System.out.println(total);
    }
}
