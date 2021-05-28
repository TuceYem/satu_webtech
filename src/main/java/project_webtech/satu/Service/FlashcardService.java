package project_webtech.satu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_webtech.satu.entity.Flashcard;
import project_webtech.satu.repository.FlashcardRepository;

import java.util.List;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;


    public List<Flashcard> getAllFlashcards(){
        return this.flashcardRepository.findAll();
    }

    public Flashcard getFlashcardById(Long id){
        return this.flashcardRepository.findById(id).orElse(null);
    }

    public Flashcard saveFlashcard(Flashcard flashcard){
        return this.flashcardRepository.save(flashcard);
    }

    public List<Flashcard> saveAllFlashcard(List<Flashcard> flashcards){
        return this.flashcardRepository.saveAll(flashcards);
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
