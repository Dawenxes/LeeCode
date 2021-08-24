package string.bm;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: BmMatcher
 * @author: ZhangBoneng
 * @date: 2021/8/24 9:58
 */
public class BmMatcher {

	private static final Map<Character, Integer> BC = new HashMap<>();

	/**
	 * 生成坏字符规则所需的缓存信息，后面可用map替代
	 * 坏字符规则:
	 * 当发生不匹配的时候，我们把坏字符对应的模式串中的字符下标记作 si。
	 * 如果坏字符在模式串中存在，我们把这个坏字符在模式串中的下标记作 xi。
	 * 如果不存在，我们把 xi 记作 -1。那模式串往后移动的位数就等于 si-xi。（注意，我这里说的下标，都是字符在模式串的下标）。
	 *
	 * @param b b
	 * @param m m
	 */
	private void generateBc(char[] b, int m) {
		for (int i = 0; i < m; ++i) {
			// 计算 b[i] 的 ASCII 值
			BC.put(b[i], i);
		}
	}


	/**
	 * 	 坏字符规则的bm，
	 * 	 因为根据 si-xi 计算出来的移动位数，有可能是负数，
	 * 	 比如主串是 aaaaaaaaaaaaaaaa，模式串是 baaa。
	 *
	 * @param a a
	 * @param n n
	 * @param b b
	 * @param m m
	 * @return int
	 */
	public int badBm(char[] a, int n, char[] b, int m) {
		// 构建坏字符哈希表
		generateBc(b, m);
		// i 表示主串与模式串对齐的第一个字符
		int i = 0;
		while (i <= n - m) {
			int j;
			for (j = m - 1; j >= 0; j--) {
				if (a[i + j] != b[j]) {
					break;
				}
			}
			if (j == -1) {
				return i;
			}
			i += j - BC.get(a[i + j]);
		}
		return -1;
	}

	/**
	 * b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
	 * 拿下标从 0 到 i 的子串（i 可以是 0 到 m-2）与整个模式串，求公共后缀子串。
	 * 好前缀规则数组生成，这部分可以改成动态规划
	 * 不仅要在模式串中，查找跟好后缀匹配的另一个子串，
	 * 还要在好后缀的后缀子串中，查找最长的能跟模式串前缀子串匹配的后缀子串。
	 *
	 * @param b      b
	 * @param m      m
	 * @param suffix 后缀
	 * @param prefix 前缀
	 */
	private void generateGs(char[] b, int m, int[] suffix, boolean[] prefix) {
		// 初始化
		for (int i = 0; i < m; ++i) {
			suffix[i] = -1;
			prefix[i] = false;
		}
		// b[0, i]
		for (int i = 0; i < m - 1; ++i) {
			int j = i;
			// 公共后缀子串长度
			int k = 0;
			// 与 b[0, m-1] 求公共后缀子串
			while (j >= 0 && b[j] == b[m - 1 - k]) {
				--j;
				++k;
				// j+1 表示公共后缀子串在 b[0, i] 中的起始下标
				suffix[k] = j + 1;
			}
			// 如果公共后缀子串也是模式串的前缀子串
			if (j == -1) {
				prefix[k] = true;
			}
		}
	}

	/**
	 * a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
	 *
	 * @param a a
	 * @param n n
	 * @param b b
	 * @param m m
	 * @return int
	 */
	public int bm(char[] a, int n, char[] b, int m) {
		// 构建坏字符哈希表
		generateBc(b, m);
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGs(b, m, suffix, prefix);
		// j 表示主串与模式串匹配的第一个字符
		int i = 0;
		while (i <= n - m) {
			int j;
			// 模式串从后往前匹配
			for (j = m - 1; j >= 0; --j) {
				if (a[i + j] != b[j]) {
					// 坏字符对应模式串中的下标是 j
					break;
				}
			}
			if (j < 0) {
				// 匹配成功，返回主串与模式串第一个匹配的字符的位置
				return i;
			}
			int x = j - BC.get(a[i + j]);
			int y = 0;
			// 如果有好后缀的话
			if (j < m - 1) {
				y = moveByGs(j, m, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	/**
	 * j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
	 * 好前缀规则
	 * 
	 * @param j	   	 j
	 * @param m      m
	 * @param suffix 后缀
	 * @param prefix 前缀
	 * @return int
	 */
	private int moveByGs(int j, int m, int[] suffix, boolean[] prefix) {
		// 好后缀长度
		int k = m - 1 - j;
		if (suffix[k] != -1) {
			return j - suffix[k] + 1;
		}
		for (int r = j + 2; r <= m - 1; ++r) {
			if (prefix[m - r]) {
				return r;
			}
		}
		return m;
	}
}
