import java.util.ArrayList;
import java.util.List;

// Клас для представлення слова, яке складається з літер
class Word {
    private final List<Letter> letters;

    // Створює слово з рядка тексту.
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    // Повертає довжину слова.
    public int getLength() {
        return letters.size();
    }

    // Повертає текст слова як рядок.
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getSymbol());
        }
        return sb.toString();
    }
}