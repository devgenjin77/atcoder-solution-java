/*
 * ABC221
 * D - Online games
 * https://atcoder.jp/contests/abc221/tasks/abc221_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/26373730
 */
package contests.abc.abc221.abc221_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ans_array = new int[n + 1];
    TreeMap<Integer, Integer> maps = new TreeMap<>();
    for(int i = 0; i < n; i++){
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      int to = a + b;
      maps.put(a, maps.getOrDefault(a, 0) + 1);
      maps.put(to, maps.getOrDefault(to, 0) - 1);
    }
    br.close();
    int nowdate = 0;
    int amount = 0;
    for(int nextdate : maps.keySet()){
      int dates = nextdate - nowdate;
      ans_array[amount] += dates;
      amount += maps.get(nextdate);
      nowdate = nextdate;
    }

    PrintWriter pw = new PrintWriter(System.out);
    for(int i = 1; i < ans_array.length; i++){
      if(i != 1){
        pw.print(" ");
      }
      pw.print(ans_array[i]);
    }
    pw.println();
    pw.close();
  }
}
