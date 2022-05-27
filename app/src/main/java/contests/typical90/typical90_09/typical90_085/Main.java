/*
 * 競プロ典型90問
 * 085 - Multiplication 085（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cg
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31979639
 *
 * note:
 * -約数列挙を行う
 *
 */

package contests.typical90.typical90_09.typical90_085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long k = Long.parseLong(br.readLine());
    br.close();
    int ans = 0;
    List<Long> divlist = divisorList(k);
    Collections.sort(divlist);
    for (int i = 0; i < divlist.size(); i++) {
      for (int j = i; j < divlist.size(); j++) {
        long bc = k / divlist.get(i);
        long b = divlist.get(j);
        if (bc % b == 0 && bc / b >= b) {
          ans++;
        } else {
          if (bc / b < b) {
            break;
          }
        }
      }
    }
    System.out.println(ans);
  }

  //約数列挙
  static List<Long> divisorList(long n) {
    List<Long> ret = new ArrayList<>();
    for (long x = 1l; x * x <= n; x++) {
      if (n % x == 0) {
        ret.add(x);
        if (n / x != x) {
          ret.add(n / x);
        }
      }
    }
    return ret;
  }
}
