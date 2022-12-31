/*
 * AtCoder Regular Contest 104
 * A - Plus Minus
 * https://atcoder.jp/contests/arc104/tasks/arc104_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc104/submissions/37658459
 *
 * note:
 *
 */

package contests.arc.arc10x.arc104.arc104_a;

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
    final int x = (a + b) / 2;
    final int y = a - x;
    System.out.println(x + " " + y);
  }
}
