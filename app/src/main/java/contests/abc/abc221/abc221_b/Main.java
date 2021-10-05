/*
 * ABC221
 * B - typo
 * https://atcoder.jp/contests/abc221/tasks/abc221_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/26373406
 */
package contests.abc.abc221.abc221_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String t = br.readLine();
    br.close();
    System.out.println(solve(s, t) ? "Yes" : "No");
  }

  static boolean solve(String s, String t){
    if(t.equals(s)){
      return true;
    }
    int len = t.length();
    int idx = 0;
    while(idx < len - 1){
      char c_s = s.charAt(idx);
      if(c_s != t.charAt(idx)){
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(idx, s.charAt(idx + 1));
        sb.setCharAt(idx + 1, c_s);
        if(t.equals(sb.toString())){
          return true;
        } else {
          return false;
        }
      }
      idx++;
    }
    return false;
  }
}
