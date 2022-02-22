package edu.wctc.labmvc.entity;

import edu.wctc.labmvc.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private static List<Word> dictionary = new ArrayList<>();

    private Dictionary(){};

    public static void addTerm(Word word) {
        dictionary.add(word);
    }
    public List<Word> getWord() {
        return dictionary;
    }
    public Word getTerm(Word word) {
        return word;
    }
}
