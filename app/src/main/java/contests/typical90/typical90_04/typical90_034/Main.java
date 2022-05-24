/*
 * 競プロ典型90問
 * 034 - There are few types of elements（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ah
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31928903
 *
 * note:
 * - 尺取法で最善解を求める
 *
 */

package contests.typical90.typical90_04.typical90_034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    HashMap<Integer, Integer> num_cnt = new HashMap<>();
    int left = 0, right = 0;
    int ans = 0;
    while(right < n) {
      int num_r = array_a[right++];
      num_cnt.put(num_r, num_cnt.getOrDefault(num_r, 0) + 1);
      if(num_cnt.size() <= k) {
        ans = Math.max(right - left, ans);
      } else {
        while(left < right) {
          int num_l = array_a[left++];
          int cnt = num_cnt.get(num_l);
          if(cnt == 1) {
            num_cnt.remove(num_l);
            break;
          } else {
            num_cnt.put(num_l, cnt - 1);
          }
        }
      }
    }
    System.out.println(ans);
  }
}
