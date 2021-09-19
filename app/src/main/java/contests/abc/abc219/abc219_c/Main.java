/*
 * サイシードプログラミングコンテスト2021（AtCoder Beginner Contest 219）
 * C - Neo-lexicographic Ordering
 * https://atcoder.jp/contests/abc219/tasks/abc219_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/25998600
 */
package contests.abc.abc219.abc219_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String x = br.readLine();
    int n = Integer.parseInt(br.readLine());
    ArrayList<String> list = new ArrayList<>(n);
    for(int i = 0; i < n; i++){
      list.add(br.readLine());
    }
    br.close();
    Collections.sort(list, (o1, o2) -> {
      int len = Math.min(o1.length(), o2.length());
      int ret = 0;
      for(int i = 0; i < len; i++){
        if(o1.charAt(i) != o2.charAt(i)){
          ret = x.indexOf(o1.charAt(i)) - x.indexOf(o2.charAt(i));
          break;
        }
      }
      return ret == 0 ? o1.length() - o2.length() : ret;
    });
    PrintWriter pw = new PrintWriter(System.out);
    for(String name : list){
      pw.println(name);
    }
    pw.close();
  }
}
