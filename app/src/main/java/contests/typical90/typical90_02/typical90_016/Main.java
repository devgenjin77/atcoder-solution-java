/*
 * 競プロ典型90問
 * 016 - Minimum Coins（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_p
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31903205
 *
 * note:
 * 全探索
 *
 */

package contests.typical90.typical90_02.typical90_016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long LIMIT = 9999;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    br.close();
    long ans = 9999;
    for (long cnt_a = 0; cnt_a <= LIMIT; cnt_a++) {
      for (long cnt_b = 0; cnt_b <= LIMIT - cnt_a; cnt_b++) {
        if(cnt_a + cnt_b > ans) {
          break;
        }
        long remain = n - (a * cnt_a) - (b * cnt_b);
        if (remain < 0) {
          break;
        }
        if (remain % c == 0) {
          long cnt_c = remain / c;
          ans = Math.min(cnt_a + cnt_b + cnt_c, ans);
        }
      }
    }
    System.out.println(ans);
  }
}
