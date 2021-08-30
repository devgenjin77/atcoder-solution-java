/*
 * ABC216
 * A - Signed Difficulty
 * https://atcoder.jp/contests/abc215/tasks/abc216_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/25469411
 */
package contests.abc.abc216.abc216_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] data = br.readLine().split(Pattern.quote("."));
    br.close();
    String ans = data[0];
    int y = Integer.parseInt(data[1]);
    if(y <= 2){
      ans += "-";
    } else if(y >= 7){
      ans += "+";
    }
    System.out.println(ans);
  }
}
