/*
 * ABC150
 * B - Count ABC
 * https://atcoder.jp/contests/abc150/tasks/abc150_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc150/submissions/28827192
 *
 */
package contests.abc.abc150.abc150_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
      if ("ABC".equals(s.substring(i, i + 3))) {
        ans++;
      }
    }
    System.out.println(ans);
    return;
  }
}
