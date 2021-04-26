/*
 * ABC198
 * D - Send More Money
 * https://atcoder.jp/contests/abc198/tasks/abc198_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc198/submissions/21839588
 */
package contests.abc.abc198.abc198_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int[] idx_to_num = new int[10];
  static int[] num_to_idx = new int[10];
  static String[] s_array = new String[3];
  static long[] answers = new long[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s_array[0] = br.readLine();
    s_array[1] = br.readLine();
    s_array[2] = br.readLine();
    br.close();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s_array.length; i++) {
      for (int j = 0; j < s_array[i].length(); j++) {
        if (sb.indexOf(s_array[i].substring(j, j + 1)) < 0) {
          sb.append(s_array[i].charAt(j));
        }
      }
    }

    String allchars = sb.toString();
    if (allchars.length() > 10) {
      System.out.println("UNSOLVABLE");
      return;
    }
    StringBuilder firstcharsbuf = new StringBuilder();
    for(int i = 0; i < s_array.length; i++){
      firstcharsbuf.append(s_array[i].charAt(0));
    }
    String firstchars = firstcharsbuf.toString();

    Arrays.fill(idx_to_num, -1);
    Arrays.fill(num_to_idx, -1);
    if(dfs(allchars, firstchars, 0)){
      for(long answer : answers){
        System.out.println(answer);
      }
    } else {
      System.out.println("UNSOLVABLE");
    }
  }

  static boolean dfs(String allchars, String firstchars, int depth) {
    if (allchars.length() == depth) {
      answers[0] = strToNum(s_array[0], allchars);
      answers[1] = strToNum(s_array[1], allchars);
      answers[2] = strToNum(s_array[2], allchars);

      if(answers[0] + answers[1] == answers[2]){
        return true;
      } else {
        return false;
      }
    }
    for(int i = 0; i < 10; i++){
      if(i == 0 && firstchars.indexOf(allchars.charAt(depth)) >= 0){
        continue;
      }
      if(num_to_idx[i] >= 0){
        continue;
      } else {
        num_to_idx[i] = depth;
        idx_to_num[depth] = i;
        if(dfs(allchars, firstchars, depth + 1)){
          return true;
        }
        num_to_idx[i] = -1;
        idx_to_num[depth] = -1;
      }
    }
    return false;
  }

  static long strToNum(String str, String allchars) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < str.length(); i++){
      int idx_of_allchars = allchars.indexOf(str.charAt(i));
      sb.append(idx_to_num[idx_of_allchars]);
    }
    return Long.parseLong(sb.toString());
  }
}