/*
 * キーエンスプログラミングコンテスト2022
 * （AtCoder Beginner Contest 274）
 * C - Ameba
 * https://atcoder.jp/contests/abc274/tasks/abc274_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc274/submissions/35918941
 *
 */

package contests.abc.abc27x.abc274.abc274_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    final int[] ans = new int[(2 * n) + 1];
    int now = 0;
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(st_a.nextToken()) - 1;
      ans[++now] = ans[a] + 1;
      ans[++now] = ans[a] + 1;
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int a : ans) {
      pw.println(a);
    }
    pw.close();
  }
}
