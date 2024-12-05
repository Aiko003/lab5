import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EL {
    private List<Integer> elements;

    public EL() {
        elements = new ArrayList<>();
    }

    public void addElements(List<Integer> values) {
        elements.addAll(values);
    }

    public void removeElements(int valueToRemove) {
        elements.removeIf(element -> element.equals(valueToRemove));
    }

    @Override
    public String toString() {
        return "Список(" + "Элемент=" + elements + ')';
    }

    public void inputElements() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите список элементов через запятуюю:");

        while (true) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(",");
            List<Integer> values = new ArrayList<>();

            boolean validInput = true;

            for (String str : inputArray) {
                try {
                    values.add(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода! Пожалуйста, введите только целые числа.");
                    validInput = false;
                    break;
                }
            }

            if (validInput) {
                addElements(values);
                break;
            }
        }
    }

    public int inputValueToRemove() {
        Scanner scanner = new Scanner(System.in);
        int valueToRemove = 0;
        while (true) {
            System.out.println("Введите значение элемента для удаления из списка:");
            try {
                valueToRemove = scanner.nextInt();
                break; // Успешный ввод, выходим из цикла
            } catch ( NullPointerException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите целое число.");
                scanner.next(); // Очистка неверного ввода
            }
        }
        return valueToRemove;
    }
}
