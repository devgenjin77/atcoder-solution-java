/*
 * ABC236
 * C - Route Map
 * https://atcoder.jp/contests/abc236/tasks/abc236_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/28848847
 *
 */
package contests.abc.abc236.abc236_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer nm = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(nm.nextToken());
    int m = Integer.parseInt(nm.nextToken());
    String[] array_s = br.readLine().split(" ");
    String[] array_t = br.readLine().split(" ");
    br.close();
    PrintWriter pw = new PrintWriter(System.out);
    int idx_t = 0;
    for(int idx_s = 0; idx_s < n; idx_s++){
      if(array_t[idx_t].equals(array_s[idx_s])){
        idx_t++;
        pw.println("Yes");
      } else {
        pw.println("No");
      }
    }
    pw.close();
  }
}
