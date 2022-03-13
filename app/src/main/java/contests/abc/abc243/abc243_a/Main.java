/*
 * ABC243
 * A - Shampoo
 * https://atcoder.jp/contests/abc243/tasks/abc243_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/30109998
 *
 */
package contests.abc.abc243.abc243_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    br.close();

    int rem = v % (a + b + c);
    char ans;
    if (rem < a) {
      ans = 'F';
    } else {
      ans = rem < a + b ? 'M' : 'T';
    }
    System.out.println(ans);
  }
}
