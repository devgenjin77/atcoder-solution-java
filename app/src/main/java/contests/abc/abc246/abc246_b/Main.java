/*
 * ABC246
 * B - Get Closer
 * https://atcoder.jp/contests/abc246/tasks/abc246_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30698025
 *
 */

package contests.abc.abc246.abc246_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    br.close();
    double rad = Math.atan2(b, a);
    StringBuilder sb = new StringBuilder();
    sb.append(Math.cos(rad)).append(" ").append(Math.sin(rad));
    System.out.println(sb.toString());
  }
}
