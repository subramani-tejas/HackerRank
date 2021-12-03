package LinkedList;
/*
* https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=linked-lists
* */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DetectACycle {
    static class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Node current = head;
        Set<Node> setofNodes = new HashSet<>();

        while (current != null) {
            if (setofNodes.contains(current)) return true;
            setofNodes.add(current);
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
