import java.util.LinkedList;
import java.util.Queue;

public class Revers {
    private Queue<Integer> queue;

    // Конструктор
    public Revers() {
        this.queue = new LinkedList<>();
    }

    // Метод для добавления элемента в очередь
    public void add(int element) {
        queue.offer(element);
    }

    // Метод для разворота очереди
    public Queue<Integer> reverse() {
        Queue<Integer> reversedQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            reversedQueue.offer(queue.poll());
        }
        return reversedQueue;
    }

    // Метод toString для вывода элементов очереди
    @Override
    public String toString() {
        return queue.toString();
    }
}
