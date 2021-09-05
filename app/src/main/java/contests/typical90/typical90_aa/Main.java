/*
 * 競プロ典型90問
 * 027 - Sign Up Requests （★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_aa
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/25636563
 *
 */
package contests.typical90.typical90_aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashSet<String> set = new HashSet<>();
    PrintWriter pw = new PrintWriter(System.out);
    for(int day = 1; day <= n; day++){
      String userName = br.readLine();
      if(set.contains(userName)){
        continue;
      } else {
        pw.println(day);
        set.add(userName);
      }
    }
    br.close();
    pw.close();
  }
}
