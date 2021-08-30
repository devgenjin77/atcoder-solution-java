/*
 * ABC216
 * D - Pair of Balls
 * https://atcoder.jp/contests/abc216/tasks/abc216_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/25472466
 */
package contests.abc.abc216.abc216_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    int m = Integer.parseInt(head[1]);
    // 筒
    Queue<Integer>[] queues = new Queue[m];
    // 筒の一番上にあるボールの種類と数
    int[] numOfVisibleBall = new int[n];
    // ペアで取り出せるボール
    Queue<Integer> target = new ArrayDeque<>();
    // それぞれのボールが何番目の筒にあるかを保持する配列
    int[][] idxOfTube = new int[n][2];
    for(int[] idx1 : idxOfTube){
      Arrays.fill(idx1, -1);
    }
    for(int i = 0; i < m; i++){
      queues[i] = new ArrayDeque<>();
      int k = Integer.parseInt(br.readLine());
      int[] array = Stream.of(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value) - 1).toArray();
      //筒の一番上にあるボールを管理、2個見える状態なら、取り出せるペアとしてQueueに入れる
      int top = array[0];
      numOfVisibleBall[top] += 1;
      if(numOfVisibleBall[top] == 2){
        target.add(top);
      }
      for(int j = 0; j < k; j++){
        int ball = array[j];
        queues[i].add(ball);
        //ボールが何番目の筒にあるかを管理
        if(idxOfTube[ball][0] == -1){
          idxOfTube[ball][0] = i;
        } else {
          idxOfTube[ball][1] = i;
        }
      }
    }
    br.close();

    int cnt = 0;
    while(!target.isEmpty()){
      int targetBall = target.poll();
      queues[idxOfTube[targetBall][0]].poll();
      queues[idxOfTube[targetBall][1]].poll();
      // 操作回数をプラス１
      cnt++;

      for(int i = 0; i < 2; i++){
        if(queues[idxOfTube[targetBall][i]].peek() != null){
          int ball = queues[idxOfTube[targetBall][i]].peek();
          numOfVisibleBall[ball] += 1;
          if(numOfVisibleBall[ball] == 2){
            target.add(ball);
          }
        }
      }
    }
    System.out.println(cnt == n ? "Yes" : "No");
  }
}