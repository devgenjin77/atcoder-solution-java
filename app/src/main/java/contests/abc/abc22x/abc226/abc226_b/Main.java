/*
 * AtCoder Beginner Contest 226
 * B - Counting Arrays
 * https://atcoder.jp/contests/abc226/tasks/abc226_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/33748188
 *
 * note:
 * 配列が同じかどうかを、文字列で丸ごと判定する
 *
 */

package contests.abc.abc22x.abc226.abc226_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final Set<String> set_l = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set_l.add(br.readLine());
    }
    br.close();
    System.out.println(set_l.size());
  }
}
