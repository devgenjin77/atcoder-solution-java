/*
 * ARC130
 * A - Remove One Character
 * https://atcoder.jp/contests/arc130/tasks/arc130_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc130/submissions/27607325
 */
package contests.arc.arc130.arc130_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    long ans = 0, cnt = 0;
    for(int i = 1; i < s.length(); i++){
      if(s.charAt(i - 1) == s.charAt(i)){
        cnt += 1;
        ans += cnt;
      } else {
        cnt = 0;
      }
    }
    System.out.println(ans);
  }
}
