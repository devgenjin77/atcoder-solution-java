/*
 * 競プロ典型90問
 * 020 - Log Inequality（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_t
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31920999
 *
 * note:
 * 整数で扱う
 *
 */

package contests.typical90.typical90_02.typical90_020;

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
    System.out.println(a < pow(c, b) ? "Yes" : "No");
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
