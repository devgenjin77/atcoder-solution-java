/*
 * ABC153
 * A - Serval vs Monster
 * https://atcoder.jp/contests/abc153/tasks/abc153_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc153/submissions/28576623
 *
 */
package contests.abc.abc153.abc153_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(head.nextToken());
    int a = Integer.parseInt(head.nextToken());
    br.close();
    System.out.println((h + a - 1) / a);
    return;
  }
}
