package com.bjornar.glossary;

public class Main {
    public static void main( String[] args )
    {
        WordListItem item = new WordListItem("hello", "hallo");
        System.out.println(item.getNumCorrectGuesses());
        System.out.println(item.decrementNumCorrectGuesses());
        System.out.println(item.decrementNumCorrectGuesses());
        System.out.println(item.getNumCorrectGuesses());
    }
}
