package greedy.solution874;

import java.util.HashSet;
import java.util.Set;

public class RobotSim {
  int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int robotSim(int[] commands, int[][] obstacles) {
    Set<String> set = new HashSet<>();
    for (int[] obstacle : obstacles) {
      set.add(obstacle[0] + ":" + obstacle[1]);
    }
    int d = 0, x = 0, y = 0;
    int result = 0;
    for (int command : commands) {
      if (command == -1) {
        d = (d + 1) % 4;
      } else if (command == -2) {
        d--;
        if (d == -1) {
          d = 3;
        }
      } else {
        while (command > 0 && !set.contains((x + dirs[d][0]) + ":" + (y + dirs[d][1]))) {
          x = x + dirs[d][0];
          y = y + dirs[d][1];
          command--;
        }
      }
      result = Math.max(result, x * x + y * y);
    }
    return result;
  }

  public static void main(String[] args) {
    RobotSim robotSim = new RobotSim();
    int[][] ints = {{-1, 3}, {0, 1}, {-1, 5}, {-2, -4}, {5, 4}, {-2, -3}, {5, -1}, {1, -1}, {5, 5}, {5, 2}};

    System.out.println(robotSim.robotSim(new int[] {-2, -1, 8, 9, 6}, ints));
  }
}
