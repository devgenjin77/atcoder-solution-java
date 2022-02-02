/*
 * 競プロ典型90問
 * 085 - Multiplication 085（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cg
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/29013670
 *
 */
package contests.typical90.typical90_085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long k = Long.parseLong(br.readLine());
    br.close();
    TreeSet<Long> div_set = new TreeSet<>();
    div_set.add(1l);
    long sqrt_k = (long) Math.sqrt(k);
    for (long div = 2; div <= sqrt_k; div++) {
      if (k % div == 0) {
        div_set.add(div);
        div_set.add(k / div);
      }
    }
    long[] div_array = new long[div_set.size()];
    int idx = 0;
    for (long d : div_set) {
      div_array[idx++] = d;
    }
    int ans = 0;
    for (int idx1 = 0; idx1 < div_array.length; idx1++) {
      long k2 = k / div_array[idx1];
      for (int idx2 = idx1; idx2 < div_array.length; idx2++) {
        if (k2 % div_array[idx2] == 0 && k2 / div_array[idx2] >= div_array[idx2]) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
