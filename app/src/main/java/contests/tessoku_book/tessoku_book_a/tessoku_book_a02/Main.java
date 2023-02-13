/*
 * 競技プログラミングの鉄則　演習問題集
 * A02 - Linear Search
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_b
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38869178
 *
 * note:
 * Aを全探索する
 */

package contests.tessoku_book.tessoku_book_a.tessoku_book_a02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    boolean isFound = false;
    for (int a : array_a) {
      if (a == x) {
        isFound = true;
        break;
      }
    }
    System.out.println(isFound ? "Yes" : "No");
  }
}
