/*
 * ABC155
 * B - Papers, Please
 * https://atcoder.jp/contests/abc155/tasks/abc155_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc155/submissions/28652053
 *
 */
package contests.abc.abc155.abc155_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    boolean isDenied = false;
    while (n-- > 0) {
      int a = Integer.parseInt(st.nextToken());
      if (a % 2 == 0) {
        if (a % 3 != 0 && a % 5 != 0) {
          isDenied = true;
          break;
        }
      }
    }
    System.out.println(isDenied ? "DENIED" : "APPROVED");
    return;
  }
}
