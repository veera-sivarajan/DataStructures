package datastruct;

public class ArrayHashTable<K, V> {
  private static int size;
  private V[] array;
  private static int capacity;
  private double loadFactor; 

  @SuppressWarnings("unchecked")
  public ArrayHashTable(int capacity) {
    this.capacity = capacity;
    array = (V[]) new Object[capacity];
    loadFactor = 0.0;
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
    
  public int hashCode(K key) {
    return (int)key % capacity;
  }

  public void updateLoadFactor() {
    loadFactor = size / capacity;
  }

  public double getLoadFactor() {
    return loadFactor;
  }

  public void add(K key, V value) {
    size += 1;
    int index = hashCode(key);
    while(array[index] != null) {
      index += 2;  //Linear Probing Length
    }
    System.out.println("Adding element at: " + index);
    array[index] = value;  
  }
  
  public V find(K key) {
    int index = hashCode(key);
    System.out.println("Finding element at: " + index);
    return array[index];
  }

  public static void main(String[] args) {
    ArrayHashTable<Integer, String> table = new ArrayHashTable<Integer, String>(10);
    System.out.println("Capacity: " + table.getCapacity());
    table.add(1, "Amma");
    table.add(1, "Appa");
    table.add(1, "Poorna");
    System.out.println("Size: " + table.getSize());
    System.out.println("Load Factor: " + table.getLoadFactor());
    System.out.println("Find: " + table.find(1));
  }
}
