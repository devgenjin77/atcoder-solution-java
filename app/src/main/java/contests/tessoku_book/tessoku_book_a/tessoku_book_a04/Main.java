/*
 * 競技プログラミングの鉄則　演習問題集
 * A04 - Binary Representation 1
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_d
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38885212
 *
 * note:
 * 二進数変換
 */

package contests.tessoku_book.tessoku_book_a.tessoku_book_a04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    final StringBuilder ans = new StringBuilder();
    for (int k = 0; k < 10; k++) {
      ans.append((n >> k) % 2);
    }
    System.out.println(ans.reverse());
  }
}
