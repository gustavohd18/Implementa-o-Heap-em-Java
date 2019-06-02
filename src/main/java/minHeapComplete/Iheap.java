package minHeapComplete;

public interface Iheap<T> {
    void starHeap(int quantidade);
    //garanto que seja o objeto que implementou a interface
    void insert(T elemento);
    T findMin();
    void delete(int posicao);
    void extractMin();
    void heapifyDown(int posicao);
    void heapifyUp(int posicao);
    int fullSize();

}
