import java.util.Scanner;

public class Main {
    public static char[] encrypt(char[] message, int key) {
        char[] encryptedMessage = new char[message.length];

        for (int i = 0; i < message.length; i++) {
            char originalChar = message[i];
            char encryptedChar;

            if (Character.isLetter(originalChar)) {
                char baseChar = Character.isUpperCase(originalChar) ? 'А' : 'а';

                int originalIndex = originalChar - baseChar;
                int encryptedIndex = (originalIndex + key) % 32;

                encryptedChar = (char) (baseChar + encryptedIndex);
            } else {
                encryptedChar = originalChar;
            }

            encryptedMessage[i] = encryptedChar;
        }

        return encryptedMessage;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сообщение: ");
        String inputMessage = scanner.nextLine();

        System.out.print("Введите ключ: ");
        int key = scanner.nextInt();

        char[] message = inputMessage.toCharArray();

        char[] encryptedMessage = encrypt(message, key);

        System.out.println("Зашифрованное сообщение: " + new String(encryptedMessage));
    }
}