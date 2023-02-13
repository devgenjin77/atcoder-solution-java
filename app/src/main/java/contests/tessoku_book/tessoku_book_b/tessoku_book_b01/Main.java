/*
 * 競技プログラミングの鉄則　演習問題集
 * B01 - A+B Problem
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_bz
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38868807
 *
 * note:
 * A+Bを出力するだけ
 */

package contests.tessoku_book.tessoku_book_b.tessoku_book_b01;

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
    System.out.println(a + b);
  }
}
