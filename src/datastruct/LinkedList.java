package datastruct;

import datastruct.Node;

public class LinkedList<T> {
  private Node<T> head;  
  
  public LinkedList() {
    this.head = null;
  }
  
  public int getSize() {
    if(head == null) 
      throw new NullPointerException("Empty List");
    return getSizeHelper(head);
  }
  
  private int getSizeHelper(Node<T> currNode) {
    
    while(currNode != null) {
      return 1 + currNode.getLink();
    } 
}
