/*
 * ABC212
 * C - Min Difference
 * https://atcoder.jp/contests/abc212/tasks/abc212_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30171737
 */
package contests.abc.abc212.abc212_c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

  static void solve(BufferedReader br, PrintWriter pw) throws Exception {
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    int m = Integer.parseInt(head[1]);
    int[] array_a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] array_b = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(array_a);
    Arrays.sort(array_b);
    int ans = Integer.MAX_VALUE;
    int idx_a = 0;
    int idx_b = 0;
    while (ans > 0 && idx_a < n && idx_b < m) {
      ans = Math.min(Math.abs(array_a[idx_a] - array_b[idx_b]), ans);
      if (array_a[idx_a] < array_b[idx_b]) {
        idx_a++;
      } else {
        idx_b++;
      }
    }
    pw.println(ans);
    pw.flush();
  }

  public static void main(String[] args) {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out)) {
      solve(br, pw);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}