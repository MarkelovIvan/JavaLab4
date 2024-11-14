import java.util.ArrayList;
import java.util.List;

// Клас для представлення речення, яке складається з слів та розділових знаків
class Sentence {
    private final List<Object> elements; // містить як слова, так і розділові знаки

    // Створює порожнє речення.
    public Sentence() {
        elements = new ArrayList<>();
    }

    //Додає слово до речення.
    public void addWord(Word word) {
        elements.add(word);
    }

    // Додає розділовий знак до речення.
    public void addPunctuation(Punctuation punctuation) {
        elements.add(punctuation);
    }

    //Перевіряє, чи є речення питальним (закінчується на знак питання).
    public boolean isQuestion() {
        if (!elements.isEmpty() && elements.get(elements.size() - 1) instanceof Punctuation) {
            return ((Punctuation) elements.get(elements.size() - 1)).getSymbol() == '?';
        }
        return false;
    }

    // Повертає список елементів речення.
    public List<Object> getElements() {
        return elements;
    }
}