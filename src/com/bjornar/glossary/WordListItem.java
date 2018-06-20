package com.bjornar.glossary;

public class WordListItem {
    private String englishWord;
    private String translation;
    private int numCorrectGuesses = 3;

    public WordListItem(String englishWord, String translation) {
        this.englishWord = englishWord;
        this.translation = translation;
    }

    public String getEnglishWord() {return englishWord;}

    public String getTranslation() {return translation;}

    public int getNumCorrectGuesses() {return numCorrectGuesses;}

    public int decrementNumCorrectGuesses() {return --numCorrectGuesses;}
}