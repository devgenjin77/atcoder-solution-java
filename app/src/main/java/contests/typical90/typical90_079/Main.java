/*
 * 競プロ典型90問
 * 079 - Two by Two（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ca
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28445597
 *
 */
package contests.typical90.typical90_079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(head.nextToken());
    int w = Integer.parseInt(head.nextToken());
    int[][] array_a = new int[h][w];
    int[][] array_b = new int[h][w];
    for (int i = 0; i < h; i++) {
      StringTokenizer data = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        array_a[i][j] = Integer.parseInt(data.nextToken());
      }
    }
    for (int i = 0; i < h; i++) {
      StringTokenizer data = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        array_b[i][j] = Integer.parseInt(data.nextToken());
      }
    }
    br.close();
    boolean isSame = true;
    long cnt = 0;
    main_loop:
    for (int pos_r = 0; pos_r < h - 1; pos_r++) {
      for (int pos_c = 0; pos_c < w - 1; pos_c++) {
        int diff = array_b[pos_r][pos_c] - array_a[pos_r][pos_c];
        cnt += Math.abs(diff);
        array_a[pos_r][pos_c] += diff;
        array_a[pos_r + 1][pos_c] += diff;
        array_a[pos_r][pos_c + 1] += diff;
        array_a[pos_r + 1][pos_c + 1] += diff;
      }
      //最後尾列チェック
      if (array_a[pos_r][w - 1] != array_b[pos_r][w - 1]) {
        isSame = false;
        break main_loop;
      }
    }
    //最終行チェック
    for (int col = 0; col < w; col++) {
      if (array_a[h - 1][col] != array_b[h - 1][col]) {
        isSame = false;
        break;
      }
    }
    if (isSame) {
      System.out.println("Yes");
      System.out.println(cnt);
    } else {
      System.out.println("No");
    }
  }
}
