/*
 * ABC217
 * B - AtCoder Quiz
 * https://atcoder.jp/contests/abc217/tasks/abc217_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/25727311
 */
package contests.abc.abc217.abc217_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    HashSet<String> set = new HashSet<>();
    set.add("ABC");
    set.add("ARC");
    set.add("AGC");
    set.add("AHC");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0; i < 3; i++){
      set.remove(br.readLine());
    }
    br.close();
    System.out.println(set.iterator().next());
  }
}