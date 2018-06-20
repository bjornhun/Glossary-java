package com.bjornar.glossary;

import java.util.Random;
import java.util.Scanner;

public class Quizzer {
    private WordList wordList;
    private Random rand = new Random();
    private Scanner in = new Scanner(System.in);

    private String guess;

    public Quizzer(WordList wordList) {
        this.wordList = wordList;
    }

    public void runQuiz() {
        while(wordList.getNumItemsLeft() > 0) {
            askQuestion();
        }
        System.out.println("Finished!");
    }

    private void askQuestion() {
        int randomIndex = rand.nextInt(wordList.getNumItemsLeft());
        WordListItem wordListItem = wordList.getItem(randomIndex);
        System.out.println("\n" + wordListItem.getEnglishWord());
        guess = in.next();
        if(wordListItem.getTranslation().equalsIgnoreCase(guess)) {
            System.out.println("Correct!");
            wordListItem.decrementNumCorrectGuesses();
            if(wordListItem.getNumCorrectGuesses() == 0) {
                wordList.deleteItem(randomIndex);
                System.out.println(wordList.getNumItemsLeft() + " words left.");
            }
        } else {
            memorizeWord(wordListItem);
        }
    }

    private void memorizeWord(WordListItem wordListItem) {
        System.out.println("False! Correct answer is " + wordListItem.getTranslation() + ".\nWrite it three times!");
        int requiredGuesses = 3;
        while(requiredGuesses > 0) {
            System.out.println("\n" + wordListItem.getEnglishWord());
            guess = in.next();
            if(!wordListItem.getTranslation().equalsIgnoreCase(guess)) {
                System.out.println("Wrong! Try again!");
                requiredGuesses = 3;
            } else {
                requiredGuesses--;
            }
        }
        System.out.println("Well done!");
    }


}
