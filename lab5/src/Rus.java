import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Rus {
    private String text;

    // Конструктор
    public Rus(String text) {
        this.text = text;
    }

    // Метод для извлечения звонких согласных
    public Set<Character> getVoicedConsonants() {
        Set<Character> voicedConsonants = new HashSet<>();
        // Звонкие согласные буквы в русском языке
        char[] consonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р', 'с', 'т', 'х'};

        for (char c : consonants) {
            if (text.contains(String.valueOf(c))) {
                voicedConsonants.add(c);
            }
        }

        return voicedConsonants;
    }


    public TreeSet<Character> getSortedVoicedConsonants() {
        TreeSet<Character> sortedConsonants = new TreeSet<>(getVoicedConsonants());
        return sortedConsonants;
    }

    @Override
    public String toString() {
        return "\nТекст: " + text;
    }
}
