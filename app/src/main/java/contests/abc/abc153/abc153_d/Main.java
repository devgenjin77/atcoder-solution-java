/*
 * ABC153
 * D - Caracal vs Monster
 * https://atcoder.jp/contests/abc153/tasks/abc153_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc153/submissions/28579163
 *
 */
package contests.abc.abc153.abc153_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    long h = Long.parseLong(br.readLine());
    br.close();
    System.out.println(pow(2, Long.toBinaryString(h).length()) - 1);
    return;
  }

  static long pow(long x, long n) {
    long answer = 1l;
    while (n > 0) {
      if ((n & 1) == 1) {
        answer = answer * x;
      }
      x = x * x;
      n >>= 1;
    }
    return answer;
  }
}
