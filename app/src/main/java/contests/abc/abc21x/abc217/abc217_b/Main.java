/*
 * AtCoder Beginner Contest 217
 * B - AtCoder Quiz
 * https://atcoder.jp/contests/abc217/tasks/abc217_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/32488432
 *
 */

package contests.abc.abc21x.abc217.abc217_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  final static String[] arr_contests = {"ABC", "ARC", "AGC", "AHC"};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> set_s = new HashSet<>();
    set_s.add(br.readLine());
    set_s.add(br.readLine());
    set_s.add(br.readLine());
    br.close();
    for (String s : arr_contests) {
      if (!set_s.contains(s)) {
        System.out.println(s);
        break;
      }
    }
  }
}
