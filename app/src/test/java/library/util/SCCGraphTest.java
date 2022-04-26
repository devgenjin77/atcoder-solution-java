package library.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SCCGraphTest {

  @Test
  void empty() {
    SCCGraph sccGraph0 = new SCCGraph(0);
    assertEquals(0, sccGraph0.scc().size());
  }

  @Test
  void assign() {
    SCCGraph sccGraph = new SCCGraph(10);
    assertEquals(10, sccGraph.scc().size());
  }

  @Test
  void simple() {
    SCCGraph sccGraph = new SCCGraph(2);
    sccGraph.addEdge(0, 1);
    sccGraph.addEdge(1, 0);
    assertEquals(1, sccGraph.scc().size());
  }

  @Test
  void selfLoop() {
    SCCGraph sccGraph = new SCCGraph(2);
    sccGraph.addEdge(0, 0);
    sccGraph.addEdge(1, 1);
    sccGraph.addEdge(1, 1);
    assertEquals(2, sccGraph.scc().size());
  }

  @Test
  void invalid() {
    SCCGraph sccGraph = new SCCGraph(2);
    assertThrows(IndexOutOfBoundsException.class, () -> sccGraph.addEdge(0, 10));
  }
}
