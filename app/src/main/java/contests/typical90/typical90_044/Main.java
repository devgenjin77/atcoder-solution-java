/*
 * 競プロ典型90問
 * 044 - Shift and Swapping（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ar
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28326476
 *
 */
package contests.typical90.typical90_044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    String[] nq = br.readLine().split(" ");
    int n = Integer.parseInt(nq[0]);
    int q = Integer.parseInt(nq[1]);
    int[] array_a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int shift = 0;
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      String[] query = br.readLine().split(" ");
      int t = Integer.parseInt(query[0]);
      int x = Integer.parseInt(query[1]) - 1;
      int y = Integer.parseInt(query[2]) - 1;
      int x_pos = (x + n - shift) % n;
      int y_pos = (y + n - shift) % n;
      if (t == 1) {
        int tmp = array_a[x_pos];
        array_a[x_pos] = array_a[y_pos];
        array_a[y_pos] = tmp;
      } else if (t == 2) {
        shift = (shift + 1) % n;
      } else if (t == 3) {
        pw.println(array_a[x_pos]);
      }
    }
    pw.close();
    br.close();
    return;
  }
}
