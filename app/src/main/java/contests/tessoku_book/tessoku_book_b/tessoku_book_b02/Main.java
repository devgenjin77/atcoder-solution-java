/*
 * 競技プログラミングの鉄則　演習問題集
 * B02 - Divisor Check
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_ca
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38869383
 *
 * note:
 * 100の約数かどうかを全探索する
 */

package contests.tessoku_book.tessoku_book_b.tessoku_book_b02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    br.close();
    boolean isFound = false;
    for (int x = a; x <= b; x++) {
      if (100 % x == 0) {
        isFound = true;
        break;
      }
    }
    System.out.println(isFound ? "Yes" : "No");
  }
}
