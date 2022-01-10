/*
 * 競プロ典型90問
 * 084 - There are two types of characters（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cf
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28450263
 *
 */
package contests.typical90.typical90_084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    long all = ((long) n * (n + 1)) / 2;
    long ans = 1;
    long len = 1;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        len += 1;
      } else {
        len = 1;
      }
      ans += len;
    }
    System.out.println(all - ans);
  }
}
