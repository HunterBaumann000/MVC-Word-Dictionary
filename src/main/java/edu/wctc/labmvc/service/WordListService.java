package edu.wctc.labmvc.service;

import edu.wctc.labmvc.entity.Word;

import java.util.List;

public interface WordListService {
    String getWord(String word);

    Object getWords();

    Word getDefinition(Word word);
}
