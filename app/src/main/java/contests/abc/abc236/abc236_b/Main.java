/*
 * ABC236
 * B - Who is missing?
 * https://atcoder.jp/contests/abc236/tasks/abc236_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/28848728
 *
 */
package contests.abc.abc236.abc236_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int ans = 0;
    while(st.hasMoreElements()){
      ans = ans ^ Integer.parseInt(st.nextToken());
    }
    System.out.println(ans);
  }
}
