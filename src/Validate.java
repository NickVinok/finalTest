import java.io.*;

public class Validate {
    public static int intInput() {
        int size;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                size = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException exc) {
                System.out.print("Неккоректный ввод, повторите: ");
            }
            //Ввёл только затем, чтобы IDE не ругалась на нереализованное исключение
            catch (IOException exc) {
                System.out.println("Какая-то непонятная ситуация");
            }
        }
        return size;
    }
}
