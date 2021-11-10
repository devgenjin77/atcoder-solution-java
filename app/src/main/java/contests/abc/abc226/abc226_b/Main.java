/*
 * ABC226
 * B - Counting Arrays
 * https://atcoder.jp/contests/abc226/tasks/abc226_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/27167399
 */
package contests.abc.abc226.abc226_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }
    br.close();
    System.out.println(set.size());
  }
}
