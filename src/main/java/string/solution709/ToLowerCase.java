package string.solution709;

/**
 * @Description: 转换成小写字母
 * @ClassName: ToLowerCase
 * @Author: zbn
 * @Date: 2021/8/10 11:14
 */
public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                sb.append((char)(c | 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
