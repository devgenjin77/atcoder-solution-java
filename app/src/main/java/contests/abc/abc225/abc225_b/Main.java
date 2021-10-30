/*
 * ABC225
 * B - Star or Not
 * https://atcoder.jp/contests/abc225/tasks/abc225_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/26939013
 */
package contests.abc.abc225.abc225_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] degree = new int[n];
    for (int i = 0; i < n - 1; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]) - 1;
      int b = Integer.parseInt(ab[1]) - 1;
      degree[a] += 1;
      degree[b] += 1;
    }
    br.close();

    boolean isStar = false;
    for (int i = 0; i < n; i++) {
      if (degree[i] == n - 1) {
        isStar = true;
        break;
      }
    }
    System.out.println(isStar ? "Yes" : "No");
  }
}
