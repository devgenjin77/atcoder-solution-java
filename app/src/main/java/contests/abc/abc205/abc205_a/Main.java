/*
 * ABC205
 * A - kcal
 * https://atcoder.jp/contests/abc205/tasks/abc205_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/23497530
 */
package contests.abc.abc205.abc205_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    System.out.println((a * b) / 100.0);
  }
}
