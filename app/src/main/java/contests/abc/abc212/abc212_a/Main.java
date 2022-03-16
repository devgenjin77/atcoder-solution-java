/*
 * ABC212
 * A - Alloy
 * https://atcoder.jp/contests/abc212/tasks/abc212_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30168947
 */
package contests.abc.abc212.abc212_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  static void solve(BufferedReader br, PrintWriter pw) throws Exception {
    String[] input = br.readLine().split(" ");
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    String ans = b == 0 ? "Gold" : a == 0 ? "Silver" : "Alloy";
    pw.println(ans);
    pw.flush();
  }

  public static void main(String[] args) {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out)) {
      solve(br, pw);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
