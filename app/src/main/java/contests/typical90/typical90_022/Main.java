/*
 * 競プロ典型90問
 * 022 - Cubic Cake（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_v
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/25635259
 *
 */
package contests.typical90.typical90_022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] data = br.readLine().split(" ");
    br.close();
    long a = Long.parseLong(data[0]);
    long b = Long.parseLong(data[1]);
    long c = Long.parseLong(data[2]);
    long gcd = gcd(a, gcd(b, c));
    long ans = 0;
    ans += (a / gcd) - 1;
    ans += (b / gcd) - 1;
    ans += (c / gcd) - 1;
    System.out.println(ans);
  }

  static long gcd(long a, long b){
    return b == 0 ? a : gcd(b, a % b);
  }
}
