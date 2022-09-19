/*
 * ユニークビジョンプログラミングコンテスト2022 夏
 * （AtCoder Beginner Contest 268）
 * F - Best Concatenation
 * https://atcoder.jp/contests/abc268/tasks/abc268_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc268/submissions/35002457
 *
 * note:
 * - ソートの比較関数で、どちらの文字列が前にきた方がいいかを判定する。
 *
 */

package contests.abc.abc26x.abc268.abc268_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final List<ScoreString> list_s = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_s.add(new ScoreString(br.readLine()));
    }
    br.close();
    Collections.sort(list_s);
    long ans = 0;
    int cnt_x = 0;
    for (int i = 0; i < n; i++) {
      String s = list_s.get(i).s;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == 'X') {
          cnt_x++;
        } else {
          ans += cnt_x * (s.charAt(j) - '0');
        }
      }
    }
    System.out.println(ans);
  }

  static class ScoreString implements Comparable<ScoreString> {

    private long cnt_x = 0;

    private long score = 0;

    private String s;

    public ScoreString(String s) {
      this.s = s;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'X') {
          cnt_x++;
        } else {
          score += s.charAt(i) - '0';
        }
      }
    }

    @Override
    public int compareTo(ScoreString o) {
      return Long.compare(o.cnt_x * this.score, this.cnt_x * o.score);
    }
  }
}
