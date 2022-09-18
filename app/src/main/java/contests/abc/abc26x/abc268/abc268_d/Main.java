/*
 * ユニークビジョンプログラミングコンテスト2022 夏
 * （AtCoder Beginner Contest 268）
 * D - Unique Username
 * https://atcoder.jp/contests/abc268/tasks/abc268_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc268/submissions/34982389
 *
 */

package contests.abc.abc26x.abc268.abc268_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
    }
    final Set<String> ng_word = new HashSet<>();
    for (int i = 0; i < m; i++) {
      ng_word.add(br.readLine());
    }
    br.close();

    final int[] array_p = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = i;
    }
    boolean isOk = false;
    String ans = null;
    Queue<String> queue = new ArrayDeque<>();
    do {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        sb.append(words[array_p[i]]);
        sb.append('_');
      }
      queue.add(sb.deleteCharAt(sb.length() - 1).toString());
      while (!queue.isEmpty()) {
        String uname = queue.poll();
        if (uname.length() >= 3 && !ng_word.contains(uname)) {
          //条件を満たす文字列が存在した
          ans = uname;
          isOk = true;
          break;
        }
        if (uname.length() >= 16) {
          continue;
        }
        for (int i = 1; i < uname.length(); i++) {
          if (uname.charAt(i) == '_' && uname.charAt(i - 1) != '_') {
            queue.add(new StringBuilder(uname).insert(i, '_').toString());
          }
        }
      }
    } while (nextPermutation(array_p) && !isOk);
    System.out.println(isOk ? ans : -1);
  }

  static boolean nextPermutation(int[] array) {
    int idx1 = array.length - 1;
    while (idx1 > 0 && array[idx1 - 1] >= array[idx1]) {
      idx1--;
    }
    if (idx1 <= 0) {
      return false;
    }
    int idx2 = array.length - 1;
    while (array[idx2] <= array[idx1 - 1]) {
      idx2--;
    }

    int temp = array[idx1 - 1];
    array[idx1 - 1] = array[idx2];
    array[idx2] = temp;

    idx2 = array.length - 1;
    while (idx1 < idx2) {
      temp = array[idx1];
      array[idx1] = array[idx2];
      array[idx2] = temp;
      idx1++;
      idx2--;
    }
    return true;
  }
}
