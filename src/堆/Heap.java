package 堆;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Heap
 * @description: 实现堆的结构
 * @date 2021-01-24
 */
public class Heap {
    /**
     * @Author W.Wen
     * @Description 静态内部类 自己实现的大根堆
     * @Date 2021/1/24
     * @Param
     * @return null
     **/
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        /**
         * @Author W.Wen
         * @Description 构造方法 初始化堆的容量
         * @Date 2021/1/24
         * @Param [limit]
         * @return null
         **/
        public MyMaxHeap(int limit) {
            this.limit = limit;
        }

        /**
         * @Author W.Wen
         * @Description 判断堆是否为空
         * @Date 2021/1/24
         * @Param []
         * @return boolean
         **/
        public boolean isEmpty() {
            return heapSize == 0;
        }

        /**
         * @Author W.Wen
         * @Description 判断堆是否已满
         * @Date 2021/1/24
         * @Param []
         * @return boolean
         **/
        public boolean isFull() {
            return heapSize == limit;
        }

        /**
         * @Author W.Wen
         * @Description 向堆中放值
         * @Date 2021/1/24
         * @Param [value]
         * @return void
         **/
        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("堆已经满了！");
            }
            heap[heapSize] = value;
            //value heapSize
            heapInsert(heap, heapSize++);
        }

        /**
         * @Author W.Wen
         * @Description 堆中的数据弹出
         * @Date 2021/1/24
         * @Param []
         * @return int
         **/
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        /**
         * @Author W.Wen
         * @Description 堆中数据向下沉的方法 堆结构实现的内部方法
         * @Date 2021/1/24
         * @Param [heap, index, heapSize]
         * @return void
         **/
        private void heapify(int[] heap, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && heap[left] < heap[left + 1] ? left + 1 : left;
                largest = heap[index] > heap[largest] ? index : largest;
                if (largest == index) {
                    break;
                }
                swap(heap, index, largest);
                index = largest;
                left = index * 2 + 1;
            }
        }

        /**
         * @Author W.Wen
         * @Description 堆加入数据时的调整方法 向上沉 堆结构实现的内部方法
         * @Date 2021/1/24
         * @Param [arr, index]
         * @return void
         **/
        private void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        /**
         * @Author W.Wen
         * @Description 交换数组中的元素的方法
         * @Date 2021/1/24
         * @Param [arr, i, j]
         * @return void
         **/
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
