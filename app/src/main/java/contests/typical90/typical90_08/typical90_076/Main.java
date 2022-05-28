/*
 * 競プロ典型90問
 * 076 - Cake Cut（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bx
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31986179
 *
 * note:
 * -しゃくとり法で解いた
 * -想定解は円環を二倍の配列で加工する方法だった模様
 *
 */

package contests.typical90.typical90_08.typical90_076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    long[] array_a = new long[n];
    long total = 0;
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
      total += array_a[i];
    }
    br.close();

    boolean ret = false;
    if (total % 10 == 0) {
      long onetenth = total / 10;
      long sub_total = array_a[0];
      int left = 0, right = 1;
      while (true) {
        if (sub_total > onetenth) {
          if (left >= n) {
            break;
          }
          sub_total -= array_a[left++];
        } else if (sub_total < onetenth) {
          sub_total += array_a[(right++) % n];
        } else {
          ret = true;
          break;
        }
      }
    }
    System.out.println(ret ? "Yes" : "No");
  }
}
