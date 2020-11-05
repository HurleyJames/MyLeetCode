package hard;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.internal.jline.internal.Preconditions.checkNotNull;

public class ArrayBlockingQueue implements Queue {

    /**
     * 存放队列元素的数组
     */
    Object[] arrs;

    /**
     * 取出数据的索引，用于take、poll、peek、remove方法
     */
    int takeIndex;

    /**
     * 存放数据的索引，用于put、offer、add方法
     */
    int putIndex;

    /**
     * 元素个数
     */
    int count;

    /**
     * 可重入锁
     */
    ReentrantLock lock;

    /**
     * 不为空的条件对象，由lock创建
     */
    private Condition notEmpty;

    /**
     * 不为满的条件对象，由lock创建
     */
    private Condition notFull;

    @Override
    public boolean add(Object value) {
        if (offer(value)) {
            return true;
        } else {
            throw new IllegalStateException("队列已满");
        }
    }

    @Override
    public boolean offer(Object value) {
        // 不允许元素为空
        checkNotNull(value);
        final ReentrantLock lock = this.lock;
        // 加锁，保证调用offer方法时，只有1个线程
        lock.lock();
        try {
            // 如果队列已满
            if (count == arrs.length) {
                return false;
            } else {

                return true;
            }
        } finally {
            // 释放锁，让其它线程可以调用offer方法
            lock.unlock();
        }
    }

    private void insert(Object value) {
        arrs[putIndex] = value;
//        putIndex = inc(putIndex);
        ++count;
        notEmpty.signal();
    }

    @Override
    public void put(Object value) {

    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public void take() {

    }
}

interface Queue {

    /**
     * 添加元素到队列中，添加成功则返回true，如果由于队列容量满了，则添加失败
     * 抛出IllegalStateException异常
     */
    boolean add(Object value);

    /**
     * 添加元素到队列中，成功返回true，失败返回false
     */
    boolean offer(Object value);

    /**
     * 添加元素到队列中，如果容量已经满了，就会阻塞到队列有元素并删除
     */
    void put(Object value);

    /**
     * 删除队列头部元素，如果队列为空，则返回null，否则返回头部元素
     * @return
     */
    Object poll();

    /**
     * 是否找到头结点对应的元素，并删除
     * 如果删除成功则返回true，否则返回false
     * @return
     */
    boolean remove(Object value);

    /**
     * 删除队列头部元素，如果队列为空，就一直阻塞到队列有元素为止并删除
     */
    void take();
}












