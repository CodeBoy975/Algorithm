package com.yao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 题目描述：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author pengjie_yao
 * @date 2020/8/26 16:05
 */
public class leetcode17letterCombinations {


    public static List<String> letterCombinations(String digits) {
        // 1.将数字的组合存入map中
        List<String> combinations = new ArrayList<>();
        // 空判断
        if (digits.length() == 0) {
            return combinations;
        }
        // 存入map中
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        // 2.回溯
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * @param combinations 存储的结果
     * @param phoneMap     数字下的组合map
     * @param digits       输入的数字符串
     * @param index        数字的下标
     * @param combination  拼接的组合字符串
     */
    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {

        // 递归的结束条件，当遍历到的下标等于输入的字符串长度，则停止递归。直接拼接好放入集合中
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 获取输入字符串下的第一个数字
            char digit = digits.charAt(index);
            // 从map中获取数字下的字母组合
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 遍历数字下的字母组合
            for (int i = 0; i < lettersCount; i++) {
                // 进行可能组合的拼接 a
                combination.append(letters.charAt(i));
                // 对于2中的a,然后遍历3中的组合组合，来进行拼接
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 删除  ab -> a ,继续回溯组合
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings.toArray().toString());
    }
}
