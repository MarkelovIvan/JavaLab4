// Клас для представлення розділових знаків
class Punctuation {
    private final char symbol;

    // Створює розділовий знак.
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    //Повертає символ розділового знака.
    public char getSymbol() {
        return symbol;
    }

    // Перевіряє, чи є цей знак кінцем речення.
    public boolean isEndOfSentence() {
        return symbol == '.' || symbol == '!' || symbol == '?';
    }
}