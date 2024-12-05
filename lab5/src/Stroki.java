public class Stroki {
    private String name;
    private Integer number;

    // Конструктор
    public Stroki(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    // Метод toString
    @Override
    public String toString() {
        return name + (number != null ? ":" + number : "");
    }
}