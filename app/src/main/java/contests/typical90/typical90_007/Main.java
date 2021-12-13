/*
 * 競プロ典型90問
 * 007 - CP Classes（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_g
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27901609
 *
 */
package contests.typical90.typical90_007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] array_a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(array_a);

    int q = Integer.parseInt(br.readLine());
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int b = Integer.parseInt(br.readLine());
      int result = Arrays.binarySearch(array_a, b);
      int ans = 0;
      if (result < 0) {
        int insert = ~result;
        if (insert == 0) {
          ans = Math.abs(array_a[0] - b);
        } else if (insert == n) {
          ans = Math.abs(array_a[n - 1] - b);
        } else {
          ans = Math.min(Math.abs(array_a[insert] - b), Math.abs(array_a[insert - 1] - b));
        }
      }
      pw.println(ans);
    }
    pw.close();
    br.close();
  }
}
