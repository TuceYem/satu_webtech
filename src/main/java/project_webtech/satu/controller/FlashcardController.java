package project_webtech.satu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
    public List<Flashcard> getAllFlashcards(@AuthenticationPrincipal OidcUser user){
        return this.flashcardService.getAllFlashcards(user.getEmail());
    }

    @PostMapping("/flashcards/save")
    @ResponseStatus(HttpStatus.OK)
    public Flashcard saveFlashcard(@AuthenticationPrincipal OidcUser user, @RequestBody Flashcard flashcard){
        return this.flashcardService.saveFlashcard(user, flashcard);
    }

    @DeleteMapping("/flashcards/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteFlashcardById(@AuthenticationPrincipal OidcUser user, @PathVariable Long id){
        return this.flashcardService.deleteFlashcardById(id);
    }

    @PutMapping("/flashcards/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flashcard updateFlashcard(@AuthenticationPrincipal OidcUser user, @RequestBody Flashcard flashcard){
        return this.flashcardService.updateFlashcard(flashcard);
    }
}
