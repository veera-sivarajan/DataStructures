package datastruct;

import datastruct.Node;

public class LinkedList<T> {
  private Node<Integer> head;  
  
  public LinkedList() {
    this.head = null;
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
    if(head == null) { 
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
  
  public Integer countDuplicate(Integer num) {
    Node<Integer> tail = head;
    return countDuplicateHelper(tail, 0,  num);
  }
  
  private Integer countDuplicateHelper(Node<Integer> tail, Integer count , Integer num) {
    if(tail == null)
      return count;
    if(tail.getData() == num)
      return countDuplicateHelper(tail.getLink(), count + 1, num);
    else
      return countDuplicateHelper(tail.getLink(), count, num); 
  } 

  public int getIndexOf(Integer num) {
    Node<Integer> tail = head;
    return getIndexOfHelper(tail, num, 0);
  }
  
  private int getIndexOfHelper(Node<Integer> tail, Integer num, int index) {
    if(tail.getData() == num)
      return index;
    return getIndexOfHelper(tail.getLink(), num, index + 1);
  } 
  
  public void remove(Integer num) {
    Node<Integer> tail = head;
    removeHelper(tail, num);  
  }
  
  private void removeHelper(Node<Integer> tail, Integer num) {
    if(tail.getData() == num) {
      head = tail.getLink(); 
      return;
    }
    if(tail.getLink().getData() == num) {
      tail.setLink(tail.getLink());
      return;
    }
    removeHelper(tail.getLink(), num);
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
    Node<Integer> ele3 = new Node<Integer>(4, null);
    Node<Integer> ele4 = new Node<Integer>(4, null);
    Node<Integer> ele5 = new Node<Integer>(4, null);
    list.addToTail(ele1);
    list.addToTail(ele2);
    list.addToTail(ele3);
    list.addToTail(ele4);
    list.addToTail(ele5);
    System.out.println("Before remove:");
    list.printList();
    System.out.println("Size: " + list.size()); 
    System.out.println("Duplicates: " + list.countDuplicate(5));
    System.out.println("Index of 5: " + list.getIndexOf(4));
    list.remove(4);
    System.out.println("After remove 5");
    list.printList();
  }  
}
