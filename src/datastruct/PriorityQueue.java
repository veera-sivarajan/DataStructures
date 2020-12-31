package datastruct;

public class PriorityQueue<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public PriorityQueue() {
    head = null;
    tail = null;
    size = 0;
  }

  public void insert(T data) {
    Node<T> newNode = new Node<T>(data);
    if(head == null && tail == null) {
      head = tail = newNode;
    }
    else {
      tail.setLink(newNode);
      tail = newNode;
    }
    size += 1;
  }

  public int getSize() {
    return size;
  }

  private T getHighest() {
    return getHighestHelper(head.getData(), head);
  }

  private T getHighestHelper(T data, Node<T> node) {
    if(node.getData() > data) {
      return getHighestHelper(node.getData(), node.getLink());
    }
    return getHighestHelper(data, node.getLink());
  }
