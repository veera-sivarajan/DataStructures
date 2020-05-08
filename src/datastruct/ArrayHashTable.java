package datastruct;

public class ArrayHashTable<V> {
  private static int size;
  private V[] array;
  private static int capacity;
  
  public ArrayHashTable(int capacity) {
    this.capacity = capacity;
    array = (V[]) new Object[capacity];
  }
  
  public static int getSize() {
    return size;
  }
  
  public static int getCapacity() {
    return capacity;
  }

  public static boolean isEmpty() {
    return size == 0;
  }
    
  public int hashCode(int key) {
    return key % capacity;
  }

  public void add(int key, V value) {
    size += 1;
    int index = hashCode(key);
    while(array[index] != null) {
      index += 1;
    }
    System.out.println("Adding element at: " + index);
    array[index] = value;  
  }
  
  public V find(int key, V value) {
    int index = hashCode(key);
    System.out.println("Finding element at: " + index);
    return array[index];
  }

  public static void main(String[] args) {
    ArrayHashTable table = new ArrayHashTable(10);
    System.out.println("Capacity: " + table.getCapacity());
    table.add(1, "Amma");
    table.add(1, "Appa");
    table.add(1, "Poorna");
    System.out.println("Size: " + table.getSize());
    System.out.println("Find: " + table.find(1, "Amma"));
  }
}
