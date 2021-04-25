/*
 * ABC199
 * C - IPFL
 * https://atcoder.jp/contests/abc199/tasks/abc199_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc199/submissions/22069307
 */
package contests.abc.abc199.abc199_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int len = 2 * n;
    String s = br.readLine();
    StringBuilder sb = new StringBuilder(s);
    int q = Integer.parseInt(br.readLine());
    boolean isChanged = false;
    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      if ("1".equals(type)) {
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        if (isChanged) {
          a = (a + n) % len;
          b = (b + n) % len;
        }
        char from_a = sb.charAt(a);
        char from_b = sb.charAt(b);
        sb.setCharAt(b, from_a);
        sb.setCharAt(a, from_b);
      } else {
        isChanged = !isChanged;
      }
    }
    br.close();
    System.out.println(isChanged ? sb.substring(n) + sb.substring(0, n) : sb.toString());
  }
}
