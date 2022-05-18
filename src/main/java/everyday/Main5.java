package everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入一个由n个大小写字母组成的字符串，
 * 按照Ascii码值从小到大的排序规则，
 * 查找字符串中第k个最小ascii码值的字母(k>=1) ,
 * 输出该字母所在字符串的位置索引(字符串的第一个字符位置索引为0) 。
 * k如果大于字符串长度，则输出最大ascii值的字母所在字符串的位置索引，如果有重复的字母，则输出字母的最小位置索引。
 *
 * 输入描述：
 * 第一行输入一个由大小写字母组成的字符串
 * 第二行输入k，k必须大于o，k可以大于输入字符串的长度
 *
 * 输出描述：
 * 输出字符串中第k个最小ascii码值的字母所在字符串的位置索引,
 * k如果大于字符串长度，则输出最大ascii值的字母所在字符串的位置索引，
 * 如果第k个最小ascii码值的字母存在重复，则输出该字母的最小位置索引。
 *
 * 示例：
 * AbCdeFG
 * 3
 * 输出：5
 *
 * fAdDAkBbBq
 * 4
 * 输出：6
 * 
 * 说明：
 * 根据asci1码值排序，前4个字母为AABB，由于3重复，则只取B的
 * (第一个)最小位置索引6，而不是第二个B的位置索引8
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(handle(s,k));
    }
    public static int handle(String s,int k){
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if(!map.containsKey(chars[i])){
                map.put(chars[i],i);
            }
        }
        Arrays.sort(chars);
        if(k>s.length()) {
            return map.get(chars[s.length()-1]);
        }
        return map.get(chars[k-1]);
    }


}

