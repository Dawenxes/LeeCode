package recursion.solution22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_1 {
	List<String> result = new ArrayList();

	public List<String> generateParenthesis(int n) {
		_generate(0, 0, n, new StringBuilder());

		return result;
	}

	private void _generate(int left, int right, int n, StringBuilder stringBuilder) {
		if (left < n) {
			_generate(left + 1, right, n, new StringBuilder(stringBuilder).append("("));
		}
		if (right < left) {
			_generate(left, right + 1, n, new StringBuilder(stringBuilder).append(")"));
		}
		if (left == n && right == n) {
			result.add(stringBuilder.toString());
		}
	}
}
