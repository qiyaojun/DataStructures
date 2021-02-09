package com.qyj.recursion;

/**
 * @Auther YaoJun Qi
 * @Date 2021/02/08 16:35
 * @description
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static void test(int n){
        if(n > 2){
            test(n - 1);
        }
        System.out.printf("n=%d\n",n);
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else {
            return factorial(n - 1) * n;
        }
    }
}
