/*
 * 競プロ典型90問
 * 020 - Log Inequality（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_t
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27971077
 *
 */
package contests.typical90.typical90_020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    long a = Long.parseLong(input[0]);
    long b = Long.parseLong(input[1]);
    long c = Long.parseLong(input[2]);
    System.out.println(pow(c, b) > a ? "Yes" : "No");
  }

  static long pow(long x, long n) {
    long answer = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        answer = answer * x;
      }
      x = x * x;
      n >>= 1;
    }
    return answer;
  }
}
