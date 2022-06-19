/*
 * 競プロ典型90問
 * 051 - Typical Shop（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ay
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32612481
 *
 * note:
 * -半分全列挙をする
 *
 */

package contests.typical90.typical90_06.typical90_051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final long p = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final List<Long> array_a1 = new ArrayList<>();
    final List<Long> array_a2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(st_a.nextToken());
      if (i % 2 == 0) {
        array_a1.add(a);
      } else {
        array_a2.add(a);
      }
    }
    br.close();

    List<List<Long>> list1 = createList(array_a1);
    List<List<Long>> list2 = createList(array_a2);

    for (int i = 1; i < list2.size(); i++) {
      Collections.sort(list2.get(i));
    }

    long ans = 0;
    for (int i1 = 0; i1 < list1.size(); i1++) {
      int i2 = k - i1;
      if (i2 < 0 || i2 >= list2.size()) {
        continue;
      }
      for (long v1 : list1.get(i1)) {
        long v2 = p - v1 + 1;
        int idx = Collections.binarySearch(list2.get(i2), v2);
        if (idx < 0) {
          idx = ~idx;
        }
        ans += idx;
      }
    }
    System.out.println(ans);
  }

  //全列挙リストを作成
  static List<List<Long>> createList(List<Long> array) {
    List<List<Long>> list_ret = new ArrayList<>(array.size() + 1);
    for (int i = 0; i <= array.size(); i++) {
      list_ret.add(new ArrayList<>());
    }
    list_ret.get(0).add(0L);
    for (int bit = 1; bit < (1 << array.size()); bit++) {
      long sum = 0;
      for (int i = 0; i < array.size(); i++) {
        if (((bit >> i) & 1) == 0) {
          continue;
        }
        sum += array.get(i);
      }
      int cnt = Integer.bitCount(bit);
      list_ret.get(cnt).add(sum);
    }
    return list_ret;
  }
}
