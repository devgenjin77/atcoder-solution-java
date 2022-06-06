/*
 * ABC240
 * A - Edge Checker
 * https://atcoder.jp/contests/abc240/tasks/abc240_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/32288676
 *
 */

package contests.abc.abc24x.abc240.abc240_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println((b - a == 1 || b - a == 9) ? "Yes" : "No");
  }
}
