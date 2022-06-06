/*
 * ABC240
 * B - Count Distinct Integers
 * https://atcoder.jp/contests/abc240/tasks/abc240_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/32288959
 *
 */

package contests.abc.abc24x.abc240.abc240_b;

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
    Set<Integer> set_a = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set_a.add(Integer.parseInt(st.nextToken()));
    }
    System.out.println(set_a.size());
  }
}
