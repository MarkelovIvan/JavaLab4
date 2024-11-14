import java.util.HashSet;
import java.util.Set;

// Головний клас, який виконує аналіз тексту
public class Main {
    public static void main(String[] args) {
        try {
            // Заданий текст для аналізу
            String textContent = "Речення не є питальне? Це не є питальне речення! Чого саме тут питання? Невже тут немає чотирьох літер? Є чотири малі літери у цьому реченні.";
            int wordLength = 4;

            // Створюємо об'єкт тексту та виконуємо аналіз
            Text text = new Text(textContent);
            findAndPrintWords(text, wordLength);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Знаходить унікальні слова заданої довжини в усіх питальних реченнях тексту.
    public static void findAndPrintWords(Text text, int wordLength) { // об'єкт класу Text, що містить розбитий текст на речення
        Set<String> uniqueWords = new HashSet<>();

        // Проходимо через усі речення в тексті
        for (Sentence sentence : text.getSentences()) {
            // Перевірка, чи є речення питальним
            if (sentence.isQuestion()) {
                extractWordsFromSentence(sentence, wordLength, uniqueWords);
            }
        }

        // Виводимо знайдені слова
        System.out.println("Слова довжиною " + wordLength + " символів:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

     // Витягує всі слова заданої довжини з речення та додає їх до набору унікальних слів.
    public static void extractWordsFromSentence(Sentence sentence, int wordLength, Set<String> uniqueWords) {
        for (Object element : sentence.getElements()) { // речення, з якого потрібно витягти слова
            if (element instanceof Word) {
                Word word = (Word) element;
                if (word.getLength() == wordLength) { // довжина слова для пошуку
                    uniqueWords.add(word.getText()); // набір для зберігання унікальних слів
                }
            }
        }
    }
}

