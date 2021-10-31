/*
 * ABC225
 * D - Play Train
 * https://atcoder.jp/contests/abc225/tasks/abc225_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/26947365
 */
package contests.abc.abc225.abc225_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nq = br.readLine().split(" ");
    int n = Integer.parseInt(nq[0]);
    int q = Integer.parseInt(nq[1]);
    int[] prev_train = new int[n + 1];
    int[] next_train = new int[n + 1];
    Arrays.fill(prev_train, 0);
    Arrays.fill(next_train, 0);

    PrintWriter pw = new PrintWriter(System.out);
    for(int cnt = 0; cnt < q; cnt++){
      String[] query = br.readLine().split(" ");
      int type = Integer.parseInt(query[0]);
      int x = Integer.parseInt(query[1]);
      if(type == 1){
        //xとyを連結
        int y = Integer.parseInt(query[2]);
        next_train[x] = y;
        prev_train[y] = x;
      } else if(type == 2){
        //xとyを連結
        int y = Integer.parseInt(query[2]);
        next_train[x] = 0;
        prev_train[y] = 0;
      } else if(type == 3){
        ArrayList<String> list = new ArrayList<>();
        int top_train = x;
        while(prev_train[top_train] > 0){
          top_train = prev_train[top_train];
        }
        do {
          list.add(String.valueOf(top_train));
          top_train = next_train[top_train];
        } while (top_train > 0);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size());
        for(String train : list){
          sb.append(" ");
          sb.append(train);
        }
        pw.println(sb.toString());
      }
    }
    pw.close();
    br.close();
  }
}
