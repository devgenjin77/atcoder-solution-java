/*
 * ARC129
 * A - Smaller XOR
 * https://atcoder.jp/contests/arc129/tasks/arc129_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc129/submissions/27488981
 */
package contests.arc.arc129.arc129_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    long n = Long.parseLong(input[0]);
    long l = Long.parseLong(input[1]);
    long r = Long.parseLong(input[2]);

    long x = 1;
    long ans = 0;
    while (x <= r) {
      if ((n ^ x) < n) {
        long range_max = (x << 1) - 1;
        ans += Math.max(Math.min(range_max, r) - Math.max(x, l) + 1, 0);
      }
      x = x << 1;
    }
    System.out.println(ans);
  }
}
