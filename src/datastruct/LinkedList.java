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
    if(head == null)
      throw new IndexOutOfBoundsException("Delete Element When List Empty");
    Node<Integer> temp = head;
    removeHelper(num);
    head = temp;
  } 
  private void removeHelper(Integer num) {
    //System.out.println(System.identityHashCode(tail));
    while(this.head != null) {
      if(head.getData() == num) {
        head = head.getLink();
        System.out.println("Head data inside remove: " + head.getData());
        return;
      }
      head = head.getLink();
    }
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
    Node<Integer> ele1 = new Node<Integer>(1, null);
    Node<Integer> ele2 = new Node<Integer>(2, null);
    Node<Integer> ele3 = new Node<Integer>(3, null);
    Node<Integer> ele4 = new Node<Integer>(4, null);
    Node<Integer> ele5 = new Node<Integer>(5, null);
    Node<Integer> ele6 = new Node<Integer>(6, null);
    list.addToTail(ele1);
    list.addToTail(ele2);
    list.addToTail(ele3);
    list.addToTail(ele4);
    list.addToTail(ele5);
    list.addToTail(ele6);
    System.out.println("Before remove:");
    list.printList();
    list.remove(3);
    System.out.println("After remove 6");
    list.printList();
  }  
}
