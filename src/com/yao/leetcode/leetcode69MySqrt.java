package com.yao.leetcode;

/**
 * leetcode69: x的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author pengjie_yao
 * @date 2020/8/25 9:59
 */
public class leetcode69MySqrt {

    public int mySqrt(int x) {
        // 1.如果为0或者1，则直接返回
        if (x == 0 || x == 1) {
            return x;
        }
        // 2.初始化左右界，循环的开始，左边小于右边
        int left = 1;
        int right = x;
        int result=-1;
        while (left <= right) {
            // 2.1 取左右界的中间值作为m
            int m = (left + right) / 2;
            // 2.2 判断m == x/m,这里用除法是为了防止数字过大导致越界出现负数
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                right = m - 1;
            } else {
                left = m + 1;
                result = m;
            }
        }
        return result;
    }

    public static float mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        float left = 1;
        float right = x;
        float result = -1;
        while (left<=right) {
            float m = (left + right) / 2;
            if (m == x / m) {
                return  m;
            } else if (m > x / m) {
                right = m;
            }else {
                left = m;
                result = m;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        mySqrt1();
        System.out.println(mySqrt1(8));
    }
}
