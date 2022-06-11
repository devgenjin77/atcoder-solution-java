/*
 * ABC241
 * E - Putting Candies
 * https://atcoder.jp/contests/abc241/tasks/abc241_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/32367214
 *
 */

package contests.abc.abc24x.abc241.abc241_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long k = Long.parseLong(st.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();

    long cnt = 0;
    long ans = 0;
    long l_n = n;
    long[] mod_to_sum = new long[n];
    long[] mod_to_cnt = new long[n];
    int[] cnt_to_mod = new int[n];
    Arrays.fill(mod_to_sum, -1);
    while (cnt < k) {
      int ans_mod = (int) (ans % l_n);
      if (mod_to_sum[ans_mod] == -1) {
        mod_to_sum[ans_mod] = ans;
        mod_to_cnt[ans_mod] = cnt;
        cnt_to_mod[(int) cnt] = ans_mod;
        ans += array_a[ans_mod];
        cnt++;
      } else {
        long t = (k - cnt) / (cnt - mod_to_cnt[ans_mod]);
        long v = ans - mod_to_sum[ans_mod];
        ans += v * t;
        int remain = (int) ((k - cnt) % (cnt - mod_to_cnt[ans_mod]));
        int next_cnt = (int) mod_to_cnt[ans_mod] + remain;
        ans += mod_to_sum[cnt_to_mod[next_cnt]] - mod_to_sum[ans_mod];
        break;
      }
    }
    System.out.println(ans);
  }
}
