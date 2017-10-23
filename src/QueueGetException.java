public class QueueGetException extends Exception {
    QueueGetException() {
    }

    public String toString() {
        return "Из очереди нечего извлекать";
    }
}
