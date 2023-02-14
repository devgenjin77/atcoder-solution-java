/*
 * 競技プログラミングの鉄則　演習問題集
 * A05 - Three Cards
 * https://atcoder.jp/contests/tessoku-book/tasks/tessoku_book_e
 *
 * verified:
 * - https://atcoder.jp/contests/tessoku-book/submissions/38885972
 *
 * note:
 * ３重ループでなく２重ループで全探索
 */

package contests.tessoku_book.tessoku_book_a.tessoku_book_a05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    br.close();
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        int l = k - (i + j);
        if (1 <= l && l <= n) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
