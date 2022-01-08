/*
 * 競プロ典型90問
 * 058 - Original Calculator（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bf
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28372660
 *
 */
package contests.typical90.typical90_058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  final static int MOD = 100_000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    int n = Integer.parseInt(input[0]);
    long k = Long.parseLong(input[1]);

    int next = n;
    long remain = k;
    int[] tbl_idx_to_num = new int[MOD];
    int[] tbl_num_to_idx = new int[MOD];
    Arrays.fill(tbl_num_to_idx, -1);
    tbl_idx_to_num[0] = n;
    tbl_num_to_idx[n] = 0;
    int idx = 0;
    while(remain > 0){
      idx += 1;
      remain -= 1;
      next = calc(next);
      if(tbl_num_to_idx[next] == -1){
        tbl_idx_to_num[idx] = next;
        tbl_num_to_idx[next] = idx;
      } else {
        int rem2 = (int)(remain % (idx - tbl_num_to_idx[next]));
        next = tbl_idx_to_num[(tbl_num_to_idx[next] + rem2) % MOD];
        break;
      }
    }
    System.out.println(next);
    return;
  }

  static int calc(int x){
    int y = 0, tmp = x;
    while(tmp > 0){
      y += tmp % 10;
      tmp /= 10;
    }
    return (x + y) % MOD;
  }
}
