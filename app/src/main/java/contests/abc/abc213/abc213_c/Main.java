/*
 * ABC213
 * C - Reorder Cards
 * https://atcoder.jp/contests/abc213/tasks/abc213_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/24900566
 *
 */
package contests.abc.abc213.abc213_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int h = Integer.parseInt(head[0]);
    int w = Integer.parseInt(head[1]);
    int n = Integer.parseInt(head[2]);
    int[] array_a = new int[n];
    int[] array_b = new int[n];
    HashSet<Integer> set_a = new HashSet<>();
    HashSet<Integer> set_b = new HashSet<>();
    for(int i = 0; i < n; i++){
      String[] data = br.readLine().split(" ");
      array_a[i] = Integer.parseInt(data[0]);
      set_a.add(array_a[i]);
      array_b[i] = Integer.parseInt(data[1]);
      set_b.add(array_b[i]);
    }
    br.close();

    int[] idx_a = new int[set_a.size()];
    int idx = 0;
    for(Integer num : set_a){
      idx_a[idx] = num;
      idx++;
    }

    idx = 0;
    int[] idx_b = new int[set_b.size()];
    for(Integer num : set_b){
      idx_b[idx] = num;
      idx++;
    }
    Arrays.sort(idx_a);
    Arrays.sort(idx_b);
    PrintWriter pw = new PrintWriter(System.out);
    for(int i = 0; i < n; i++){
      pw.println(String.format("%d %d", binSearch(array_a[i], idx_a) + 1, binSearch(array_b[i], idx_b) + 1));
    }
    pw.close();
  }
  static int binSearch(int target, int[] array){
    int left = 0;
    int right = array.length;
    while(right > left){
      int idx = (right + left) / 2;
      if(array[idx] > target){
        right = idx;
      } else if(array[idx] < target){
        left = idx;
      } else {
        return idx;
      }
    }
    return right;
  }
}