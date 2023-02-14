/*
 * 競技プログラミングの鉄則　演習問題集
 * B04 - Binary Representation 2
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_cc
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38885488
 *
 * note:
 * 2進数を10進数に変換
 */

package contests.tessoku_book.tessoku_book_b.tessoku_book_b04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    br.close();
    int ans = 0;
    for (int k = 0; k < n.length(); k++) {
      if (n.charAt(n.length() - k - 1) == '1') {
        ans += (1 << k);
      }
    }
    System.out.println(ans);
  }
}
