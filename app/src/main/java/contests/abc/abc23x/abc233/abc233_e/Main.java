/*
 * AtCoder Beginner Contest 233
 * E - Σ[k=0..10^100]floor(X／10^k)
 * https://atcoder.jp/contests/abc233/tasks/abc233_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc233/submissions/33907724
 *
 * note:
 * StringBuilderはappendで末尾から追加したほうが性能が良いみたいだ。
 *
 */

package contests.abc.abc23x.abc233.abc233_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String x = br.readLine();
    br.close();
    final int[] cum_x = new int[x.length()];
    cum_x[0] = x.charAt(0) - '0';
    for (int i = 1; i < x.length(); i++) {
      cum_x[i] += cum_x[i - 1];
      cum_x[i] += x.charAt(i) - '0';
    }
    int remain = 0; //繰り上がり計算用
    for (int i = cum_x.length - 1; i >= 0; i--) {
      //まず繰り上がり分を足し、
      cum_x[i] += remain;
      remain = cum_x[i] / 10;
      cum_x[i] %= 10;
    }
    StringBuilder ans = new StringBuilder(x.length());
    if (remain > 0) {
      ans.append(remain);
    }
    for (int d : cum_x) {
      ans.append(d);
    }
    System.out.println(ans);
  }
}
