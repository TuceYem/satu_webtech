package project_webtech.satu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import project_webtech.satu.entity.Flashcard;
import project_webtech.satu.repository.FlashcardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;


    public List<Flashcard> getAllFlashcards(String userEmail){
        var iterateFlashcards = this.flashcardRepository.findAll();

        var userFlashcards = new ArrayList<Flashcard>();
        for(Flashcard flashcard : iterateFlashcards){
            if(flashcard.getOwner()!=null && flashcard.getOwner().equals(userEmail)) userFlashcards.add(flashcard);
        }

        return userFlashcards;
    }

    public Flashcard saveFlashcard(OidcUser user, Flashcard flashcard){
        flashcard.setOwner(user.getEmail());
        return this.flashcardRepository.save(flashcard);
    }

    public String deleteFlashcardById(Long id){
        this.flashcardRepository.deleteById(id);
        return "flashcard removed";
    }

    public Flashcard updateFlashcard(Flashcard flashcard){
        Flashcard existingFlashcard = this.flashcardRepository.findById((flashcard.getId())).orElse(null);
        existingFlashcard.setQuestion(flashcard.getQuestion());
        existingFlashcard.setAnswer(flashcard.getAnswer());
        return this.flashcardRepository.save(existingFlashcard);
    }
}
