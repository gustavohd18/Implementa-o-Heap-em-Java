package minHeapComplete;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HeapTest{
 
    @Test
    public void startHeapTest() {
        Heap<Integer> heap = new Heap<Integer>();
        int size = 10;
        heap.starHeap(size);
        assertEquals(10, heap.fullSize());
    }

    @Test
    public void insertOneElementHeapTest() {
        Heap<Integer> heap = new Heap<Integer>();
        int size = 10;
        heap.starHeap(size);
        heap.insert(10);
        assertEquals(1, heap.currentSize());
    }

    @Test
    public void insertMoreElementHeapTest() {
        Heap<Integer> heap = new Heap<Integer>();
        int size = 10;
        heap.starHeap(size);
        heap.insert(10);
        heap.insert(25);
        heap.insert(3);
        assertEquals(3, heap.currentSize());
    }

    @Test
    public void finMinHeapTest() {
        Heap<Integer> heap = new Heap<Integer>();
        int size = 10;
        heap.starHeap(size);
        heap.insert(23);
        assertEquals(23, heap.findMin());
    }

    @Test
    public void extractMinHeapTest() {
        Heap<Integer> heap = new Heap<Integer>();
        int size = 10;
        heap.starHeap(size);
        heap.insert(23);
        heap.insert(25);
        heap.extractMin();
        assertEquals(1, heap.currentSize());
    }

    @Test
    public void deleteHeapTest() {
        Heap<Integer> heap = new Heap<Integer>();
        int size = 10;
        heap.starHeap(size);
        heap.insert(23);
       // heap.insert(25);
        heap.delete(0);
        assertEquals(0, heap.currentSize());
    }

}