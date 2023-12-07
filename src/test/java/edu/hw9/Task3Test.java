package edu.hw9;

import edu.hw9.Task3.MultiThreadedDFS;
import edu.hw9.Task3.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ForkJoinPool;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task3Test {
    private static final Node root;
    private static final Node node1;
    private static final Node node2;
    private static final Node node3;
    private static final Node node4;
    private static final Node node5;

    static {
        root = new Node(1);
        node1 = new Node(4);
        node2 = new Node(9);
        node3 = new Node(7);
        node4 = new Node(3);
        node5 = new Node(2);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);

        node2.setLeft(node4);
        node2.setRight(node5);
    }

    @Test
    @DisplayName("Многопоточный поиск в глубину")
    public void multithreadedDFSTest() {
        MultiThreadedDFS dfs = new MultiThreadedDFS(root, 3);
        ForkJoinPool pool = new ForkJoinPool();
        Node node = pool.invoke(dfs);
        assertEquals(node, node4);

        dfs = new MultiThreadedDFS(node1, 4);
        pool = new ForkJoinPool();
        node = pool.invoke(dfs);
        assertEquals(node, node1);

        dfs = new MultiThreadedDFS(root, -1);
        pool = new ForkJoinPool();
        node = pool.invoke(dfs);
        assertNull(node);
    }
}
