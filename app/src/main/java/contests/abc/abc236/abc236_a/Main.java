/*
 * ABC236
 * A - chukodai
 * https://atcoder.jp/contests/abc236/tasks/abc236_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/28848648
 *
 */
package contests.abc.abc236.abc236_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    StringBuilder sb = new StringBuilder(s);
    int a = Integer.parseInt(st.nextToken()) - 1;
    int b = Integer.parseInt(st.nextToken()) - 1;
    sb.setCharAt(a, s.charAt(b));
    sb.setCharAt(b, s.charAt(a));
    System.out.println(sb);
  }
}
