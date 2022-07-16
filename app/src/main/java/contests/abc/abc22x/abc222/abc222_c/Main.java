/*
 * エクサウィザーズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 222）
 * C - Swiss-System Tournament
 * https://atcoder.jp/contests/abc222/tasks/abc222_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc222/submissions/33250869
 *
 * note:
 * じゃんけんトーナメント
 *
 */

package contests.abc.abc22x.abc222.abc222_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    List<Player> playerList = new ArrayList<>();
    for (int i = 1; i <= 2 * n; i++) {
      playerList.add(new Player(i, br.readLine()));
    }
    br.close();
    for (int r = 0; r < m; r++) {
      for (int i = 0; i < n; i++) {
        fight(playerList.get(i * 2), playerList.get((i * 2) + 1), r);
      }
      Collections.sort(playerList);
    }

    PrintWriter pw = new PrintWriter(System.out);
    for (Player p : playerList) {
      pw.println(p.no());
    }
    pw.close();
  }

  static void fight(Player p1, Player p2, int round) {
    if (p1.gcp(round) == p2.gcp(round)) {
      //引き分けの場合はなにもせず
      return;
    }
    if ((p1.gcp(round) == 'G' && p2.gcp(round) == 'C') ||
        (p1.gcp(round) == 'C' && p2.gcp(round) == 'P') ||
        (p1.gcp(round) == 'P' && p2.gcp(round) == 'G')) {
      p1.win();
    } else {
      p2.win();
    }
  }

  static class Player implements Comparable<Player> {

    private int no, win;
    private String str_gcp;

    public Player(int no, String str_gcp) {
      this.no = no;
      this.str_gcp = str_gcp;
      this.win = 0;
    }

    public int no() {
      return this.no;
    }

    public void win() {
      this.win++;
    }

    public char gcp(int round) {
      return str_gcp.charAt(round);
    }

    @Override
    public int compareTo(Player o) {
      //勝ち数の降順、プレイヤーの番号の昇順でソートする
      int cmp = Integer.compare(o.win, this.win);
      if (cmp != 0) {
        return cmp;
      } else {
        return Integer.compare(this.no, o.no);
      }
    }
  }
}
