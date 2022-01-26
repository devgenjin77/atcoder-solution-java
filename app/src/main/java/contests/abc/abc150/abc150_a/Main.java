/*
 * ABC150
 * A - 500 Yen Coins
 * https://atcoder.jp/contests/abc150/tasks/abc150_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc150/submissions/28813984
 *
 */
package contests.abc.abc150.abc150_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(500 * k >= x ? "Yes" : "No");
    return;
  }
}
