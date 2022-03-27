/*
 * ABC245
 * C - Choose Elements
 * https://atcoder.jp/contests/abc245/tasks/abc245_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/30504530
 *
 */

package contests.abc.abc245.abc245_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nk = br.readLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    long k = Long.parseLong(nk[1]);
    long[] array_a = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    long[] array_b = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();
    boolean isOk = true;
    boolean ok_a = true, ok_b = true, ok_next_a = false, ok_next_b = false;
    for (int i = 1; i < n; i++) {
      if (ok_a && Math.abs(array_a[i - 1] - array_a[i]) <= k) {
        ok_next_a = true;
      }
      if (ok_a && Math.abs(array_a[i - 1] - array_b[i]) <= k) {
        ok_next_b = true;
      }
      if (ok_b && Math.abs(array_b[i - 1] - array_a[i]) <= k) {
        ok_next_a = true;
      }
      if (ok_b && Math.abs(array_b[i - 1] - array_b[i]) <= k) {
        ok_next_b = true;
      }
      if (ok_next_a || ok_next_b) {
        ok_a = ok_next_a;
        ok_b = ok_next_b;
        ok_next_a = false;
        ok_next_b = false;
      } else {
        isOk = false;
        break;
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
