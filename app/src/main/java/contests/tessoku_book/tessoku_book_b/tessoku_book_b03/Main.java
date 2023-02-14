/*
 * 競技プログラミングの鉄則　演習問題集
 * B03 - Supermarket 1
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_cb
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38884870
 *
 * note:
 * ３重ループで全探索
 */

package contests.tessoku_book.tessoku_book_b.tessoku_book_b03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    boolean isFound = false;
    main_loop:
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          if (array_a[i] + array_a[j] + array_a[k] == 1000) {
            isFound = true;
            break main_loop;
          }
        }
      }
    }
    System.out.println(isFound ? "Yes" : "No");
  }
}
