package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main6 {
  public static void main(String[] args) {}

  private static void srotHeight() {
    Scanner scanner = new Scanner(System.in);
    String[] split = scanner.nextLine().split("\\s+");
    String[] heights = scanner.nextLine().split("\\s+");
    int h = Integer.valueOf(split[0]);
    List<String> strings = new ArrayList<>(heights.length);
    Collections.addAll(strings, heights);
    Collections.sort(
        strings,
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            int num1 = Integer.valueOf(o1);
            int num2 = Integer.valueOf(o2);
            return Math.abs(num1 - h) - Math.abs(num2 - h);
          }
        });
    for (String height : strings) {
      System.out.print(height + " ");
    }
  }

  public static void sortSeven(int[] array) {

    int peopleNum = array.length;
    int sevenNum = Arrays.stream(array).sum();
    int count = 0;
    Arrays.fill(array, 0);
    int i = 1;
    while (count < sevenNum) {
      if ((i - 7) % 10 == 0 || i % 7 == 0) {
        int index = i % peopleNum - 1;
        array[index]++;
      }
      i++;
    }
  }

  public static void sortSeven(int[][] array) {}

  public static void cal(String[] array) {

  }
}
