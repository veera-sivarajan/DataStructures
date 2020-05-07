package datastruct;

public class ArrayHashTable<K, V> {
  private K key;
  private V value;
  private int size;
  private int[] array;
  
  public ArrayHashTable(int size) {
    this.size = size;
    this.array = new int[size];
  }
  
  public int getSize() {
    return size;
  }
}
