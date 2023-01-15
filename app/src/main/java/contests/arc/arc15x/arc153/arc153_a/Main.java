/*
 * AtCoder Regular Contest 153
 * A - AABCDDEFE
 * https://atcoder.jp/contests/arc153/tasks/arc153_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc153/submissions/38029163
 *
 * note:
 *
 */

package contests.arc.arc15x.arc153.arc153_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    final String ord_num = String.valueOf(100_000 + n - 1);
    final StringBuilder ans = new StringBuilder("000000000");
    ans.setCharAt(0, ord_num.charAt(0));
    ans.setCharAt(1, ord_num.charAt(0));
    ans.setCharAt(2, ord_num.charAt(1));
    ans.setCharAt(3, ord_num.charAt(2));
    ans.setCharAt(4, ord_num.charAt(3));
    ans.setCharAt(5, ord_num.charAt(3));
    ans.setCharAt(6, ord_num.charAt(4));
    ans.setCharAt(7, ord_num.charAt(5));
    ans.setCharAt(8, ord_num.charAt(4));
    System.out.println(ans);
  }
}
