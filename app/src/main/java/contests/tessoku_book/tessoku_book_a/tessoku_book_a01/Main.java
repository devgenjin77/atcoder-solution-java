/*
 * 競技プログラミングの鉄則　演習問題集
 * A01 - The First Problem
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_a
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38868596
 *
 * note:
 * N^2を出力するだけ
 */

package contests.tessoku_book.tessoku_book_a.tessoku_book_a01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(n * n);
  }
}
