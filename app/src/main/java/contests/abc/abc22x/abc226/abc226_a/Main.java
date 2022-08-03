/*
 * AtCoder Beginner Contest 226
 * A - Round decimals
 * https://atcoder.jp/contests/abc226/tasks/abc226_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/33747996
 *
 * note:
 * 小数第一位で四捨五入する
 *
 */

package contests.abc.abc22x.abc226.abc226_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final BigDecimal x = new BigDecimal(br.readLine());
    br.close();
    System.out.println(x.setScale(0, RoundingMode.HALF_UP));
  }
}
