/*
 * 競プロ典型90問
 * 038 - Large LCM（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_al
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31929428
 *
 * note:
 * - オーバーフローに注意する
 *
 */

package contests.typical90.typical90_04.typical90_038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MAX = 1_000_000_000_000_000_000L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    br.close();
    long gcd_ab = gcd(a, b);
    if (a > MAX / (b / gcd_ab)) {
      System.out.println("Large");
    } else {
      System.out.println(a / gcd_ab * b);
    }
  }

  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
