/*
 * ABC197
 * B - Visibility
 * https://atcoder.jp/contests/abc197/tasks/abc197_b
 *
 * - https://atcoder.jp/contests/abc197/submissions/22098560
 */
package contests.abc.abc197.abc197_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(head.nextToken());
    int w = Integer.parseInt(head.nextToken());
    int x = Integer.parseInt(head.nextToken()) - 1;
    int y = Integer.parseInt(head.nextToken()) - 1;
    String[] map = new String[h];
    for (int i = 0; i < h; i++) {
      map[i] = br.readLine();
    }
    br.close();

    int answer = 1;

    // Up
    int upcnt = 1;
    while (x - upcnt >= 0) {
      if (map[x - upcnt].charAt(y) == '#') {
        break;
      } else {
        upcnt++;
      }
    }
    answer += (upcnt - 1);

    // Down
    int downcnt = 1;
    while (x + downcnt < h) {
      if (map[x + downcnt].charAt(y) == '#') {
        break;
      } else {
        downcnt++;
      }
    }
    answer += (downcnt - 1);

    // Left
    int leftcnt = 1;
    while (y - leftcnt >= 0) {
      if (map[x].charAt(y - leftcnt) == '#') {
        break;
      } else {
        leftcnt++;
      }
    }
    answer += (leftcnt - 1);

    // Right
    int rightcnt = 1;
    while (y +  rightcnt < w) {
      if (map[x].charAt(y +  rightcnt) == '#') {
        break;
      } else {
        rightcnt++;
      }
    }
    answer += (rightcnt - 1);
    System.out.println(answer);
  }
}