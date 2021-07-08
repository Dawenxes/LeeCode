package competition.solution5801;

import java.util.Arrays;

public class EliminateMaximum {
  public static void main(String[] args) {
    EliminateMaximum eliminateMaximum = new EliminateMaximum();
    System.out.println(
        eliminateMaximum.eliminateMaximum(
            new int[] {4, 8, 6, 8, 2, 7, 4}, new int[] {1, 3, 3, 1, 10, 1, 1}));
  }

  public int eliminateMaximum(int[] dist, int[] speed) {
    int ans = 0;
    float[] mapTime = new float[dist.length];
    for (int i = 0; i < speed.length; i++) {
      float second = ((float) dist[i]) / speed[i];
      mapTime[i] = second;
    }
    Arrays.sort(mapTime);
    for (int i = 0; i < speed.length; i++) {
      if (mapTime[i] > (float) i) {
        ans++;
      } else {
        break;
      }
    }
    return ans;
  }
}
