package greedy.solution860;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                twenty++;
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (ten == 0 && five > 2) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
