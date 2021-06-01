package project_webtech.satu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project_webtech.satu.Service.FlashcardService;
import project_webtech.satu.entity.Flashcard;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping("/flashcards")
    @ResponseStatus(HttpStatus.OK)
    public List<Flashcard> getAllFlashcards(){
        return this.flashcardService.getAllFlashcards();
    }

    @GetMapping("/flashcards/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flashcard getFlashcardById(@PathVariable Long id){
        return this.flashcardService.getFlashcardById(id);
    }

    @PostMapping("/flashcards/save")
    @ResponseStatus(HttpStatus.OK)
    public Flashcard saveFlashcard(@RequestBody Flashcard flashcard){
        return this.flashcardService.saveFlashcard(flashcard);
    }

    @PostMapping("/flashcards/save/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Flashcard> saveAllFlashcard(@RequestBody List<Flashcard> flashcards){
        return this.flashcardService.saveAllFlashcard(flashcards);
    }

    @DeleteMapping("/flashcards/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteFlashcardById(@PathVariable Long id){
        return this.flashcardService.deleteFlashcardById(id);
    }

    @PutMapping("/flashcards/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flashcard updateFlashcard(@RequestBody Flashcard flashcard){
        return this.flashcardService.updateFlashcard(flashcard);
    }
}
