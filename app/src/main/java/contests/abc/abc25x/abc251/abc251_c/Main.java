/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 251）
 * C - Poem Online Judge
 * https://atcoder.jp/contests/abc251/tasks/abc251_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc251/submissions/35165811
 *
 */

package contests.abc.abc25x.abc251.abc251_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final Set<String> used_word = new HashSet<>();
    int ans = 0, max = -1;
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int t = Integer.parseInt(st.nextToken());
      if (!used_word.contains(s)) {
        if (t > max) {
          max = t;
          ans = i;
        }
        used_word.add(s);
      }
    }
    System.out.println(ans);
  }
}
