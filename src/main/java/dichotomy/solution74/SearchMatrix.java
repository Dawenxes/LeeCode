package dichotomy.solution74;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix[0].length, y = matrix.length;
        int left = 0, right = x * y - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = matrix[mid / x][mid % x];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
