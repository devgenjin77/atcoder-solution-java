/*
 * ABC240
 * B - Count Distinct Integers
 * https://atcoder.jp/contests/abc240/tasks/abc240_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/29643074
 *
 */
package contests.abc.abc240.abc240_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    Set<Integer> set = new HashSet<>();
    while (st.hasMoreTokens()) {
      set.add(Integer.parseInt(st.nextToken()));
    }
    System.out.println(set.size());
  }
}
