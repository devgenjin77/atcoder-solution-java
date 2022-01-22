/*
 * ABC235
 * B - Climbing Takahashi
 * https://atcoder.jp/contests/abc235/tasks/abc235_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/28676926
 *
 */
package contests.abc.abc235.abc235_b;

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
    int ans = Integer.parseInt(st.nextToken());
    while(st.hasMoreElements()) {
      int next = Integer.parseInt(st.nextToken());
      if(next > ans) {
        ans = next;
      } else {
        break;
      }
    }
    System.out.println(ans);
  }
}
