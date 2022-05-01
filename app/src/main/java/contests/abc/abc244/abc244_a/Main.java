/*
 * ABC244
 * A - Last Letter
 * https://atcoder.jp/contests/abc244/tasks/abc244_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/31376245
 *
 */

package contests.abc.abc244.abc244_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[] c_buf = new char[n];
    br.read(c_buf);
    br.close();
    System.out.println(c_buf[n - 1]);
  }
}
