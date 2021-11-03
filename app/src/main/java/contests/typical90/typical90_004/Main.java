/*
 * 競プロ典型90問
 * 004 - Cross Sum（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_d
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/25621763
 *
 */
package contests.typical90.typical90_004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int h = Integer.parseInt(head[0]);
    int w = Integer.parseInt(head[1]);
    int[][] input_array = new int[h][w];
    int[] sum_of_row = new int[h];
    int[] sum_of_col = new int[w];

    for (int row = 0; row < h; row++) {
      int[] row_array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int col = 0; col < w; col++) {
        int val = row_array[col];
        input_array[row][col] = val;
        sum_of_row[row] += val;
        sum_of_col[col] += val;
      }
    }
    br.close();

    PrintWriter pw = new PrintWriter(System.out);
    for (int row = 0; row < h; row++) {
      StringBuilder sb = new StringBuilder();
      for (int col = 0; col < w; col++) {
        sb.append(sum_of_row[row] + sum_of_col[col] - input_array[row][col]);
        sb.append(' ');
      }
      pw.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
    pw.close();
  }
}
