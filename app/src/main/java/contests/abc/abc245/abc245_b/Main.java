/*
 * ABC245
 * B - Mex
 * https://atcoder.jp/contests/abc245/tasks/abc245_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/30503930
 *
 */

package contests.abc.abc245.abc245_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] input_a = br.readLine().split(" ");
    br.close();
    Set<Integer> set = new HashSet<>();
    for(String str_a : input_a) {
      set.add(Integer.parseInt(str_a));
    }
    int num = 0;
    while(set.contains(num)) {
      num++;
    }
    System.out.println(num);
  }
}
