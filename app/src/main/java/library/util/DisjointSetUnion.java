/*
 * ac-library
 * DisjointSetUnion
 * https://github.com/atcoder/ac-library/blob/master/document_ja/dsu.md
 */
package library.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class DisjointSetUnion {

  private final int n;
  private int[] parent_or_size;

  DisjointSetUnion(int n) {
    this.n = n;
    parent_or_size = new int[n];
    Arrays.fill(parent_or_size, -1);
  }

  int merge(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return -1;
    }
    int x = leader(a);
    int y = leader(b);
    if (x == y) {
      return x;
    }
    if (-parent_or_size[x] < -parent_or_size[y]) {
      int temp = x;
      x = y;
      y = temp;
    }
    parent_or_size[x] += parent_or_size[y];
    parent_or_size[y] = x;
    return x;
  }

  boolean isSame(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return false;
    }
    return leader(a) == leader(b);
  }

  int leader(int a) {
    if (parent_or_size[a] < 0) {
      return a;
    } else {
      parent_or_size[a] = leader(parent_or_size[a]);
      return parent_or_size[a];
    }
  }

  int size(int a) {
    if (!(0 <= a && a < n)) {
      return -1;
    }
    return -parent_or_size[leader(a)];
  }

  List<List<Integer>> groups() {
    int[] leader_buf = new int[n];
    int[] group_size = new int[n];
    for (int i = 0; i < n; i++) {
      leader_buf[i] = leader(i);
      group_size[leader_buf[i]]++;
    }
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> list_map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i == leader_buf[i]) {
        list_map.put(i, new ArrayList<>());
      }
    }
    for (int i = 0; i < n; i++) {
      list_map.get(leader_buf[i]).add(i);
    }
    for (Integer key : list_map.keySet()) {
      result.add(list_map.get(key));
    }
    return result;
  }
}
