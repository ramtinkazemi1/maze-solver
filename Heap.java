import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * Name: Ramtin Kazemi
 * PID: A16567965
 * Email: rkazemi@ucsd.edu
 * 
 * This file contains the Heap class that has another outer class called Entry,
 * and it implements the PriorityQueue to help with the sorting parts.
 * 
 */




/**
 * This is an outer class that represents the entries for the heap.
 * Note, the key represents the priority.
 * @author ramka
 * @param <K> is the key (priorityQueue)
 * @param <V> is the value
 */
class Entry<K, V> {
    K key; // aka the _priority_
    V value;
    public Entry(K k, V v) { this.key = k; this.value = v; }
    public String toString() {
	return key + ": " + value;
    }
}

/**
 * This class implements PriorityQueue and it uses a list of entries as the entries,
 * and has two instance variables: list of entries and comparator.
 * 
 * @author ramka
 *
 * @param <K>
 * @param <V>
 */
public class Heap<K,V> implements PriorityQueue<K,V>{

    //instance variables
    List<Entry<K, V>> entries;
    Comparator<K> comparator;



    //CONSTRUCTOR
    public Heap(Comparator<K> comparator) {
	this.comparator = comparator;
	entries = new ArrayList<Entry<K,V>>();
    }

    /**
     * Insert a new entry with the given key and value to the end of the heap.
       Then, bubbleUp so that the heap properties are not violated
     */
    public void add(K k, V v) {	
	Entry<K,V> e = new Entry<K,V>(k,v);
	entries.add(e);
	bubbleUp(entries.size()-1);
    }


    /**
     * Remove and return the root element in the heap. Set the last entry 
     * in the heap to the root. Use bubbleDown to fix the heap after the 
     * removal. If the size is zero, throw NoSuchElementException()
     */
    public Entry<K, V> poll(){

	if(entries.size()==0) { 
	    throw new NoSuchElementException();
	}
	//return root element
	Entry<K,V> root = entries.get(0); 
	//get the last element and put it in the root
	entries.set(0,entries.get(entries.size()-1));
	entries.remove(entries.size()-1);
	bubbleDown(0);
	return root;
    }

    /**
     *  Return the root element of the heap.
     *  If the size is zero, throw NoSuchElementException()
     */
    public Entry<K, V> peek(){
	if(entries.size() == 0) {
	    throw new NoSuchElementException();
	}else {
	    return entries.get(0);
	}
    }


    /**
     * return the list of entries.
     */
    public List<Entry<K,V>> toArray(){

	return entries;

    }


    /**
     * If the List of entries is empty, return true. Otherwise, return false.
     */
    public boolean isEmpty() {

	return entries.size()==0;
    }


    /**
     * Return the parent index.
     * @param index
     * @return
     */
    public int parent(int index) {
	return (index-1)/2;
    }


    /**
     * Return the left child index.
     * @param index
     * @return
     */
    public int left(int index) {
	return index*2+1;
    }


    /**
     * Return the right child index.
     * @param index
     * @return
     */
    public int right(int index) {
	return index*2+2;
    }


    /**
     * Takes the index of two entries and swaps them.
     * @param i1
     * @param i2
     */
    public void swap(int i1, int i2) {

	Entry<K,V> temp = entries.get(i1);
	entries.set(i1,entries.get(i2));
	entries.set(i2, temp);

    }


    /**
     * A recursive method that moves the entry at the specified index to a smaller
     * index (up the tree) while maintaining the heap structure. In the case where
     * the element is equal to the parent, you should not swap.
     * @param index
     */
    public void bubbleUp(int index) {
	if(index<=0) {
	    return;
	}
	    int parentIndex = parent(index);
	    K indexVal = entries.get(index).key;
	    K parentVal = entries.get(parentIndex).key;
	    if ( indexVal!=null && parentVal!=null && 
		    comparator.compare(indexVal , parentVal) > 0) {
		swap(index, parentIndex);
		bubbleUp(parentIndex);
	    }
    }


    /**
     * A recursive method that moves the entry at the specified index to a larger
     * index (down the tree) while maintaining the heap structure. Swap with the smaller
     * child. If both chilren are equal and swapping is needed, swap with the left child.
     * In the case where the element is equal to the smaller child, you should not swap.
     * @param index
     */
    public void bubbleDown(int index) {    								
	
	if(index>=entries.size()) {
	    return;
	}

	int leftChildIndex = left(index);
	int largerChildIndex = leftChildIndex;
	int rightChildIndex = right(index);
	if (leftChildIndex >= entries.size() || rightChildIndex >= entries.size()) {
	    return;
	}

	if(existsAndGreater(rightChildIndex, leftChildIndex)) {
	    largerChildIndex = rightChildIndex;
	}
	
 	if (existsAndGreater(largerChildIndex, index) ) {
	    swap(largerChildIndex, index);
	    bubbleDown(largerChildIndex);
	}
 	
    }



    /**
     * Returns true if the entry at index1 is greater than that at index2 (Note: Both
     * entries at the specified indicies must exists for this to be true). Return false
     * otherwise.
     * @param index1
     * @param index2
     * @return
     */
    public boolean existsAndGreater(int index1, int index2) {

	if(entries.get(index1)!=null && entries.get(index2)!=null) {
	    if (comparator.compare(entries.get(index1).key , entries.get(index2).key) > 0) {
		return true;
	    }
	}

	return false;
    }


    /**
     * Returns the number of elements in entries.
     * @return
     */
    public int size() {
	return entries.size();
    }


    /**
     * Returns a string representation of the elements in entries
     * (this method is helpful for debugging)
     */
    public String toString() {
	String str="";
	for(int i=0; i<entries.size();i++) {
	    str +=  " key:"+ entries.get(i).key+ "value:"+entries.get(i).value;
	}
	return str;
    }

}
