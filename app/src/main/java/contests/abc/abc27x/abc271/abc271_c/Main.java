/*
 * 京セラプログラミングコンテスト2022
 * （AtCoder Beginner Contest 271）
 * C - Manga
 * https://atcoder.jp/contests/abc271/tasks/abc271_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc271/submissions/35854714
 *
 */

package contests.abc.abc27x.abc271.abc271_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    boolean[] is_have = new boolean[n + 1];
    for (int i = 0; i < n; i++) {
      if (array_a[i] > n) {
        continue;
      }
      if (!is_have[array_a[i]]) {
        is_have[array_a[i]] = true;
      }
    }
    int remain = n;
    int ans = 0;
    while (remain > 0) {
      if (is_have[ans + 1]) {
        remain -= 1;
        ans++;
      } else {
        if (remain >= 2) {
          remain -= 2;
          ans++;
        } else {
          break;
        }
      }
    }
    System.out.println(ans);
  }
}
