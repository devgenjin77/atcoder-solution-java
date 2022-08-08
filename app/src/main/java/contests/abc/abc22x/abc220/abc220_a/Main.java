/*
 * AtCoder Beginner Contest 220
 * A - Find Multiple
 * https://atcoder.jp/contests/abc220/tasks/abc220_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc220/submissions/33885599
 *
 */

package contests.abc.abc22x.abc220.abc220_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final int c = Integer.parseInt(st.nextToken());
    br.close();

    // Bから(B mod C)を引くと、B以下の最大のCの倍数が求まる。
    // これがA以上ならYES
    int ans = b - (b % c);
    System.out.println(ans >= a ? ans : -1);
  }
}
