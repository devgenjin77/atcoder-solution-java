/*
 * 競プロ典型90問
 * 022 - Cubic Cake（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_v
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31922512
 *
 * note:
 * - 最小公倍数(GCD)を求める
 *
 */


package contests.typical90.typical90_03.typical90_022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    br.close();
    long gcd = gcd(a, gcd(b, c));
    long ans = 0;
    ans += (a / gcd) - 1;
    ans += (b / gcd) - 1;
    ans += (c / gcd) - 1;
    System.out.println(ans);
  }

  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
