/*
 * ABC217
 * E - Sorting Queries
 * https://atcoder.jp/contests/abc217/tasks/abc217_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/25638265
 */
package contests.abc.abc217.abc217_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    PrintWriter pw = new PrintWriter(System.out);
    for(int i = 0; i < q; i++){
      String[] query = br.readLine().split(" ");
      if("1".equals(query[0])){
        int val = Integer.parseInt(query[1]);
        arrayDeque.add(val);
      } else if("2".equals(query[0])){
        if(!priorityQueue.isEmpty()){
          pw.println(priorityQueue.poll());
        } else {
          pw.println(arrayDeque.poll());
        }
      } else if("3".equals(query[0])){
        priorityQueue.addAll(arrayDeque);
        arrayDeque.clear();
      }
    }
    br.close();
    pw.close();
  }
}