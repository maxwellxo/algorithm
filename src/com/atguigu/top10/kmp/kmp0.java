package com.atguigu.top10.kmp;

/*
 * 下面是字符串匹配的暴力解法，和KMP算法进行比较
 * */
public class kmp0 {
    public static void main(String[] args) {
        String s1 = "asdfghjklzxcvbnm";
        String s2 = "vbn";
        System.out.println(ViolenceMatch(s1, s2));
    }

    public static int ViolenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Length = s1.length;
        int s2Length = s2.length;
        for (int i = 0; i < s1Length; i++) {
            for (int j = 0; j < s2Length; j++) {
                if (j == s2Length - 1 && s1[i + j] == s2[j]) {
                    return i;
                }
                if (s1[i + j] == s2[j]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
