/*
 * 競プロ典型90問
 * 018 - Statue of Chokudai（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_r
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27966866
 *
 */
package contests.typical90.typical90_018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    String[] lxy = br.readLine().split(" ");
    int l = Integer.parseInt(lxy[0]);
    double x = Double.parseDouble(lxy[1]);
    double y = Double.parseDouble(lxy[2]);
    int q = Integer.parseInt(br.readLine());
    PrintWriter pw = new PrintWriter(System.out);
    double x2 = x * x;
    for(int i = 0; i < q; i++){
      int e = Integer.parseInt(br.readLine());
      double rad = Math.toRadians(360.0 * e / t);
      double pt_y = (-1.0 * l * Math.sin(rad)) / 2.0;
      double dist_xy = Math.sqrt(x2 + ((y - pt_y) * (y - pt_y)));
      double pt_z = l * (1.0 - Math.cos(rad)) / 2.0;
      pw.println(Math.toDegrees(Math.atan2(pt_z, dist_xy)));
    }
    pw.close();
    br.close();
  }
}
