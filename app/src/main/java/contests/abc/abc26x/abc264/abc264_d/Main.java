/*
 * freee プログラミングコンテスト2022
 * （AtCoder Beginner Contest 264）
 * D - "redocta".swap(i,i+1)
 * https://atcoder.jp/contests/abc264/tasks/abc264_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc264/submissions/35926198
 *
 * note:
 * 転倒数をナイーブに求める
 *
 */

package contests.abc.abc26x.abc264.abc264_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    int ans = 0;
    final int[] array_a = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      array_a[i] = "atcoder".indexOf(s.charAt(i));
    }
    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = i + 1; j < s.length(); j++) {
        if (array_a[i] > array_a[j]) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
