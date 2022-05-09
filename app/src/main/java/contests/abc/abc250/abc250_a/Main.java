/*
 * ABC250
 * A - Adjacent Squares
 * https://atcoder.jp/contests/abc250/tasks/abc250_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31571442
 *
 */


package contests.abc.abc250.abc250_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st1.nextToken());
    int w = Integer.parseInt(st1.nextToken());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st2.nextToken());
    int c = Integer.parseInt(st2.nextToken());
    br.close();

    int ans = 0;
    if (r != 1) {
      ans++;
    }
    if (r != h) {
      ans++;
    }
    if (c != 1) {
      ans++;
    }
    if (c != w) {
      ans++;
    }
    System.out.println(ans);
  }
}
