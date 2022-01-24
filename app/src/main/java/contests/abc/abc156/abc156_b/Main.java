/*
 * ABC156
 * B - Digits
 * https://atcoder.jp/contests/abc156/tasks/abc156_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc156/submissions/28780985
 *
 */
package contests.abc.abc156.abc156_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int ans = 1;
    while (n >= k) {
      n /= k;
      ans++;
    }
    System.out.println(ans);
    return;
  }
}
