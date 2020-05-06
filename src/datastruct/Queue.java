package datastruct;

public class Queue<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;
    
  public Queue() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  
  public int getSize() {
    return this.size;
  }
  
  public void insert(T elem) {
    Node<T> toAdd = new Node<T>(elem);
    if(this.size == 0) {
      head = tail = toAdd;
    }
    else {
      toAdd.setLink(tail);
      tail = toAdd;
    }
    size += 1;
  }
  
  public T remove() throws Exception {
    if(this.size == 0)  
      throw new Exception("Queue Empty");
    T data = head.getData();
    head = head.getLink();
    size -= 1;
    return data;
  }
  
  public T peek() throws Exception {
    if(this.size == 0)
      throw new Exception("Queue Empty");
    return head.getData();
  }
  
  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<Integer>();
    try {
      System.out.println("Remove: " + queue.remove());
    }
    catch(Exception e) {
      System.out.println(e.toString());
    }
    System.out.println("Size: " + queue.getSize());
  }
}

