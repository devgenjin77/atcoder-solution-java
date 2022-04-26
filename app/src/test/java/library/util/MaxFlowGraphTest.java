package library.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class MaxFlowGraphTest {

  @Test
  void zero() {
    MaxFlowGraph graph = new MaxFlowGraph(0);
  }

  @Test
  void assign() {
    MaxFlowGraph graph = new MaxFlowGraph(10);
  }

  void assertEdgeEquals(MaxFlowGraphEdge expect, MaxFlowGraphEdge actual) {
    assertEquals(expect.from, actual.from);
    assertEquals(expect.to, actual.to);
    assertEquals(expect.cap, actual.cap);
    assertEquals(expect.flow, actual.flow);
  }

  @Test
  void simple() {
    MaxFlowGraph graph = new MaxFlowGraph(4);
    assertEquals(0, graph.addEdge(0, 1, 1));
    assertEquals(1, graph.addEdge(0, 2, 1));
    assertEquals(2, graph.addEdge(1, 3, 1));
    assertEquals(3, graph.addEdge(2, 3, 1));
    assertEquals(4, graph.addEdge(1, 2, 1));
    assertEquals(2, graph.flowMax(0, 3));

    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 1, 1), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 2, 1, 1), graph.getEdge(1));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 3, 1, 1), graph.getEdge(2));
    assertEdgeEquals(new MaxFlowGraphEdge(2, 3, 1, 1), graph.getEdge(3));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 2, 1, 0), graph.getEdge(4));

    boolean[] ret = graph.minCut(0);
    assertTrue(ret[0]);
    assertFalse(ret[1]);
    assertFalse(ret[2]);
    assertFalse(ret[3]);
  }

  @Test
  void notSimple() {
    MaxFlowGraph graph = new MaxFlowGraph(2);
    assertEquals(0, graph.addEdge(0, 1, 1));
    assertEquals(1, graph.addEdge(0, 1, 2));
    assertEquals(2, graph.addEdge(0, 1, 3));
    assertEquals(3, graph.addEdge(0, 1, 4));
    assertEquals(4, graph.addEdge(0, 1, 5));
    assertEquals(5, graph.addEdge(0, 0, 6));
    assertEquals(6, graph.addEdge(1, 1, 7));
    assertEquals(15, graph.flowMax(0, 1));

    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 1, 1), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 2, 2), graph.getEdge(1));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 3, 3), graph.getEdge(2));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 4, 4), graph.getEdge(3));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 5, 5), graph.getEdge(4));

    boolean[] ret = graph.minCut(0);
    assertTrue(ret[0]);
    assertFalse(ret[1]);
  }

  @Test
  void cut() {
    MaxFlowGraph graph = new MaxFlowGraph(3);
    assertEquals(0, graph.addEdge(0, 1, 2));
    assertEquals(1, graph.addEdge(1, 2, 1));
    assertEquals(1, graph.flowMax(0, 2));

    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 2, 1), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 2, 1, 1), graph.getEdge(1));

    boolean[] ret = graph.minCut(0);
    assertTrue(ret[0]);
    assertTrue(ret[1]);
    assertFalse(ret[2]);
  }

  @Test
  void twice() {
    MaxFlowGraph graph = new MaxFlowGraph(3);
    assertEquals(0, graph.addEdge(0, 1, 1));
    assertEquals(1, graph.addEdge(0, 2, 1));
    assertEquals(2, graph.addEdge(1, 2, 1));

    assertEquals(2, graph.flowMax(0, 2));

    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 1, 1), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 2, 1, 1), graph.getEdge(1));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 2, 1, 1), graph.getEdge(2));

    graph.changeEdge(0, 100, 10);
    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 100, 10), graph.getEdge(0));

    assertEquals(0, graph.flowMax(0, 2));
    assertEquals(90, graph.flowMax(0, 1));

    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 100, 100), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 2, 1, 1), graph.getEdge(1));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 2, 1, 1), graph.getEdge(2));

    assertEquals(2, graph.flowMax(2, 0));

    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, 100, 99), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 2, 1, 0), graph.getEdge(1));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 2, 1, 0), graph.getEdge(2));
  }

  @Test
  void bound() {
    MaxFlowGraph graph = new MaxFlowGraph(3);
    assertEquals(0, graph.addEdge(0, 1, Long.MAX_VALUE));
    assertEquals(1, graph.addEdge(1, 0, Long.MAX_VALUE));
    assertEquals(2, graph.addEdge(0, 2, Long.MAX_VALUE));

    assertEquals(Long.MAX_VALUE, graph.flowMax(0, 2));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 1, Long.MAX_VALUE, 0), graph.getEdge(0));
    assertEdgeEquals(new MaxFlowGraphEdge(1, 0, Long.MAX_VALUE, 0), graph.getEdge(1));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 2, Long.MAX_VALUE, Long.MAX_VALUE), graph.getEdge(2));
  }

  @Test
  void selfLoop() {
    MaxFlowGraph graph = new MaxFlowGraph(3);
    assertEquals(0, graph.addEdge(0, 0, 100));
    assertEdgeEquals(new MaxFlowGraphEdge(0, 0, 100, 0), graph.getEdge(0));
  }

  @Test
  void invalid() {
    MaxFlowGraph graph = new MaxFlowGraph(2);
    assertThrows(IllegalArgumentException.class, () -> graph.flowMax(0, 0));
    assertThrows(IllegalArgumentException.class, () -> graph.flow(0, 0, 0));
  }

  @Test
  void stress() {
    Random r = new Random();
    for (int phase = 0; phase < 10000; phase++) {
      int n = r.nextInt(20) + 2;
      int m = r.nextInt(100) + 1;
      int s = r.nextInt(n);
      int t = r.nextInt(n);
      while(s == t) {
        t = r.nextInt(n);
      }

      MaxFlowGraph graph = new MaxFlowGraph(n);
      for(int i = 0; i < m; i++) {
        int u = r.nextInt(n);
        int v = r.nextInt(n);
        int c = r.nextInt(10000);
        graph.addEdge(u, v, c);
      }

      long flow = graph.flowMax(s, t);
      long dual = 0;
      boolean[] ret = graph.minCut(s);
      long[] v_flow = new long[n];
      for(MaxFlowGraphEdge e : graph.edges()) {
        v_flow[e.from] -= e.flow;
        v_flow[e.to] += e.flow;
        if(ret[e.from] && !ret[e.to]) {
          dual += e.cap;
        }
      }
      assertEquals(flow, dual);
      assertEquals(-flow, v_flow[s]);
      assertEquals(flow, v_flow[t]);
      for(int i = 0; i < n; i++) {
        if(i == s || i == t) {
          continue;
        }
        assertEquals(0, v_flow[i]);
      }
    }
  }
}