/*
 * ABC241
 * E - Putting Candies
 * https://atcoder.jp/contests/abc241/tasks/abc241_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/29737640
 *
 */
package contests.abc.abc241.abc241_e;

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
    long[] array_a = new long[n];
    StringTokenizer st_input_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_input_a.nextToken());
    }
    br.close();

    long[] sum_at_cnt = new long[n + 1];
    int[] cnt_at_idx = new int[n];
    Arrays.fill(cnt_at_idx, -1);
    long remain = k;
    long ans = 0;
    int cnt = 0;
    while (remain > 0) {
      cnt++;
      int next_pos = (int) (ans % n);
      if (cnt_at_idx[next_pos] == -1) {
        ans += array_a[next_pos];
        sum_at_cnt[cnt] = ans;
        cnt_at_idx[next_pos] = cnt;
        remain--;
      } else {
        int prev_cnt = cnt_at_idx[next_pos];
        long cycle_cnt = cnt - prev_cnt;
        long cycle_sum = ans - sum_at_cnt[prev_cnt - 1];

        long add_by_cycle = cycle_sum * (remain / cycle_cnt);
        ans += add_by_cycle;
        remain = remain % cycle_cnt;
        if (remain > 0) {
          long add_by_remain = sum_at_cnt[prev_cnt - 1 + (int) remain] - sum_at_cnt[prev_cnt - 1];
          ans += add_by_remain;
        }
        remain = 0;
      }
    }
    System.out.println(ans);
  }
}
