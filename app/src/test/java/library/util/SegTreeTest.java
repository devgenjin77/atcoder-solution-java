package library.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SegTreeTest {

  @Test
  void zero() {
    SegTree<Integer> segTree = new SegTree<>(0, Integer::max, -1);
    assertEquals(-1, segTree.allProd());
  }

  @Test
  void one() {
    SegTree<Integer> segTree = new SegTree<>(1, Integer::max, -1);
    assertEquals(-1, segTree.allProd());
    assertEquals(-1, segTree.get(0));
    assertEquals(-1, segTree.prod(0,1));

    segTree.set(0, 1);
    assertEquals(1, segTree.get(0));
    assertEquals(-1, segTree.prod(0,0));
    assertEquals(1, segTree.prod(0, 1));
    assertEquals(-1, segTree.prod(1,1));
  }

  @Test
  void compareNaive() {
    for(int n = 0; n < 30; n++){
      SegTreeNaive<Integer> segNaive = new SegTreeNaive<>(n, Integer::max, -1);
      SegTree<Integer> segTree = new SegTree<>(n, Integer::max, -1);
      for(int i = 0; i < n; i++){
        int num = i + 1;
        segNaive.set(i, num);
        segTree.set(i, num);
      }
      for(int l = 0; l <= n; l++){
        for(int r = l; r <= n; r++){
          assertEquals(segNaive.prod(l, r), segTree.prod(l, r));
        }
      }

      for(int l = 0; l <= n; l++){
        for(int r = l; r <= n; r++){
          int y = segTree.prod(l, r);
          assertEquals(segNaive.maxRight(l, e -> e <= y), segTree.maxRight(l, e -> e <= y));
        }
      }

      for(int r = 0; r <= n; r++){
        for(int l = 0; l <= r; l++){
          int y = segTree.prod(l, r);
          assertEquals(segNaive.minLeft(r, e -> e <= y), segTree.minLeft(r, e -> e <= y));
        }
      }
    }
  }


  @Test
  void testThrowsException() {
    assertThrows(IllegalArgumentException.class, ()-> new SegTree<>(-1, Integer::max, 0));

    SegTree<Integer> segTree = new SegTree<>(10, Integer::max, 0);
    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.get(-1));
    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.get(10));

    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.prod(-1, -1));
    assertThrows(IllegalArgumentException.class, ()-> segTree.prod(3, 2));
    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.prod(0, 11));
    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.prod(-1, 11));

    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.maxRight(11, e ->  e == e));
    assertThrows(ArrayIndexOutOfBoundsException.class, ()-> segTree.minLeft(-1, e ->  e == e));
    assertThrows(IllegalArgumentException.class, ()-> segTree.maxRight(0, e ->  e != e));
  }
  // TODO Test実装
}

class SegTreeNaive<S> {
  int MAX;
  int N;
  java.util.function.BinaryOperator<S> op;
  S e;
  S[] data;

  SegTreeNaive(int n, java.util.function.BinaryOperator<S> op, S e){
    this.MAX = n;
    this.op = op;
    this.e = e;
    this.data = (S[]) new Object[n];
  }

  void set(int p, S x){
    data[p] = x;
  }
  S get(int p) {
    return data[p];
  }
  S prod(int l, int r){
    S sum = e;
    for(int i = l; i < r; i++){
      sum = op.apply(sum, data[i]);
    }
    return sum;
  }
  S allProd(){
    return prod(0, MAX);
  }

  int maxRight(int l, java.util.function.Predicate<S> f) {
    S sum = e;
    if (!f.test(e)) {
      throw new IllegalArgumentException("Identity element must satisfy the condition.");
    }
    for(int i = l; i < MAX; i++){
      sum = op.apply(data[i], sum);
      if(!f.test(sum)){
        return i;
      }
    }
    return MAX;
  }

  int minLeft(int r, java.util.function.Predicate<S> f) {
    S sum = e;
    if (!f.test(e)) {
      throw new IllegalArgumentException("Identity element must satisfy the condition.");
    }
    for(int i = r - 1; i >= 0; i--){
      sum = op.apply(data[i], sum);
      if(!f.test(sum)) {
        return i + 1;
      }
    }
    return 0;
  }
}
