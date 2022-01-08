/*
 * 競プロ典型90問
 * 061 - Deck（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bi
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28373404
 *
 */
package contests.typical90.typical90_061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(br.readLine());
    int[] deck1 = new int[q];
    int[] deck2 = new int[q];
    int idx_deck1 = 0;
    int idx_deck2 = 0;
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      switch (t) {
        case 1:
          deck1[idx_deck1] = x;
          idx_deck1++;
          break;
        case 2:
          deck2[idx_deck2] = x;
          idx_deck2++;
          break;
        case 3:
          if (x > idx_deck1) {
            pw.println(deck2[(x - idx_deck1) - 1]);
          } else {
            pw.println(deck1[idx_deck1 - x]);
          }
          break;
        default:
          break;
      }
    }
    pw.close();
    br.close();
  }
}
