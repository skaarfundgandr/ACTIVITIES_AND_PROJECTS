public class QueueArray {
    String[] items;
    private int count;

    public QueueArray(int size) {
        items = new String[size];

        count = 0;
    }

    public QueueArray() {
        this(10);
    }

    public boolean enque(String str) {
        if (!isFull()) {
            items[count++] = str;

            return true;
        }

        return false;
    }

    public boolean deque() {
        int i, j;
        if (!isEmpty()) {
            for (i = 0, j = i + 1; i < count; i++, j++) {
                items[i] = items[j];
            }

            count--;
            items[j] = null;

            return true;
        }

        return false;
    }

    public String front() {
        if (!isEmpty()) {
            return items[0];
        }

        return null;
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < count; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Queue is empty");
        }
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }
}
