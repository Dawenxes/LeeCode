package recursion.solution22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_3 {
	List<String> result = new ArrayList();

	public List<String> generateParenthesis(int n) {
		generate(n, 0, 0, "");
		return result;
	}

	private void generate(int n, int left, int right, String str) {
		if (str.length() == 2 * n) {
			result.add(str);
			return;
		}

		if (left < n) {
			generate(n, left + 1, right, str + "(");
		}
		if (right < left) {
			generate(n, left, right + 1, str + ")");
		}
	}

}
