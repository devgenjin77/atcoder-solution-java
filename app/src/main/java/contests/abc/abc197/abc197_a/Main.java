/*
 * ABC197
 * A - Rotate
 * https://atcoder.jp/contests/abc197/tasks/abc197_a
 *
 * - https://atcoder.jp/contests/abc197/submissions/22097972
 */
package contests.abc.abc197.abc197_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(1)).append(s.charAt(2)).append(s.charAt(0));
    System.out.println(sb.toString());
  }
}
