/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 251）
 * B - At Most 3 (Judge ver.)
 * https://atcoder.jp/contests/abc251/tasks/abc251_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc251/submissions/35162962
 *
 */

package contests.abc.abc25x.abc251.abc251_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n + 2];
    final Set<Integer> set_ans = new HashSet<>();
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    for (int i = 0; i < n; i++) {
      if (array_a[i] > w) {
        continue;
      }
      for (int j = i + 1; j < n + 1; j++) {
        if (array_a[i] + array_a[j] > w) {
          continue;
        }
        for (int k = j + 1; k < n + 2; k++) {
          int sum = array_a[i] + array_a[j] + array_a[k];
          if (w >= sum) {
            set_ans.add(sum);
          }
        }
      }
    }
    System.out.println(set_ans.size());
  }
}
