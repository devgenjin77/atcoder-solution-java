/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * E - Apple Baskets on Circle
 * https://atcoder.jp/contests/abc270/tasks/abc270_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/36329708
 *
 */

package contests.abc.abc27x.abc270.abc270_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long k = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    long ok = 0, ng = 1_000_000_000_001L;
    while (ng - ok > 1) {
      long mid = (ok + ng) / 2;
      long sum = 0;
      for (long a : array_a) {
        sum += Math.min(a, mid);
      }
      if (sum > k) {
        ng = mid;
      } else {
        ok = mid;
      }
    }
    long remain = k;
    for (int i = 0; i < n; i++) {
      long eat = Math.min(array_a[i], ok);
      array_a[i] -= eat;
      remain -= eat;
    }
    if (remain > 0) {
      for (int i = 0; i < n; i++) {
        if (array_a[i] > 0) {
          array_a[i]--;
          remain--;
        }
        if (remain <= 0) {
          break;
        }
      }
    }
    StringBuilder ans = new StringBuilder();
    for (long a : array_a) {
      ans.append(a).append(' ');
    }
    System.out.println(ans.deleteCharAt(ans.length() - 1));
  }
}
