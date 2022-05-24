/*
 * 競プロ典型90問
 * 058 - Original Calculator（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bf
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31936843
 *
 * note:
 * -周期性を見抜く
 *
 */

package contests.typical90.typical90_06.typical90_058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static final int MAX = 100_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long k = Long.parseLong(st.nextToken());
    br.close();

    int[] num_to_cnt = new int[MAX];
    int[] cnt_to_num = new int[MAX];
    Arrays.fill(num_to_cnt, -1);
    cnt_to_num[0] = n;
    num_to_cnt[n] = 0;
    long remain = k;
    int cur_num = n, cur_cnt = 0;
    while (remain > 0) {
      int next = nextValue(cur_num);
      cur_cnt++;
      remain--;
      if (num_to_cnt[next] == -1) {
        cnt_to_num[cur_cnt] = next;
        num_to_cnt[next] = cur_cnt;
        cur_num = next;
      } else {
        int remain2 = (int) (remain % (cur_cnt - num_to_cnt[next]));
        cur_num = cnt_to_num[num_to_cnt[next] + remain2];
        break;
      }
    }
    System.out.println(cur_num);
  }

  static int nextValue(int num) {
    int tmp = num, val = num;
    while (tmp > 0) {
      val += tmp % 10;
      tmp /= 10;
    }
    return val % MAX;
  }
}
