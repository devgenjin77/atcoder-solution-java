/*
 * ABC218
 * B - qwerty
 * https://atcoder.jp/contests/abc218/tasks/abc218_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/25801220
 */
package contests.abc.abc218.abc218_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] p = Stream.of(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value) - 1).toArray();
    br.close();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < p.length; i++){
      sb.append((char) ('a' + p[i]));
    }
    System.out.println(sb);
  }
}
