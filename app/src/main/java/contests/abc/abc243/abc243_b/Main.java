/*
 * ABC243
 * B - Hit and Blow
 * https://atcoder.jp/contests/abc243/tasks/abc243_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/30110256
 *
 */
package contests.abc.abc243.abc243_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] array_a = br.readLine().split(" ");
    String[] array_b = br.readLine().split(" ");
    br.close();
    Set<String> set_a = new HashSet<>(Arrays.asList(array_a));
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < n; i++) {
      if (array_a[i].equals(array_b[i])) {
        cnt1++;
      } else if (set_a.contains(array_b[i])) {
        cnt2++;
      }
    }
    System.out.println(cnt1);
    System.out.println(cnt2);
  }
}
