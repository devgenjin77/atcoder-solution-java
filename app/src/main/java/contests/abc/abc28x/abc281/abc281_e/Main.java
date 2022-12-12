/*
 * AtCoder Beginner Contest 281
 * E - Least Elements
 * https://atcoder.jp/contests/abc281/tasks/abc281_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc281/submissions/37236295
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc281.abc281_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    final long[] temp_a = new long[m];
    final long[] ans_a = new long[n - m + 1];
    final TreeMap<Long, Integer> tm_l = new TreeMap();
    final TreeMap<Long, Integer> tm_r = new TreeMap();
    for (int i = 0; i < m; i++) {
      temp_a[i] = array_a[i];
    }
    Arrays.sort(temp_a);
    for (int i = 0; i < m; i++) {
      if (i < k) {
        addValue(tm_l, temp_a[i]);
      } else {
        addValue(tm_r, temp_a[i]);
      }
    }
    for (long key : tm_l.keySet()) {
      ans_a[0] += key * tm_l.get(key);
    }
    for (int i = m; i < n; i++) {
      long val_l = array_a[i - m];
      long val_r = array_a[i];
      ans_a[i - m + 1] = ans_a[i - m];
      if (m == k) {
        removeValue(tm_l, val_l);
        addValue(tm_l, val_r);
        ans_a[i - m + 1] -= val_l;
        ans_a[i - m + 1] += val_r;
      } else {
        if (tm_l.containsKey(val_l)) {
          //S_lから削除して、S_rからもらう
          removeValue(tm_l, val_l);
          long first_r = tm_r.firstKey();
          removeValue(tm_r, first_r);
          addValue(tm_l, first_r);
          ans_a[i - m + 1] -= val_l;
          ans_a[i - m + 1] += first_r;
        } else {
          //S_rから削除するだけ
          removeValue(tm_r, val_l);
        }
        long last_l = tm_l.lastKey();
        if (last_l > val_r) {
          removeValue(tm_l, last_l);
          addValue(tm_r, last_l);
          addValue(tm_l, val_r);
          ans_a[i - m + 1] -= last_l;
          ans_a[i - m + 1] += val_r;
        } else {
          addValue(tm_r, val_r);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (long ans : ans_a) {
      sb.append(ans).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  static void addValue(TreeMap<Long, Integer> tm, long val) {
    tm.put(val, tm.getOrDefault(val, 0) + 1);
  }

  static void removeValue(TreeMap<Long, Integer> tm, long val) {
    if (tm.get(val) == 1) {
      tm.remove(val);
    } else {
      tm.put(val, tm.get(val) - 1);
    }
  }
}
