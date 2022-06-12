/*
 * AtCoder Beginner Contest 215
 * C - One More aab aba baa
 * https://atcoder.jp/contests/abc215/tasks/abc215_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/32430955
 *
 */

package contests.abc.abc21x.abc215.abc215_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final String s = st.nextToken();
    final int k = Integer.parseInt(st.nextToken());
    br.close();
    final TreeSet<String> str_set = new TreeSet<>();
    int[] order = new int[s.length()];
    Arrays.setAll(order, i -> i);
    do {
      String str = sortByOrder(s, order);
      if (!str_set.contains(str)) {
        str_set.add(str);
      }
    } while (nextPermutation(order));
    String[] str_list = str_set.toArray(new String[0]);
    System.out.println(str_list[k - 1]);
  }

  static String sortByOrder(String org, int[] order) {
    StringBuilder sb = new StringBuilder();
    for (int i : order) {
      sb.append(org.charAt(i));
    }
    return sb.toString();
  }

  static boolean nextPermutation(int[] array) {
    int idx1 = array.length - 1;
    while (idx1 > 0 && array[idx1 - 1] >= array[idx1]) {
      idx1--;
    }
    if (idx1 <= 0) {
      return false;
    }
    int idx2 = array.length - 1;
    while (array[idx2] <= array[idx1 - 1]) {
      idx2--;
    }

    int temp = array[idx1 - 1];
    array[idx1 - 1] = array[idx2];
    array[idx2] = temp;

    idx2 = array.length - 1;
    while (idx1 < idx2) {
      temp = array[idx1];
      array[idx1] = array[idx2];
      array[idx2] = temp;
      idx1++;
      idx2--;
    }
    return true;
  }
}
