/*
 * キーエンスプログラミングコンテスト2022
 * （AtCoder Beginner Contest 274）
 * A - Batting Average
 * https://atcoder.jp/contests/abc274/tasks/abc274_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc274/submissions/35921488
 *
 */

package contests.abc.abc27x.abc274.abc274_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    br.close();
    BigDecimal bd = new BigDecimal((double) b / a);
    System.out.println(bd.setScale(3, RoundingMode.HALF_UP));
  }
}
