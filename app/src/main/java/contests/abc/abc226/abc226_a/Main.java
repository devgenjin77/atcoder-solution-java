/*
 * ABC226
 * A - Round decimals
 * https://atcoder.jp/contests/abc226/tasks/abc226_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/27167102
 */
package contests.abc.abc226.abc226_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigDecimal dec = new BigDecimal(br.readLine());
    br.close();
    System.out.println(dec.setScale(0, RoundingMode.HALF_UP).toPlainString());
  }
}
