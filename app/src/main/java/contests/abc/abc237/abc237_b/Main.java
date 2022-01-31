/*
 * ABC237
 * B - Matrix Transposition
 * https://atcoder.jp/contests/abc237/tasks/abc237_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/28976681
 *
 */
package contests.abc.abc237.abc237_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int[][] array_a = new int[h][w];
    for(int i = 0; i < h; i++){
      StringTokenizer line = new StringTokenizer(br.readLine());
      for(int j = 0; j < w; j++){
        array_a[i][j] = Integer.parseInt(line.nextToken());
      }
    }
    br.close();

    PrintWriter pw = new PrintWriter(System.out);
    for(int pos_w = 0; pos_w < w; pos_w++){
      for(int pos_h = 0; pos_h < h; pos_h++){
        pw.printf(pos_h == 0 ? "%d" : " %d",array_a[pos_h][pos_w]);
      }
      pw.println();
    }
    pw.close();
    System.out.println();
  }
}
