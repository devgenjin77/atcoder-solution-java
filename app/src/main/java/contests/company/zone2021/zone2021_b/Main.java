/*
 * ZONeエナジー プログラミングコンテスト “HELLO SPACE”
 * B - 友好の印
 * https://atcoder.jp/contests/zone2021/tasks/zone2021_b
 *
 * verified:
 * - https://atcoder.jp/contests/zone2021/submissions/22268188
 */
package contests.company.zone2021.zone2021_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st_head = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st_head.nextToken());
    int d = Integer.parseInt(st_head.nextToken());
    int h = Integer.parseInt(st_head.nextToken());
    double ans = 0.0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st_data = new StringTokenizer(br.readLine());
      int dx = Integer.parseInt(st_data.nextToken());
      int hx = Integer.parseInt(st_data.nextToken());
      double temp = (double) dx * (h - hx) / (d - dx);
      ans = Math.max(hx - temp, ans);
    }
    br.close();
    System.out.println(ans);
  }
}
