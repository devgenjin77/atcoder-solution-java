/*
 * ABC250
 * E - Prefix Equality
 * https://atcoder.jp/contests/abc250/tasks/abc250_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31592275
 *
 * note:
 * setA,setBをequals比較すると、件数が多い時に重いようなので、
 * AにもBにも存在する要素を管理する集合setABを管理する
 *
 */

package contests.abc.abc250.abc250_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());
    int[] set_cnt_a = new int[n];
    int[] set_cnt_b = new int[n];
    boolean[] is_same_at_cnt = new boolean[n + 1];
    is_same_at_cnt[0] = true;
    Set<Integer> set_a = new HashSet<>();
    Set<Integer> set_b = new HashSet<>();
    Set<Integer> set_ab = new HashSet<>();
    int idx_a = 0, idx_b = 0;
    int tgt_cnt = 1;
    while (st_a.hasMoreElements() && st_b.hasMoreElements()) {
      while (st_a.hasMoreElements() && set_a.size() < tgt_cnt) {
        int a = Integer.parseInt(st_a.nextToken());
        set_a.add(a);
        set_cnt_a[idx_a++] = set_a.size();
        if(set_b.contains(a)) {
          set_ab.add(a);
        }
      }
      while (st_b.hasMoreElements() && set_b.size() < tgt_cnt) {
        int b = Integer.parseInt(st_b.nextToken());
        set_b.add(b);
        set_cnt_b[idx_b++] = set_b.size();
        if(set_a.contains(b)) {
          set_ab.add(b);
        }
      }
      if (set_a.size() == tgt_cnt && set_b.size() == tgt_cnt) {
        is_same_at_cnt[tgt_cnt] = set_ab.size() == tgt_cnt;
      }
      tgt_cnt++;
    }
    while (st_a.hasMoreElements()) {
      set_a.add(Integer.parseInt(st_a.nextToken()));
      set_cnt_a[idx_a++] = set_a.size();
    }
    while (st_b.hasMoreElements()) {
      set_b.add(Integer.parseInt(st_b.nextToken()));
      set_cnt_b[idx_b++] = set_b.size();
    }

    PrintWriter pw = new PrintWriter(System.out);
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      if (set_cnt_a[x] == set_cnt_b[y] && is_same_at_cnt[set_cnt_a[x]]) {
        pw.println("Yes");
      } else {
        pw.println("No");
      }
    }
    pw.close();
    br.close();
  }
}
