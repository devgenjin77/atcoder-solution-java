/*
 * 競プロ典型90問
 * 027 - Sign Up Requests （★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_aa
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31926769
 *
 * note:
 * - mapをつかう
 *
 */

package contests.typical90.typical90_03.typical90_027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<String> used_name = new HashSet<>();
    PrintWriter pw = new PrintWriter(System.out);
    for (int id = 1; id <= n; id++) {
      String name = br.readLine();
      if (!used_name.contains(name)) {
        used_name.add(name);
        pw.println(id);
      }
    }
    pw.close();
    br.close();
  }
}
