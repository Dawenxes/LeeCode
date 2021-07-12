package dynamic.solution552;

/**
 * @Description: 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。  学生出勤记录是只包含以下三个字符的字符串：  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/student-attendance-record-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ClassName: CheckRecord
 * @Author: zbn
 * @Date: 2021/7/12 9:33
 */
public class CheckRecord {
    public static void main(String[] args) {
        CheckRecord checkRecord = new CheckRecord();
        System.out.println(checkRecord.checkRecord(10101));
    }

    public int checkRecord(int n) {
        long _MOD = 1000000007;
        long[][][] dp = new long[n + 1][2][3];
        dp[1][0][1] = 1;
        dp[1][0][0] = 1;
        dp[1][0][2] = 0;
        dp[1][1][0] = 1;
        dp[1][1][1] = 0;
        dp[1][1][2] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % _MOD;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % _MOD;
            dp[i][0][1] = (dp[i - 1][0][0]);
            dp[i][0][2] = (dp[i - 1][0][1]);
            dp[i][1][1] = (dp[i - 1][1][0]);
            dp[i][1][2] = (dp[i - 1][1][1]);

            dp[i][1][0] += (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % _MOD;
        }
        return (int) ((dp[n][0][0] +
                dp[n][1][0] +
                dp[n][0][1] +
                dp[n][0][2] +
                dp[n][1][1] +
                dp[n][1][2]) % _MOD);
    }
}
