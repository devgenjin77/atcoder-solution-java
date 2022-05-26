/*
 * 競プロ典型90問
 * 075 - Magic For Balls（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bw
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31966330
 *
 * note:
 * -素因数分解する
 *
 */

package contests.typical90.typical90_08.typical90_075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();

    int div_cnt = 0;
    long num = n, div = 2;
    //素因数分解
    while(div * div <= num) {
      if(num % div == 0) {
        num /= div;
        div_cnt++;
      } else {
        div++;
      }
    }
    if(num > 1) {
      div_cnt++;
    }
    int ans = 0;
    div_cnt--;
    while(div_cnt > 0) {
      ans++;
      div_cnt >>= 1;
    }
    System.out.println(ans);
  }
}
