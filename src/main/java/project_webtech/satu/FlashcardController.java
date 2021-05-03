package project_webtech.satu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project_webtech.satu.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class FlashcardController {

        @Autowired
        private FlashcardRepository FlashcardRepository;

        /**
         * Get all Flashcards list.
         *
         * @return the list
         */
        @GetMapping("/Flashcards")
        public List<Flashcard> getAllFlashcards() {
            return FlashcardRepository.findAll();
        }

        /**
         * Gets Flashcards by id.
         *
         * @param FlashcardId the Flashcard id
         * @return the Flashcards by id
         * @throws ResourceNotFoundException the resource not found exception
         */
        @GetMapping("/Flashcards/{id}")
        public ResponseEntity<Flashcard> getFlashcardsById(@PathVariable(value = "id") Long FlashcardId)
                throws ResourceNotFoundException {
            Flashcard Flashcard =
                    FlashcardRepository
                            .findById(FlashcardId)
                            .orElseThrow(() -> new ResourceNotFoundException("Flashcard not found on :: " + FlashcardId));
            return ResponseEntity.ok().body(Flashcard);
        }

        /**
         * Create Flashcard Flashcard.
         *
         * @param Flashcard the Flashcard
         * @return the Flashcard
         */
        @PostMapping("/Flashcards")
        public Flashcard createFlashcard(@Valid @RequestBody Flashcard Flashcard) {
            return FlashcardRepository.save(Flashcard);
        }

        /**
         * Update Flashcard response entity.
         *
         * @param FlashcardId the Flashcard id
         * @param FlashcardDetails the Flashcard details
         * @return the response entity
         * @throws ResourceNotFoundException the resource not found exception
         */
        @PutMapping("/Flashcards/{id}")
        public ResponseEntity<Flashcard> updateFlashcard(
                @PathVariable(value = "id") Long FlashcardId, @Valid @RequestBody Flashcard FlashcardDetails)
                throws ResourceNotFoundException {

            Flashcard Flashcard =
                    FlashcardRepository
                            .findById(FlashcardId)
                            .orElseThrow(() -> new ResourceNotFoundException("Flashcard not found on :: " + FlashcardId));

            Flashcard.setDeck(FlashcardDetails.getDeck());
            Flashcard.setFrontMsg(FlashcardDetails.getFrontMsg());
            Flashcard.setBackMsg(FlashcardDetails.getBackMsg());
            final Flashcard updatedFlashcard = FlashcardRepository.save(Flashcard);
            return ResponseEntity.ok(updatedFlashcard);
        }

        /**
         * Delete Flashcard map.
         *
         * @param FlashcardId the Flashcard id
         * @return the map
         * @throws Exception the exception
         */
        @DeleteMapping("/Flashcard/{id}")
        public Map<String, Boolean> deleteFlashcard(@PathVariable(value = "id") Long FlashcardId) throws Exception, ResourceNotFoundException {
            Flashcard Flashcard =
                    FlashcardRepository
                            .findById(FlashcardId)
                            .orElseThrow(() -> new ResourceNotFoundException("Flashcard not found on :: " + FlashcardId));

            FlashcardRepository.delete(Flashcard);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
    }

