/*
 * ABC212
 * A - Alloy
 * https://atcoder.jp/contests/abc212/tasks/abc212_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/31639896
 */

package contests.abc.abc21x.abc212.abc212_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    if(a > 0 && b > 0) {
      System.out.println("Alloy");
    } else if(a == 0) {
      System.out.println("Silver");
    } else if(b == 0) {
      System.out.println("Gold");
    }
  }
}
