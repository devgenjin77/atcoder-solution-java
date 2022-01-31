/*
 * ABC237
 * D - LR insertion
 * https://atcoder.jp/contests/abc237/tasks/abc237_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/28979033
 *
 */
package contests.abc.abc237.abc237_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    int[] array_a = new int[n + 1];
    int idx_l = 0;
    int idx_r = array_a.length - 1;
    for(int i = 0; i < n; i++){
      if(s.charAt(i) == 'L'){
        array_a[idx_r] = i;
        idx_r--;
      } else {
        array_a[idx_l] = i;
        idx_l++;
      }
    }
    array_a[idx_l] = n;
    PrintWriter pw = new PrintWriter(System.out);
    pw.print(array_a[0]);
    for(int i = 1; i < array_a.length; i++){
      pw.print(" ");
      pw.print(array_a[i]);
    }
    pw.close();
  }
}
