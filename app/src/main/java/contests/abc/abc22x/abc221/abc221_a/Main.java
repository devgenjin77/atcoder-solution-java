/*
 * AtCoder Beginner Contest 221
 * A - Find Multiple
 * https://atcoder.jp/contests/abc221/tasks/abc221_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/33224396
 *
 * note:
 * マグニチュード1毎に32倍(2^5)となるので、5掛けるマグニチュードの差の分左シフト
 */

package contests.abc.abc22x.abc221.abc221_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(1 << ((a - b) * 5));
  }
}
