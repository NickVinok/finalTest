public interface QueuesInterface {
    void put(int element);

    int get() throws QueueGetException;
}

class StaticQueue implements QueuesInterface {
    private int[] staticQueue;
    private int putElementIndex;
    private int getElementIndex;

    StaticQueue(int size) {
        staticQueue = new int[size];
        putElementIndex = getElementIndex = 0;
    }

    public void put(int element) {
        if (putElementIndex == staticQueue.length) {
            System.out.println("Очередь заполнена");
            return;
        }

        staticQueue[putElementIndex] = element;
        putElementIndex++;

    }

    //Переписать по-человески
    public int get() throws QueueGetException {
        if (getElementIndex == putElementIndex) {
            throw new QueueGetException();
        }
        getElementIndex++;
        return staticQueue[getElementIndex - 1];
    }
}

class CycledQueue implements QueuesInterface {
    private int[] cycledQueue;
    private int lElementPutIndex;
    private int lElementGotIndex;

    CycledQueue(int size) {
        cycledQueue = new int[size];
        lElementGotIndex = lElementPutIndex = 0;
    }

    public void put(int element) {
        try {
            cycledQueue[lElementPutIndex] = element;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Первый элемент очереди будет потерян");
            lElementPutIndex = 0;
            cycledQueue[lElementPutIndex] = element;
        } finally {
            lElementPutIndex++;
        }
    }

    public int get() throws QueueGetException {
        if (lElementGotIndex == cycledQueue.length) {
            lElementGotIndex = 0;
        } else if (lElementGotIndex == lElementPutIndex) {
            throw new QueueGetException();
        }
        lElementGotIndex++;
        return cycledQueue[lElementGotIndex - 1];
    }
}

class DynamicQueue implements QueuesInterface {
    int[] dynamicQueue;
    int lElementPutIndex;
    int lElementGotIndex;

    DynamicQueue() {
        dynamicQueue = new int[2];
        lElementPutIndex = lElementGotIndex;
    }

    public void put(int element) {
        if (lElementPutIndex == dynamicQueue.length) {
            System.out.println("Происходт расширение очереди");
            int[] tmpDynamicQueue = new int[dynamicQueue.length + 2];
            for (int i = 0; i < dynamicQueue.length; i++) {
                tmpDynamicQueue[i] = dynamicQueue[i];
            }
            dynamicQueue = tmpDynamicQueue;
        }

        dynamicQueue[lElementPutIndex] = element;
        lElementPutIndex++;
    }

    public int get() throws QueueGetException {
        if (lElementGotIndex == dynamicQueue.length) {
            lElementGotIndex = 0;
        } else if (lElementGotIndex == lElementPutIndex) {
            throw new QueueGetException();
        }
        lElementGotIndex++;
        return dynamicQueue[lElementGotIndex - 1];
    }
}