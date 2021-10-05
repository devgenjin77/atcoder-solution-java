/*
 * ABC221
 * A - Seismic magnitude scales
 * https://atcoder.jp/contests/abc221/tasks/abc221_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/26277082
 */
package contests.abc.abc221.abc221_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] ab = br.readLine().split(" ");
    int a = Integer.parseInt(ab[0]);
    int b = Integer.parseInt(ab[1]);
    br.close();
    long ans = 1;
    for(int i = b; i < a; i++){
      ans *= 32;
    }
    System.out.println(ans);
  }
}
