package beauty;

import java.util.Arrays;

/**
 * @author ZhangBoneng
 * @version 1.0.0 @ClassName FindKsort @Description TODO
 * @createTime 2022年05月09日 18:23:00
 */
public class FindKsort {

  public void sort_partition(int[] array, int p, int r) {
    if (r < p) {
      return;
    }

    int q = partition(array, p, r);
    sort_partition(array, p, q-1);
    sort_partition(array, q + 1, r);
  }

  public int findK(int[] array, int K) {
   return findK_partition(array, 0, array.length - 1, K);
  }
  public int findK_partition(int[] array, int p, int r, int K) {
    int q = partition(array, p, r);
    if (q<K-1){
      return findK_partition(array,q+1,r,K);
    }else if (q==K-1){
      return array[q];
    } else{
      return findK_partition(array,p,q-1,K);
    }
  }
  private int partition(int[] array, int p, int r) {
    int i = p, j = p;
    int pivot = array[r];
    while (p < r) {
      if (array[p] < pivot) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        i++;
      }
      j++;
      p++;
    }
    int tmp = array[i];
    array[i] = array[r];
    array[r] = tmp;
    return i;
  }

  public static void main(String[] args) {
    int[] array = {6, 8, 7, 6, 3, 5, 9, 4};
    FindKsort findKsort = new FindKsort();
    //findKsort.sort_partition(array,0,array.length-1);
    System.out.println(Arrays.toString(array));
    System.out.println(findKsort.findK(array,1));
  }
}
