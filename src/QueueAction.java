public class QueueAction {
    public static void queueAction(QueuesInterface qi) throws QueueGetException {
        boolean isContinue = true;
        System.out.println("1. Добавить элемент в очередь;");
        System.out.println("2. Извлечь элемент из очереди;");
        System.out.println("0. Закнчить работу с очередью;");
        while (isContinue) {
            System.out.print("Что вы хотите сделать с очередью: ");
            int choice = Validate.intInput();
            switch (choice) {
                case 1: {
                    System.out.print("Введите элемент: ");
                    int element = Validate.intInput();
                    qi.put(element);
                    break;
                }
                case 2: {
                    try {
                        System.out.println(qi.get());
                    } catch (QueueGetException exc) {
                        System.out.println(exc);
                    }
                    break;
                }
                case 0: {
                    isContinue = false;
                    break;
                }
                default: {
                    System.out.println("Неккоректный ввод пункта меню");
                }
            }
        }
    }
}
