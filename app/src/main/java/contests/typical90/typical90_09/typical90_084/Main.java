/*
 * 競プロ典型90問
 * 084 - There are two types of characters（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cf
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31981151
 *
 * note:
 * -ランレングス圧縮
 *
 */

package contests.typical90.typical90_09.typical90_084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    List<Long> runlength = new ArrayList<>();
    char prev = s.charAt(0);
    long cnt = 1;
    for(int i = 1; i < n; i++) {
      char c = s.charAt(i);
      if(c == prev) {
        cnt++;
      } else {
        runlength.add(cnt);
        prev = c;
        cnt = 1;
      }
    }
    runlength.add(cnt);

    long ans = 0, remain = n;
    for(int i = 0; i < runlength.size() - 1; i++) {
      long len = runlength.get(i);
      remain -= len;
      ans += len * remain;
    }
    System.out.println(ans);
  }
}
