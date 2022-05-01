/*
 * ABC244
 * D - Swap Hats
 * https://atcoder.jp/contests/abc244/tasks/abc244_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/31377997
 *
 */

package contests.abc.abc244.abc244_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    String[] t = br.readLine().split(" ");
    br.close();
    int same = 0;
    for (int i = 0; i < 3; i++) {
      if (s[i].equals(t[i])) {
        same++;
      }
    }
    System.out.println(same == 0 || same == 3 ? "Yes" : "No");
  }
}
