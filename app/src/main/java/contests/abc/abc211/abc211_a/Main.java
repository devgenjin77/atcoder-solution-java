/*
 * ABC211
 * A - Blood Pressure
 * https://atcoder.jp/contests/abc211/tasks/abc211_a
 *
 * - https://atcoder.jp/contests/abc211/submissions/24527965
 */
package contests.abc.abc211.abc211_a;

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
    System.out.println(b + ((a - b) / 3.0));
  }
}
