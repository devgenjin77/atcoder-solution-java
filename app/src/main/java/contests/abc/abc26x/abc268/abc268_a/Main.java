/*
 * ユニークビジョンプログラミングコンテスト2022 夏
 * （AtCoder Beginner Contest 268）
 * A - Five Integers
 * https://atcoder.jp/contests/abc268/tasks/abc268_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc268/submissions/34774192
 *
 */

package contests.abc.abc26x.abc268.abc268_a;

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
    br.close();
    Set<Integer> set = new HashSet<>();
    while (st.hasMoreElements()) {
      set.add(Integer.valueOf(st.nextToken()));
    }
    System.out.println(set.size());
  }
}
