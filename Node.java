package CursorList;

import ListElement.ListElement;

public class Node {
    public ListElement data;
    public int next;

    public Node(ListElement data) {
        this.data = new ListElement(data);
    }

    public Node(int i) {
        next = i;
    }

    public Node(Position position) {
        this.next = position.position;
    }
}
