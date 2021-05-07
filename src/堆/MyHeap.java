package 堆;

/**
 * @ClassName: MyHeap
 * @Description: 自己的大根堆
 * @Author W.Wen
 * @Date 2021-01-25
 * @Version : V1.0
 */
public class MyHeap {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public MyHeap(int limit) {
        this.limit = limit;
    }


    /**
     * @return boolean
     * @Author W.Wen
     * @Description 判断堆是否为空
     * @Date 2021/1/24
     * @Param []
     **/
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * @return boolean
     * @Author W.Wen
     * @Description 判断堆是否已满
     * @Date 2021/1/24
     * @Param []
     **/
    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("堆已经满了！不能再加了");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        if (heapSize == 0) {
            throw new RuntimeException("堆中没有值了，不能再拿了");
        }
        int max = heap[0];
        swap(heap, 0, heapSize--);
        heapify(heap, 0);
        return max;
    }

    private void heapify(int[] heap, int i) {
        int left = i * 2 + 1;
        while (left < heapSize) {
            int largest = (left + 1 < heapSize && heap[left + 1] > heap[left]) ? left + 1 : left;
            largest = heap[i] >= heap[largest] ? i : largest;
            if (largest == i) {
                break;
            } else {
                swap(heap,largest,i);
                i=largest;
                left = i * 2 + 1;
            }
        }
    }

    private void heapInsert(int[] heap, int i) {
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) >> 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
