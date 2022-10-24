/*
 * LINE Verda プログラミングコンテスト
 * （AtCoder Beginner Contest 263）
 * C - Monotonically Increasing
 * https://atcoder.jp/contests/abc263/tasks/abc263_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc263/submissions/35942866
 *
 */

package contests.abc.abc26x.abc263.abc263_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  private static PrintWriter pw;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    br.close();
    pw = new PrintWriter(System.out);
    dfs(new LinkedList<>(), 1, 0, n, m);
    pw.close();
  }

  static void dfs(LinkedList<String> list, int start, int level, int max_depth, int max_num) {
    if (level == max_depth) {
      pw.println(String.join(" ", list));
    } else {
      for (int i = start; i <= max_num - (max_depth - level - 1); i++) {
        list.add(String.valueOf(i));
        dfs(list, i + 1, level + 1, max_depth, max_num);
        list.removeLast();
      }
    }
  }
}
