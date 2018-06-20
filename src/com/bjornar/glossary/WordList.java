package com.bjornar.glossary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
    private static final String DATA_PATH = "C:\\Users\\Bjornar\\Documents\\Workspace\\Glossary\\textfiles\\";
    private static final String SPLITTER = "|";
    private String filename;
    private ArrayList<WordListItem> items = new ArrayList<WordListItem>();

    public WordList(String filename) throws IOException{
        this.filename = DATA_PATH + filename + ".txt";
        readFromFile();
    }

    public int getNumItemsLeft() {
        return items.size();
    }

    public WordListItem getItem(int index) {
        return items.get(index);
    }

    public void deleteItem(int index) {
        items.remove(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("English \t = \t Translation\n");
        sb.append("______________________________________\n");
        for(WordListItem item:items) {
            sb.append(item.getEnglishWord() + " \t = \t " + item.getTranslation() + "\n");
        }
        return sb.toString();
    }

    private void readFromFile() throws IOException {
        FileReader in = new FileReader(filename);
        BufferedReader br = new BufferedReader(in);
        String line;
        String[] parts;
        while ((line = br.readLine()) != null) {
            parts = line.split(SPLITTER);
            WordListItem wordListItem = new WordListItem(parts[0], parts[2]);
            items.add(wordListItem);
        }
    }
}