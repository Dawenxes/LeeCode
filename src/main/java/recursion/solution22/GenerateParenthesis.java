package recursion.solution22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  List<String> result = new ArrayList();

  public List<String> generateParenthesis(int n) {
    _generate("",0,0,n);
    return result;
  }

    private void _generate(String s, int left, int right, int n) {
      if (left==n&&right==n){
          result.add(s);
          return;
      }
    if (left < n) {
      _generate(s + "(", left + 1, right, n);
    }
    if (right < left) {
      _generate(s + ")", left, right + 1, n);
    }
    }

}
