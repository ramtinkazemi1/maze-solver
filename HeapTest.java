// import static org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;


public class HeapTest {


    public class MaxComparator implements Comparator<String>{

	@Override
	public int compare(String a, String b) {
	    return a.compareTo(b);
	}
    }
    
    public class MinComparator implements Comparator<String>{

	@Override
	public int compare(String a, String b) {
	    return b.compareTo(a);
	}
    }

    MaxComparator maxComparator = new MaxComparator();
    MinComparator minComparator = new MinComparator();


    @Test //my test
    public void myOwnTest() {
	String[] input = {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
	int[] cost = {0,1,2,3,4};
	Heap heap = new Heap<Integer, Square>(new IntComparator());
	for(int i =0 ; i<cost.length;i++) {
	    heap.add(cost[i], input[i]);
	}
	assertEquals(5,heap.toArray().size());
    }
    
    @Test//1
    public void testHeapFunctionality_toArray() {
	String[] string= {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
	int[] weight = {0,1,2,3,4};
	Heap<String, Integer> heap = new Heap<String, Integer>(maxComparator);
	heap.add(string[0],weight[0]);
	heap.add(string[1],weight[1]);
	heap.add(string[2],weight[2]);
	heap.add(string[3],weight[3]);
	heap.add(string[4],weight[4]);
	assertEquals(5, heap.toArray().size());
	System.out.println(heap.toString());
    }

    @Test//2
    public void testHeapFunctionality_addMin() {
	String[] string= {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
	int[] weight = {20, 10, 30, 5, 1, 22};
	Heap<String, Integer> heap = new Heap<String, Integer>(maxComparator);
	heap.add(string[0],weight[0]);
	heap.add(string[1],weight[1]);
	heap.add(string[2],weight[2]);
	heap.add(string[3],weight[3]);
	heap.add(string[4],weight[4]);
	heap.add(string[5],weight[5]);
	assertEquals(6, heap.toArray().size());
	System.out.println(heap.toString());
	///for(int i = 0; i < heap.size(); i++) {
	while(!heap.isEmpty()) {
	    System.out.println(heap.poll());
	}
    }

    @Test//3
    public void testHeapFunctionality_addMax() {
	String[] string= {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
	int[] weight = {20, 10, 30, 5, 1, 22};
	Heap<String, Integer> heap = new Heap<String, Integer>(maxComparator);
	heap.add(string[0],weight[0]);
	heap.add(string[1],weight[1]);
	heap.add(string[2],weight[2]);
	heap.add(string[3],weight[3]);
	heap.add(string[4],weight[4]);
	heap.add(string[5],weight[5]);
	assertEquals(6, heap.toArray().size());
    }

    @Test//4
    public void testHeapFunctionality_peek() {
	String[] string= {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
	int[] weight = {0,1,2,3,4};
	Heap<String, Integer> heap = new Heap<String, Integer>(minComparator);
	heap.add(string[0],weight[0]);
	heap.add(string[1],weight[1]);
	heap.add(string[2],weight[2]);
	heap.add(string[3],weight[3]);
	heap.add(string[4],weight[4]);
	Arrays.sort(string);
	assertEquals(heap.peek().key,string[0]);
	assertEquals(heap.peek().value, (Integer)weight[0]);
	
    }

    @Test//5
    public void testHeapFunctionality_removeMin() {
	String[] string= {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
	int[] weight = {20, 10, 30, 5, 1, 22};
	Heap<String, Integer> heap = new Heap<String, Integer>(minComparator);
	//Removing all elements from the heap via heap.poll() should remove them in ascending sorted order.
	heap.add(string[0],weight[0]);
	heap.add(string[1],weight[1]);
	heap.add(string[2],weight[2]);
	heap.add(string[3],weight[3]);
	heap.add(string[4],weight[4]);
	heap.add(string[5],weight[5]);
	Arrays.sort(string);
	for(int i =0;i<string.length;i++) {
	    Entry<String,Integer> e = heap.poll();
	    assertEquals(string[i],e.key);
	}
    }

    @Test//6
    public void testHeapFunctionality_removeMax() {
	String[] string= {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
	int[] weight = {20, 10, 30, 5, 1, 22};
	Heap<String, Integer> heap = new Heap<String, Integer>(maxComparator);
	//Removing all elements from the heap via heap.poll() should remove them in descending sorted order.
	heap.add(string[0],weight[0]);
	heap.add(string[1],weight[1]);
	heap.add(string[2],weight[2]);
	heap.add(string[3],weight[3]);
	heap.add(string[4],weight[4]);
	heap.add(string[5],weight[5]);
	Arrays.sort(string, Collections.reverseOrder()); //used collections to just test my code
	for(int i =0;i<string.length;i++) {
	    Entry<String,Integer> e = heap.poll();
	    assertEquals(string[i],e.key);
	}
    }

    
}
