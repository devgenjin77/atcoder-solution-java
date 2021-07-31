/*
 * ABC212
 * A - Alloy
 * https://atcoder.jp/contests/abc212/tasks/abc212_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/24697130
 */
package contests.abc.abc212.abc212_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    br.close();
    int a = Integer.parseInt(head[0]);
    int b = Integer.parseInt(head[1]);
    System.out.println(solve(a, b));
  }

  static String solve(int a, int b){
    if(a == 0){
      return "Silver";
    } else if(b == 0){
      return "Gold";
    } else {
      return "Alloy";
    }
  }
}
