package minHeapComplete;

public class Heap<T extends Comparable<T>> implements Iheap {
    private T[] estrutura;
    private int size;

    @Override
    public void starHeap(int quantidade) {
        this.estrutura = (T[]) new Comparable[quantidade];
        size = 0;
    }

    @Override
    public void insert(Object elemento) {
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

    public static <T extends Comparable<T>> void heapSort(T[] vetor) {
        Heap<T> heap = new Heap<T>();
        heap.starHeap(vetor.length);
        for (int i = 0; i < vetor.length-1;i++) {
            heap.insert(vetor[i]);
        }
        for (int i = 0; i < vetor.length-1;i++) {
           vetor[i] = (T) heap.findMin();
           heap.extractMin();
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
        this.estrutura[0] = this.estrutura[size-1];
        this.estrutura[size-1] = null;
        heapifyDown(1);
        size--;

    }

    @Override
    public void heapifyDown(int posicao) {
        int smallest = posicao;
        int leftChildIdx = 2 * posicao + 1;
        int rightChildIdx = 2 * posicao + 2;
        System.out.println(smallest);
        if (size == 0) return;

        if (leftChildIdx < size && (this.estrutura[smallest].compareTo(this.estrutura[leftChildIdx])> 0)) {
            smallest = leftChildIdx;
            System.out.println("smal"+ smallest);
        }
        if (rightChildIdx < size && (this.estrutura[smallest].compareTo(this.estrutura[rightChildIdx]) > 0)) {
            smallest = rightChildIdx;
            System.out.println("smalright"+ smallest);
        }
        if (smallest != posicao) {
            System.out.println("smal whilw"+ smallest);
            swap(posicao, smallest);
            heapifyDown(smallest);
        }
    }

    @Override
    public void heapifyUp(int posicao) {
        int parentIdx = (int)(posicao-1)/2;
        int currentIdx = posicao;
        if (parentIdx == 0) {
            return;
        }
        while (currentIdx > 0 && (this.estrutura[parentIdx].compareTo(this.estrutura[currentIdx]) > 0)) {
            swap(currentIdx,parentIdx);
            currentIdx = parentIdx;
            parentIdx = (int)(parentIdx-1)/2;
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

    public void showHeap() {
        for(int i = 0; i < this.estrutura.length-1; i ++) {
            System.out.println(this.estrutura[i]);
        }
    }
} 