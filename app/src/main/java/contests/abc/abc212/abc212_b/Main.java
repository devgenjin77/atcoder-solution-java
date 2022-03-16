/*
 * ABC212
 * B - Weak Password
 * https://atcoder.jp/contests/abc212/tasks/abc212_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30170659
 */
package contests.abc.abc212.abc212_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  static void solve(BufferedReader br, PrintWriter pw) throws Exception {
    pw.println(isWeakPassword(br.readLine()) ? "Weak" : "Strong");
  }

  static boolean isWeakPassword(String pwd) {
    boolean isAllSame = true;
    // 全ての数字が同じかを判断
    for (int i = 1; i < pwd.length(); i++) {
      if (isAllSame && pwd.charAt(i - 1) != pwd.charAt(i)) {
        isAllSame = false;
        break;
      }
    }
    if (isAllSame) {
      return true;
    }
    boolean isAllNext = true;
    // 次の桁の数字が前の桁の数字のプラス１であるか判断
    for (int i = 1; i < pwd.length(); i++) {
      int prev = pwd.charAt(i - 1) - '0';
      int now = pwd.charAt(i) - '0';
      if (now != (prev + 1) % 10) {
        isAllNext = false;
        break;
      }
    }
    if (isAllNext) {
      return true;
    }
    return false;
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
