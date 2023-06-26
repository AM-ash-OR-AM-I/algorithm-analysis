package graph;

/**
 * --ABOUT--
 * Prim’s algorithm grows a single tree T, one edge at a time, until it becomes
 * a spanning tree.
 * We initialize T with zero edges and U with a single node. Where T is spanning
 * tree edges set and U is spanning tree vertex set.
 * At each step, Prim’s algorithm adds the smallest value edge with one endpoint
 * in
 * U and other not in us. Since each edge adds one new vertex to U, after n − 1
 * additions, U contains all the vertices of the spanning tree and T becomes a
 * spanning tree.
 * 
 * Input: A weighted connected graph G = (V, E)
 * Output: Set of edges comprising a MST
 * 
 * Algorithm Prim(G)
 * T = {}
 * Let r be any vertex in G
 * U = {r}
 * for i = 1 to |V| - 1 do
 * e = minimum-weight edge (u, v)
 * With u in U and v in V-U
 * U = U + {v}
 * T = T + {e}
 * return T
 */

// A Java program for Prim's Minimum Spanning Tree (MST)
// algorithm. The program is for adjacency matrix
// representation of the graph
class MST {

  // Number of vertices in the graph
  private static final int V = 5;

  int minKey(int key[], Boolean mstSet[]) {
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < V; v++)
      if (mstSet[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
      }

    return min_index;
  }

  void printMST(int parent[], int graph[][]) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < V; i++)
      System.out.println(parent[i] + " - " + i + "\t"
          + graph[i][parent[i]]);
  }

  void primMST(int graph[][]) {
    int parent[] = new int[V];

    int key[] = new int[V];

    Boolean mstSet[] = new Boolean[V];
    for (int i = 0; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    }

    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < V - 1; count++) {
      int u = minKey(key, mstSet);
      mstSet[u] = true;
      for (int v = 0; v < V; v++)
        if (graph[u][v] != 0 && mstSet[v] == false
            && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }
    }

    // Print the constructed MST
    printMST(parent, graph);
  }

  public static void main(String[] args) {
    MST t = new MST();
    int graph[][] = new int[][] {
        { 0, 2, 0, 6, 0 },
        { 2, 0, 3, 8, 5 },
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 },
    };

    // Print the solution
    t.primMST(graph);
  }
}

// This code is contributed by Aakash Hasija
