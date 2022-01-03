/*
 * 競プロ典型90問
 * 038 - Large LCM（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_al
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28312746
 *
 */
package contests.typical90.typical90_038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static long MAX_ANSWER = 1_000_000_000_000_000_000L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    long a = Long.parseLong(input[0]);
    long b = Long.parseLong(input[1]);
    long gcd = gcd(a, b);
    long ad = a / gcd;
    long bd = b / gcd;
    long lim = MAX_ANSWER / gcd;
    if (ad > lim / bd || bd > lim / ad) {
      System.out.println("Large");
    } else {
      System.out.println(ad * bd * gcd);
    }
    return;
  }

  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
