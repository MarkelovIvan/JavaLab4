import java.util.ArrayList;
import java.util.List;

// Клас для представлення тексту, який складається з речень
class Text {
    private final List<Sentence> sentences;

    // Створює текст з рядка, розбиваючи його на речення.
    public Text(String input) {
        sentences = new ArrayList<>();
        parseText(input);
    }

    //Розбиває текст на речення та видаляє зайві пробіли.
    private void parseText(String input) {
        input = input.replaceAll("\\s+", " "); // Заміна послідовності пробілів на один
        Sentence currentSentence = new Sentence();
        StringBuilder currentWord = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {
                if (currentWord.length() > 0) {
                    currentSentence.addWord(new Word(currentWord.toString()));
                    currentWord.setLength(0);
                }
                if (c == ' ' || c == '\t') continue;

                Punctuation punctuation = new Punctuation(c);
                currentSentence.addPunctuation(punctuation);

                if (punctuation.isEndOfSentence()) {
                    sentences.add(currentSentence);
                    currentSentence = new Sentence();
                }
            }
        }

        if (currentWord.length() > 0) {
            currentSentence.addWord(new Word(currentWord.toString()));
        }
        if (!currentSentence.getElements().isEmpty()) {
            sentences.add(currentSentence);
        }
    }

    // Повертає список речень у тексті.
    public List<Sentence> getSentences() {
        return sentences;
    }
}