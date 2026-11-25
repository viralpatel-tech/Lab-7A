import java.util.List;

class Main {
  public static void main(String[] args) {

    // 1. Define the vertices (buildings)
    String[] vertices = {
            "Liberal Arts",
            "Student Services",
            "Health Careers & Sciences",
            "Health Technologies Center",
            "Recreation Center",
            "Technology Learning Center",
            "Business & Technology",
            "Theatre"
    };

    // 2. Define edges based on the campus map
    int[][] edges = {
            {0, 1}, {1, 0},
            {0, 7}, {7, 0},
            {1, 2}, {2, 1},
            {1, 4}, {4, 1},
            {1, 5}, {5, 1},
            {1, 6}, {6, 1},
            {1, 7}, {7, 1},
            {2, 3}, {3, 2},
            {2, 4}, {4, 2},
            {3, 4}, {4, 3},
            {6, 7}, {7, 6}
    };

    // 3. Create the graph using vertices and edges
    UnweightedGraph<String> graph =
            new UnweightedGraph<>(vertices, edges);

    // 4. Perform DFS starting from Business & Technology
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);

    // 5. Retrieve and print the DFS search order
    List<Integer> searchOrder = dfs.getSearchOrder();

    System.out.println("DFS Search Order:");

    for (int i : searchOrder) {
      System.out.println(i + ": " + graph.getVertex(i));
    }

    // 6. Print parent-child relationships
    System.out.println("\nParent-Child Relationships:");

    for (int i = 0; i < vertices.length; i++) {
      if (dfs.getParent(i) != -1) {
        System.out.println(
                graph.getVertex(dfs.getParent(i))
                        + " -> " + graph.getVertex(i));
      }
    }

    // 7. Print paths from Business & Technology
    System.out.println("\nPaths from Business & Technology:");

    // Path to Health Technologies Center
    dfs.printPath(3);
    System.out.println();

    // Path to Student Services
    dfs.printPath(1);
    System.out.println();

    // Path to Recreation Center
    dfs.printPath(4);
    System.out.println();

    // 8. Print the entire DFS tree
    System.out.println("\nDFS Tree:");
    dfs.printTree();
  }
}