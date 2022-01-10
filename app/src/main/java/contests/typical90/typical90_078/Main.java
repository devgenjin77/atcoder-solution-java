/*
 * 競プロ典型90問
 * 078 - Easy Graph Problem（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bz
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28444500
 *
 */
package contests.typical90.typical90_078;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(head.nextToken());
    int m = Integer.parseInt(head.nextToken());
    int[] array = new int[n];
    for (int i = 0; i < m; i++) {
      StringTokenizer edge = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(edge.nextToken()) - 1;
      int b = Integer.parseInt(edge.nextToken()) - 1;
      array[Math.max(a, b)] += 1;
    }
    br.close();
    System.out.println(Arrays.stream(array).filter(cnt -> cnt == 1).count());
  }
}
