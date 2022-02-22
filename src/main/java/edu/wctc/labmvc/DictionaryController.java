package edu.wctc.labmvc;

import edu.wctc.labmvc.entity.Word;
import edu.wctc.labmvc.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DictionaryController {
    private WordListService wordListService;

    @Autowired
    public DictionaryController(WordListService wls) {
        this.wordListService = wls;
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("words", wordListService.getWords());
        return "index";
    }

//    @RequestMapping("/browse")
//    public String showBrowseWords() {
//        return "browse-words";
//    }

    @RequestMapping("/search")
    public String showSearchWords(Model model) {
        model.addAttribute("words", wordListService.getWords());

        Word defaultWord = new Word();
        defaultWord.setTerm("gorge");
        defaultWord.setDefinition("a definition");
        model.addAttribute("word", defaultWord);
        return "search";
    }

    @GetMapping("/{term}")
    public String showDefinition(@PathVariable("term") String term, Model model) {
        model.addAttribute("word", term);
        model.addAttribute("definition", wordListService.getWord(term));
        return "definition";
    }

    @PostMapping("/definition")
    public String showSearchDefinition(@RequestParam(name = "wordSearch") String word, Model model) {
        model.addAttribute("word", word);
        model.addAttribute("definition", wordListService.getWord(word));
        return "definition";
    }
}
