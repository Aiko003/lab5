import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

import java.util.stream.Collectors;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 (1.1), 2 (3.1), 3 (4.1), 4 (5.1),5 (6.1) 6 (7.2)):");
        int v = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                v = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите корректное целое число:");
                scanner.next(); // Очистка неверного ввода
            }
        }
        scanner.nextLine();
        switch (v) {
            case 1:
                try {
                    Drob drob1 = new Drob(3, 4);
                    System.out.println("Создана дробь: " + drob1);
                    System.out.println("Вещественное значение дроби: " + drob1.toDecimal());

                    // Изменение числителя и знаменателя
                    drob1.setchislitel(1);
                    drob1.setznamenatel(2);
                    System.out.println("Измененная дробь: " + drob1);
                    System.out.println("Вещественное значение дроби: " + drob1.toDecimal());

                    // Создание дроби через ввод пользователя
                    System.out.println("\nВведите числитель дроби:");
                    int chislitel = scanner.nextInt();

                    System.out.println("Введите знаменатель дроби:");
                    int znamenatel = scanner.nextInt();

                    // Проверка на отрицательный знаменатель
                    if (znamenatel <= 0) {
                        System.out.println("Ошибка: знаменатель должен быть положительным.");
                    } else {
                        Drob userDrob = new Drob(chislitel, znamenatel);
                        System.out.println("Созданная вами дробь: " + userDrob);
                        System.out.println("вещенственное значение: " + userDrob.toDecimal());
                    }
                } catch (Exception e) {
                    System.out.println("Произошла ошибка. Пожалуйста, проверьте ввод.");
                }

                break;
            case 2:
                EL elementList = new EL();


                elementList.inputElements();
                System.out.println("Список элементов: " + elementList);

                // Удаление элементов
                int valueToRemove = elementList.inputValueToRemove();
                elementList.removeElements(valueToRemove);

                System.out.println("Список элементов после удаления: " + elementList);

                break;
            case 3:

                List<Student> students = new ArrayList<>();
                Map<String, Integer> surnameCount = new HashMap<>();


                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vladislav\\IdeaProjects\\lab5\\src\\students.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(" ");
                        if (parts.length != 2 || parts[0].length() > 20 || parts[1].length() > 15) {
                            System.out.println("Ошибка в строке: " + line);
                            continue;
                        }
                        String lastName = parts[0];
                        String firstName = parts[1];

                        // Создание студента и добавление его в список
                        Student student = new Student(lastName, firstName);
                        students.add(student);

                        // Генерация логина
                        surnameCount.put(lastName, surnameCount.getOrDefault(lastName, 0) + 1);
                        if (surnameCount.get(lastName) > 1) {
                            student.setLogin(lastName + surnameCount.get(lastName));
                        } else {
                            student.setLogin(lastName);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                    return;
                }

                // Печать списка студентов с логинами
                System.out.println("\nСписок студентов с логинами:");
                for (Student student : students) {
                    System.out.println(student);
                }
                break;
            case 4:
                // Запрос имени файла



                StringBuilder contentBuilder = new StringBuilder();

                // Чтение текста из файла
                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vladislav\\IdeaProjects\\lab5\\src\\text2.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        contentBuilder.append(line).append("\n");
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    return;
                }

                String inputText = contentBuilder.toString().trim();


                if (inputText.isEmpty()) {
                    System.out.println("Ошибка: текст не может быть пустым.");
                    return;
                }


                Rus rus = new Rus(inputText);


                System.out.println(rus);


                TreeSet<Character> sortedVoicedConsonants = rus.getSortedVoicedConsonants();

                System.out.println("Звонкие согласные буквы в алфавитном порядке:");
                if (sortedVoicedConsonants.isEmpty()) {
                    System.out.println("Нет звонких согласных букв.");
                } else {
                    for (char c : sortedVoicedConsonants) {
                        System.out.print(c + ",");
                    }
                    System.out.println();
                }
                break;
            case 5:
                Revers revers = new Revers();

                // Запрашиваем количество элементов
                System.out.print("Введите количество элементов: ");
                int count = 0;

                // Проверка на корректность ввода количества элементов
                while (true) {
                    try {
                        count = Integer.parseInt(scanner.nextLine());
                        if (count <= 0) {
                            throw new NumberFormatException();
                        }
                        break; // Выход из цикла, если ввод корректен
                    } catch (NumberFormatException e) {
                        System.out.print("Ошибка: введите положительное целое число: ");
                    }
                }

                // Запрашиваем элементы очереди
                System.out.println("Введите " + count + " целых чисел через запятую:");
                String input = scanner.nextLine();
                String[] inputElements = input.split(",");


                for (String element : inputElements) {
                    try {
                        int number = Integer.parseInt(element.trim());
                        revers.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: '" + element + "' не является корректным целым числом.");
                    }
                }

                // реверс очереди
                Queue<Integer> reversedQueue = revers.reverse();


                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Vladislav\\IdeaProjects\\lab5\\src\\text2.txt"))) {

                    writer.write("Элементы в обратном порядке " + reversedQueue.toString());
                    System.out.println("Элементы успешно записаны в файл ");
                } catch (IOException e) {
                    System.out.println("Ошибка при записи в файл: " + e.getMessage());
                }

                break;
            case 6:


                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Vladislav\\IdeaProjects\\lab5\\src\\text3.txt"))) {
                    List<Stroki> people = new ArrayList<>();
                    String line;

                    // Чтение строк из файла
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(":");
//                        Каждая строка разбивается на части с помощью разделителя
                        if (parts.length == 2 && !parts[1].trim().isEmpty()) {
//                            Проверяется, что строка была корректно разделена на две части и что вторая часть не пустая.
                            String name = capitalize(parts[0].trim().toLowerCase());
                            Integer number = Integer.parseInt(parts[1].trim());
                            people.add(new Stroki(name, number));
                        }
                    }

                    // Группировка по номерам
                    Map<Integer, List<String>> groupedByNumber = new HashMap<>();
                    for (Stroki person : people) {
                        groupedByNumber
                                .computeIfAbsent(person.getNumber(), k -> new ArrayList<>())
                                .add(person.getName());
                    }

                    // Формирование строки результата
                    String result = groupedByNumber.entrySet().stream()
                            .map(entry -> entry.getKey() + ":[" + String.join(", ", entry.getValue()) + "]")
                            .collect(Collectors.joining(", ", "[", "]"));

                    System.out.println(result);
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите задание (1 (1.1), 2 (3.1), 3 (4.1), 4 (5.1),5 (6.1) 6 (7.2))");
                break;
        }



    }
    // Метод для преобразования имени первая буква в верхнем регистре
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
}}
