package basic.LoopQueue;

/**
 * 手写一个循环队列
 */
public class LoopQueue implements IQueue{

    /**
     * 队列存储空间
     */
    private Object[] queueElem;
    /**
     * 队首引用，若队列不为空，指向队首的元素
     */
    private int front;
    /**
     * 队尾引用，若队列不为空，指向队尾的下一个元素
     */
    private int rear;

    public LoopQueue(int maxsize) {
        front = rear = 0;
        // 分配maxsize个单元
        queueElem = new Object[maxsize];
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }

    @Override
    public Object peek() {
        if (front == rear) {
            return null;
        } else {
            // 返回队首
            return queueElem[front];
        }
    }

    @Override
    public void offer(Object x) throws Exception {
        if ((rear + 1) % queueElem.length == front) {
            // 队列已满
            throw new Exception("This queue is full");
        } else {
            queueElem[rear] = x;
            // 修改队尾指针
            rear = (rear + 1) % queueElem.length;
        }
    }

    @Override
    public Object poll() {
        if (front == rear) {
            return null;
        } else {
            Object t = queueElem[front];
            front = (front + 1) % queueElem.length;
            return t;
        }
    }

    @Override
    public void display() {
        if (! isEmpty()) {
            for (int i = front; i != rear; i = (i + 1)  % queueElem.length) {
                System.out.println(queueElem[i].toString() + " ");
            }
        } else {
            System.out.println("This queue is empty!");
        }
    }
}
