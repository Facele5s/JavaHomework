package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MultiThreadedDFS extends RecursiveTask<Node> {
    private final Node currentNode;
    private final int target;

    public MultiThreadedDFS(Node currentNode, int target) {
        this.currentNode = currentNode;
        this.target = target;
    }

    @Override
    protected Node compute() {
        if (currentNode.getValue() == target) {
            return currentNode;
        }

        List<MultiThreadedDFS> children = new ArrayList<>();

        if (currentNode.getLeft() != null) {
            MultiThreadedDFS child = new MultiThreadedDFS(currentNode.getLeft(), target);
            child.fork();
            children.add(child);
        }

        if (currentNode.getRight() != null) {
            MultiThreadedDFS child = new MultiThreadedDFS(currentNode.getRight(), target);
            child.fork();
            children.add(child);
        }

        for (MultiThreadedDFS child: children) {
            Node targetNode = child.join();
            if (targetNode != null) {
                return targetNode;
            }
        }

        return null;
    }
}
