package competition.solution5788;

public class LargestOddNumber {
  public String largestOddNumber(String num) {
    String ans = "";
    char[] chars = num.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      if ((chars[i] - '0') % 2 == 1) {
        ans = num.substring(0, i+1);
        break;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    LargestOddNumber largestOddNumber = new LargestOddNumber();
    String s = largestOddNumber.largestOddNumber("35427");
    System.out.println(s);

  }
}
