package beauty.kmp;

import java.util.Arrays;

/**
 * @className: KmpMatcher
 * @author: ZhangBoneng
 * @date: 2021/8/24 11:17
 */
public class KmpMatcher {
	/**
	 * a, b 分别是主串和模式串；n, m 分别是主串和模式串的长度。
	 *
	 * @param a a
	 * @param n n
	 * @param b b
	 * @param m m
	 * @return int
	 */
	public static int kmp(char[] a, int n, char[] b, int m) {
		return -1;
	}

	/**
	 * 得到下一个
	 * 求模式串中每个前缀（这些前缀都有可能是好前缀）的最长可匹配前缀子串的结尾字符下标
	 *
	 * @param b b
	 * @param m 米
	 * @return {@link int[]}
	 */
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m];
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < m; ++i) {
			while (k != -1 && b[k + 1] != b[i]) {
				k = next[k];
			}
			if (b[k + 1] == b[i]) {
				++k;
			}
			next[i] = k;
		}
		return next;
	}

	public static void main(String[] args) {
		String ababcabaa = "ABABCABAA";
		System.out.println(Arrays.toString(KmpMatcher.getNexts(ababcabaa.toCharArray(), ababcabaa.length())));

	}
}
