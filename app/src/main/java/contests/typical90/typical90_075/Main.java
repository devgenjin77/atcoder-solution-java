/*
 * 競プロ典型90問
 * 075 - Magic For Balls（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bw
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28482921
 *
 */
package contests.typical90.typical90_075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    long n = Long.parseLong(br.readLine());
    br.close();
    int cnt = 0;
    long tmp = n;
    while (tmp % 2 == 0) {
      tmp /= 2;
      cnt++;
    }
    long sqrt_n = (long) Math.sqrt(n);
    for (long div = 3; div <= sqrt_n; div += 2) {
      while (tmp % div == 0) {
        tmp /= div;
        cnt++;
      }
    }
    if(tmp > 1){
      cnt++;
    }
    System.out.println(cnt > 1 ? Integer.toBinaryString(cnt - 1).length() : 0);
  }
}
