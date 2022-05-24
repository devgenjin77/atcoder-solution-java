/*
 * 競プロ典型90問
 * 046 - I Love 46（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_at
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31932264
 *
 * note:
 * -modでまとめる
 *
 */

package contests.typical90.typical90_05.typical90_046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());
    StringTokenizer st_c = new StringTokenizer(br.readLine());
    br.close();
    long[] arr_a_mod46 = new long[46];
    long[] arr_b_mod46 = new long[46];
    long[] arr_c_mod46 = new long[46];
    for (int i = 0; i < n; i++) {
      arr_a_mod46[Integer.parseInt(st_a.nextToken()) % 46]++;
      arr_b_mod46[Integer.parseInt(st_b.nextToken()) % 46]++;
      arr_c_mod46[Integer.parseInt(st_c.nextToken()) % 46]++;
    }
    long ans = 0;
    for (int a = 0; a < 46; a++) {
      for (int b = 0; b < 46; b++) {
        int target_c = ((46 * 2) - (a + b)) % 46;
        ans += arr_a_mod46[a] * arr_b_mod46[b] * arr_c_mod46[target_c];
      }
    }
    System.out.println(ans);
  }
}
