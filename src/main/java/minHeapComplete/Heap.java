package minHeapComplete;

public class Heap<T extends Comparable<T>> implements Iheap {
    private T[] estrutura;
    private int size;

    @Override
    public void starHeap(int quantidade) {
        this.estrutura = (T[]) new Comparable[quantidade];
        //(T[]) new Object[quantidade];
    }

    @Override
    public void insert(Object elemento) {
        //porque preciso passar o heap como parametro
        if (isEmpty()) {
            this.estrutura[0] = (T) elemento;
            size++;
        } else {
            if(size == this.estrutura.length){
                //talvez precise gerar um erro aqui
                return;
            } else {
            int idx = size;
            this.estrutura[idx] = (T)elemento;
            heapifyUp(idx);
            size++;
            }
        }
    }

    @Override
    public Object findMin() {
        return this.estrutura[0];
    }

    @Override
    public void delete(int posicao) {
        swap(posicao, this.fullSize()-1);
        this.estrutura[this.fullSize()-1] = null;
        size--;
        heapifyDown(0);
        }

    @Override
    public void extractMin() {
        this.estrutura[1] = this.estrutura[size];
        this.estrutura[size] = null;
        heapifyDown(1);
        size--;
    }

    @Override
    public void heapifyDown(int posicao) {
        int smallest = posicao;
        int leftChildIdx = 2 * posicao;
        int rightChildIdx = 2 * posicao+1;
        if (leftChildIdx < size && (this.estrutura[smallest].compareTo(this.estrutura[leftChildIdx])> 0)) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < size && (this.estrutura[smallest].compareTo(this.estrutura[rightChildIdx]) > 0)) {
            smallest = rightChildIdx;
        }
        if (smallest != posicao) {

            swap(posicao, smallest);
            heapifyDown(smallest);
        }
    }

    @Override
    public void heapifyUp(int posicao) {
        int parentIdx = (int)posicao/2;
        int currentIdx = posicao;
        while (currentIdx > 0 && (this.estrutura[parentIdx].compareTo(this.estrutura[currentIdx]) > 0)) {
            swap(currentIdx,parentIdx);
            currentIdx = parentIdx;
            parentIdx = (int)parentIdx/2;
        }
    }

    @Override
    public int fullSize() {
        return estrutura.length;
    }
    public boolean isEmpty() {
        return this.estrutura[0] == null;
    }
    
    private void swap(int a, int b) {
        T temp = this.estrutura[a];
        this.estrutura[a] = this.estrutura[b];
        this.estrutura[b] = temp;
    }
    public int currentSize() {
        return size; 
    }
} 