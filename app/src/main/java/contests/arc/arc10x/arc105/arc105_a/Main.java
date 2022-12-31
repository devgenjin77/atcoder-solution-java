/*
 * AtCoder Regular Contest 105
 * A - Fourtune Cookies
 * https://atcoder.jp/contests/arc105/tasks/arc105_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc105/submissions/37664391
 *
 * note:
 *
 */

package contests.arc.arc10x.arc105.arc105_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int[] array_abcd = new int[4];
    for (int i = 0; i < 4; i++) {
      array_abcd[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
    boolean isOK = false;
    for (int bit = 1; bit < (1 << 4); bit++) {
      int eat = 0, ate = 0;
      for (int i = 0; i < 4; i++) {
        if (((bit >> i) & 1) == 1) {
          eat += array_abcd[i];
        } else {
          ate += array_abcd[i];
        }
      }
      if (eat == ate) {
        isOK = true;
        break;
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
