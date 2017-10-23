import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws QueueGetException, IOException {
        int menuItem;
        boolean isContinue = true;
        while (isContinue) {
            StaticQueue sq;
            CycledQueue cq;
            DynamicQueue dq;
            System.out.print("Введите нужный вам пункт меню: ");
            menuItem = Validate.intInput();
            switch (menuItem) {
                case 1: {
                    System.out.print("Введите размер очреди: ");
                    int size = Validate.intInput();
                    sq = new StaticQueue(size);
                    QueueAction.queueAction(sq);
                    break;
                }

                case 2: {
                    System.out.print("Введите размер очереди: ");
                    int size = Validate.intInput();
                    cq = new CycledQueue(size);
                    QueueAction.queueAction(cq);
                    break;
                }

                case 3: {
                    System.out.println("Начальный размер равен 2-ум, затем очередь будет расширяться");
                    dq = new DynamicQueue();
                    QueueAction.queueAction(dq);
                    break;
                }

                case 0: {
                    isContinue = false;
                    break;
                }
                default: {
                    System.out.print("Нет такого пункта меню, повторите ввод:");
                }
            }
        }
    }
}
