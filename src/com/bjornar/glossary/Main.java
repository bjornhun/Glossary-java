package com.bjornar.glossary;

import java.io.IOException;

public class Main {
    public static void main( String[] args ) throws IOException
    {
        /*WordListItem item = new WordListItem("hello", "hallo");
        System.out.println(item.getNumCorrectGuesses());
        System.out.println(item.decrementNumCorrectGuesses());
        System.out.println(item.decrementNumCorrectGuesses());
        System.out.println(item.getNumCorrectGuesses());*/

        WordList words = new WordList("test");
        System.out.println(words);

        Quizzer quiz = new Quizzer(words);
        quiz.runQuiz();
    }
}
