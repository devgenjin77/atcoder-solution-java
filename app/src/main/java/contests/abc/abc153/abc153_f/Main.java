/*
 * ABC153
 * F - Silver Fox vs Monster
 * https://atcoder.jp/contests/abc153/tasks/abc153_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc153/submissions/28590715
 *
 */
package contests.abc.abc153.abc153_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(head.nextToken());
    int d = Integer.parseInt(head.nextToken());
    long a = Long.parseLong(head.nextToken());
    Monster[] array_m = new Monster[n];
    int[] array_pos = new int[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int pos = Integer.parseInt(st.nextToken());
      long hp = Long.parseLong(st.nextToken());
      array_m[i] = new Monster(pos, hp);
      array_pos[i] = pos;
    }
    br.close();

    Arrays.sort(array_pos);
    HashMap<Integer, Integer> idx_map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      idx_map.put(array_pos[i], i);
    }
    long[] array_hp = new long[n];
    long[] damage_sum = new long[n];
    for (int i = 0; i < n; i++) {
      array_hp[idx_map.get(array_m[i].pos)] = array_m[i].hp;
    }

    long cnt = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        damage_sum[i] += damage_sum[i - 1];
      }
      if (array_hp[i] > damage_sum[i]) {
        long remain = array_hp[i] - damage_sum[i];
        long bomb_cnt = (remain + a - 1) / a;
        cnt += bomb_cnt;
        long damage = a * bomb_cnt;
        damage_sum[i] += damage;
        int next_idx = Arrays.binarySearch(array_pos, array_pos[i] + (2 * d));
        if (next_idx < 0) {
          next_idx = ~next_idx;
        } else {
          next_idx += 1;
        }
        if (next_idx < n) {
          damage_sum[next_idx] -= damage;
        }
      }
    }
    System.out.println(cnt);
    return;
  }

  static class Monster {

    int pos;
    long hp;

    Monster(int pos, long hp) {
      this.pos = pos;
      this.hp = hp;
    }
  }
}
