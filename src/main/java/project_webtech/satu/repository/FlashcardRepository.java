package project_webtech.satu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_webtech.satu.entity.Flashcard;

public interface FlashcardRepository extends JpaRepository <Flashcard, Long> {

}
