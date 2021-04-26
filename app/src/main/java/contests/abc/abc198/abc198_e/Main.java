/*
 * ABC198
 * E - Unique Color
 * https://atcoder.jp/contests/abc198/tasks/abc198_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc198/submissions/21841395
 */
package contests.abc.abc198.abc198_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  static boolean[] isVisited;
  static int[] colors;
  static int[] color_count = new int[100001];
  static ArrayList<Integer>[] edges;
  static ArrayList<Integer> answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    colors = new int[n];
    for (int i = 0; i < n; i++) {
      colors[i] = Integer.parseInt(st.nextToken());
    }
    edges = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      edges[i] = new ArrayList();
    }
    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st_edge = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st_edge.nextToken()) - 1;
      int to = Integer.parseInt(st_edge.nextToken()) - 1;
      edges[from].add(to);
      edges[to].add(from);
    }
    br.close();

    isVisited = new boolean[n];
    Arrays.fill(isVisited, false);
    answer = new ArrayList<>();
    dfs(0);
    Collections.sort(answer);
    PrintWriter pw = new PrintWriter(System.out);
    for (int node : answer) {
      pw.println(node + 1);
    }
    pw.close();
  }

  static void dfs(int node) {
    isVisited[node] = true;
    if (color_count[colors[node]] == 0) {
      answer.add(node);
    }
    color_count[colors[node]] += 1;
    for (int next : edges[node]) {
      if (!isVisited[next]) {
        dfs(next);
      }
    }
    color_count[colors[node]] -= 1;
  }
}
