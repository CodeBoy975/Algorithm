package com.yao.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode350: 两个数的交集
 * 题目：
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * @author pengjie_yao
 * @date 2020/8/21 11:00
 */
public class TwoNumberIntersection {


    /**
     * 哈希映射法
     * 两个数的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length >= nums2.length ? nums2.length : nums1.length];
        // 1.比较两个数组的大小,让小的数组进行哈希映射
        if (nums1.length >= nums2.length) {
            // 替换
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 2.遍历小的数组，放入map中
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) != null) {
                Integer count = map.get(nums1[i]);
                map.put(nums1[i], ++count);
            } else {
                map.put(nums1[i], 1);
            }
        }
        // 3.遍历数组
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                Integer count = map.get(nums2[i]);
                if (count > 0) {
                    result[j] = nums2[i];
                    j++;
                    count--;
                    map.put(nums2[i], count);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, j);
    }


    public static void main(String[] args) {

        int[] num1 = new int[]{4, 9, 5};
        int[] num2 = new int[]{9,4, 9, 8, 4};

        int[] intersect = intersect(num1, num2);
        System.out.println(intersect
        );
    }
}
