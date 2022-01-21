/*
 * ABC155
 * A - Poor
 * https://atcoder.jp/contests/abc155/tasks/abc155_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc155/submissions/28666954
 *
 */
package contests.abc.abc155.abc155_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    Set<String> set = new HashSet<>();
    set.add(st.nextToken());  //A
    set.add(st.nextToken());  //B
    set.add(st.nextToken());  //C
    System.out.println(set.size() == 2 ? "Yes" : "No");
    return;
  }
}
