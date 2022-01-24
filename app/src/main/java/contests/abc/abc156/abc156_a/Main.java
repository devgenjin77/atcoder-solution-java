/*
 * ABC156
 * A - Beginner
 * https://atcoder.jp/contests/abc156/tasks/abc156_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc156/submissions/28780985
 *
 */
package contests.abc.abc156.abc156_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    System.out.println(r + (Math.max(10 - n, 0) * 100));
    return;
  }
}
