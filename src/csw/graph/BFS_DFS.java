package graph;

class BFS_DFS extends Graph {

  BFS_DFS(int vertices) {
    super(vertices);
  }

  // BFS Traversal
  void BFS(int rootNode) {
    boolean visited[] = new boolean[vertices];
    visited[rootNode] = true;
    queue.add(rootNode);

    while (!queue.isEmpty()) {
      rootNode = queue.poll();
      System.out.print(rootNode + " ");
      for (Edge edge : adjList[rootNode]) {
        int node = edge.dest;
        if (visited[node]) {
          continue;
        }
        visited[node] = true;
        queue.add(node);
      }
    }
  }

  // DFS Traversal
  void DFS(int rootNode) {
    boolean visited[] = new boolean[vertices];
    visited[rootNode] = true;
    stack.add(rootNode);

    while (stack.size() != 0) {
      rootNode = stack.pop();
      System.out.print(rootNode + " ");
      for (Edge edge : adjList[rootNode]) {
        int node = edge.dest;
        if (visited[node]) {
          continue;
        }
        visited[node] = true;
        stack.add(node);
      }
    }
  }
}

class Main {
  public static void main(String[] args) {
    BFS_DFS graph = new BFS_DFS(11);
    graph.addEdge(0, 1);
    graph.addEdge(0, 7);
    graph.addEdge(0, 10);
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(2, 5);
    graph.addEdge(5, 6);
    graph.addEdge(7, 8);
    graph.addEdge(7, 9);

    System.out.println("BFS Traversal of the graph:");
    graph.BFS(0);
    System.out.println("\nDFS Traversal of the graph:");
    graph.DFS(0);
  }
}
