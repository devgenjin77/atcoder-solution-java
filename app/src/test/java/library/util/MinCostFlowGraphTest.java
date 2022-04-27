package library.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class MinCostFlowGraphTest {

  @Test
  void zero() {
    MinCostFlowGraph graph = new MinCostFlowGraph(0);
  }

  @Test
  void assign() {
    MinCostFlowGraph graph = new MinCostFlowGraph(10);
  }

  void assertEdgeEquals(MinCostFlowGraphEdge expect, MinCostFlowGraphEdge actual) {
    assertEquals(expect.from, actual.from);
    assertEquals(expect.to, actual.to);
    assertEquals(expect.cap, actual.cap);
    assertEquals(expect.flow, actual.flow);
    assertEquals(expect.cost, actual.cost);
  }

  @Test
  void simple() {
    MinCostFlowGraph graph = new MinCostFlowGraph(4);
    graph.addEdge(0, 1, 1, 1);
    graph.addEdge(0, 2, 1, 1);
    graph.addEdge(1, 3, 1, 1);
    graph.addEdge(2, 3, 1, 1);
    graph.addEdge(1, 2, 1, 1);

    List<MinCostFlowResult> res = graph.slope(0, 3, 10);
    assertEquals(2, res.size());
    assertEquals(0, res.get(0).flow);
    assertEquals(0, res.get(0).cost);
    assertEquals(2, res.get(1).flow);
    assertEquals(4, res.get(1).cost);

    assertEdgeEquals(new MinCostFlowGraphEdge(0, 1, 1, 1, 1), graph.getEdge(0));
    assertEdgeEquals(new MinCostFlowGraphEdge(0, 2, 1, 1, 1), graph.getEdge(1));
    assertEdgeEquals(new MinCostFlowGraphEdge(1, 3, 1, 1, 1), graph.getEdge(2));
    assertEdgeEquals(new MinCostFlowGraphEdge(2, 3, 1, 1, 1), graph.getEdge(3));
    assertEdgeEquals(new MinCostFlowGraphEdge(1, 2, 1, 0, 1), graph.getEdge(4));
  }

  @Test
  void usage() {
    {
      MinCostFlowGraph graph = new MinCostFlowGraph(2);
      graph.addEdge(0, 1, 1, 2);
      MinCostFlowResult result = graph.flowMax(0, 1);
      assertEquals(1, result.flow);
      assertEquals(2, result.cost);
    }
    {
      MinCostFlowGraph graph = new MinCostFlowGraph(2);
      graph.addEdge(0, 1, 1, 2);
      List<MinCostFlowResult> result = graph.slopeMax(0, 1);
      assertEquals(0, result.get(0).flow);
      assertEquals(0, result.get(0).cost);
      assertEquals(1, result.get(1).flow);
      assertEquals(2, result.get(1).cost);
    }
  }

  @Test
  void outOfRange() {
    MinCostFlowGraph graph = new MinCostFlowGraph(10);
    assertThrows(IndexOutOfBoundsException.class, () -> graph.slopeMax(-1, 3));
    assertThrows(IllegalArgumentException.class, () -> graph.slopeMax(3, 3));
  }

  @Test
  void selfLoop() {
    MinCostFlowGraph graph = new MinCostFlowGraph(3);
    assertEquals(0, graph.addEdge(0, 0, 100, 123));
    assertEdgeEquals(new MinCostFlowGraphEdge(0, 0, 100, 0, 123), graph.getEdge(0));
  }

  @Test
  void sameCostPaths() {
    MinCostFlowGraph graph = new MinCostFlowGraph(3);
    assertEquals(0, graph.addEdge(0, 1, 1, 1));
    assertEquals(1, graph.addEdge(1, 2, 1, 0));
    assertEquals(2, graph.addEdge(0, 2, 2, 1));
    List<MinCostFlowResult> results = graph.slopeMax(0, 2);
    assertEquals(2, results.size());
    assertEquals(0, results.get(0).flow);
    assertEquals(0, results.get(0).cost);
    assertEquals(3, results.get(1).flow);
    assertEquals(3, results.get(1).cost);
  }

  @Test
  void invalid() {
    MinCostFlowGraph graph = new MinCostFlowGraph(2);
    assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 0, -1, 0));
    assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 0, 0, -1));
  }
}