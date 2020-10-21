package basic;

/**
 * 定义一个小顶堆
 *
 * @param <T>
 */
public class ArrayHeap<T> {

    /**
     *
     */
    public int size;

    private T[] nodes;

    private static final int MIN_CAPACITY = 10;

    /**
     * 添加节点
     *
     * @param element
     * @return
     */
    public boolean add(T element) {
        // 如果原数组是空数组，则直接将元素插入进去，作为根节点
        if (size == 0) {
            nodes[0] = element;
            return true;
        }
        // 如果数组长度达到了节点个数，则需要扩容
        if (size >= nodes.length) {

        }
        // 定义插入位置的索引index，默认先插入到数组的最后
        int index = size;
        Comparable<T> node = (Comparable<T>) element;
        // 循环比较当前插入节点与其父节点的大小；如果大于父节点，则不交换；否则，则交换位置
        while (index > 0) {
            // 父节点的索引
            int parent = (index - 1) / 2;
            // 父节点的元素
            T parentNode = nodes[parent];
            // 如果当前插入的节点比父节点大，则就直接插入当前的位置
            if (node.compareTo(parentNode) >= 0) {
                break;
            }
            // 否则，插入位置与父节点的位置互换
            nodes[index] = parentNode;
            index = parent;
        }
        // 最后插入的位置
        nodes[index] = element;
        return true;
    }


    /**
     * 删除元素（最小元素）
     * @return
     */
    public boolean remove() {
        if (size == 0) {
            return false;
        }
        // 定义最后被替换的索引值
        int index = 0;
        // 最后一个元素，也就是最后被移动的元素
        T element = nodes[size - 1];
        Comparable<T> node = (Comparable<T>) element;
        // 父节点的个数
        int half = size / 2;
        while (index < half) {
            // 子节点索引即子节点的值
            int child = index * 2 + 1;
            T obj = nodes[child];
            // 右子节点的索引
            int rightChild = child + 1;
            // 如果右子节点比左子节点小，则互换位置
            if (rightChild < size && ((Comparable<T>) obj).compareTo(nodes[rightChild]) > 0) {
                child = rightChild;
                obj = nodes[child];
            }
            if (node.compareTo(obj) <= 0) {
                break;
            }
            // 最后一个元素仍然存储在最后一个位置上
            nodes[index] = obj;
            index = child;
        }

        nodes[index] = element;
        size--;
        return true;
    }

    /**
     * 清除堆
     * 将容量设置为0即可
     *
     * @param capacity
     */
    private void clearHeap(int capacity) {
        size = 0;
        ensureCapacity(capacity);
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }
        T[] oldNodes = nodes;
        // 创建新的容量的数组
        nodes = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            nodes[i] = oldNodes[i];
        }
    }
}
