package datastruct;

import datastruct.Node;

public class LinkedList<T> {
  private Node<Integer> head;  
  
  public LinkedList() {
    this.head = new Node<Integer>(0, null);
  }
  
  public int size() {
    if(head == null) 
      throw new NullPointerException("Empty List");
    return getSizeHelper(head);
  }
  
  private int getSizeHelper(Node<Integer> currNode) {
    if(currNode == null) 
      return 0;
    return 1 + getSizeHelper(currNode.getLink()); 
  }
  
  public void addToTail(Node<Integer> link) {
    System.out.println("Entering addToTail");
    if(head.getLink() == null) { 
      head = link;
      System.out.println("Adding to Head");
    }
    else {
      System.out.println("Adding to tail using while loop");
      Node<Integer> tail = head;
      while(tail.getLink() != null)
	tail = tail.getLink();
      tail.setLink(link);
    } 
  }

  public void addToHead(Node<Integer> link) {
    link.setLink(head);
    this.head = link;
  }
  
  public void printList() {
    Node<Integer> tail = head;
    while(tail != null) {
      System.out.println("Data: " + tail.getData());  
      tail = tail.getLink();
    }
  }
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    Node<Integer> ele1 = new Node<Integer>(4, null);
    Node<Integer> ele2 = new Node<Integer>(5, null);
    list.addToTail(ele1);
    list.addToHead(ele2);
    list.printList();
    System.out.println("Size: " + list.size()); 
  }  
}
