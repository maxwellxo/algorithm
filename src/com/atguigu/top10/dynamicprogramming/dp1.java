package com.atguigu.top10.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;

/*
 * 动态规划问题01背包问题。
 * 输入重量，价格数组，以及背包容量大小。返回背包能装的最佳价值数字
 * 进阶：将物品的存放情况一并返回
 * */
public class dp1 {
    public int solution(int weight[], int value[], int size) {
        int Length = weight.length;
        int path[][] = new int[Length + 1][size + 1];
        int dp[][] = new int[Length + 1][size + 1];
        for (int i = 0; i < Length + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                //第一行第一列为零
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                //若当前物品重量大于最大容量
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                //若当前物品重量小于最大容量
                if (weight[i - 1] <= j) {
                    if (dp[i - 1][j] >= value[i - 1] + dp[i - 1][j - weight[i - 1]]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    }

                }
            }
        }
        //下面用来输出具体商品信息
        int i = path.length - 1;//行的最大下标.0 1 2(4-1=3)
        int j = path[0].length - 1;//列的最大下标 4-1=3
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包,重量%d kg,价格 %d 元。\n", i, weight[i - 1], value[i - 1]);
                j -= weight[i - 1];//剩余空间大小
            }
            i--;
        }
/*       for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                if (path[i][j] == 1) {
                    System.out.printf("第%d个商品放入背包\n", i);
                }
            }
        }*/

        return dp[Length][size];
    }

    //测试程序
    public static void main(String[] args) {
        int w[] = {1,4,3};
        int v[] = {1500,3000,2000};
        int size = 4;
        dp1 d = new dp1();
        System.out.println(d.solution(w, v, size));
    }
}
