package project_webtech.satu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import project_webtech.satu.Service.FlashcardService;
import project_webtech.satu.entity.Flashcard;
import project_webtech.satu.repository.FlashcardRepository;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class FlashcardServiceTest {

    @Autowired
    private FlashcardService flashcardService;

    @MockBean
    private FlashcardRepository flashcardRepository;

    @Test
    @DisplayName("should find all flashcards by user")
    void testFindByOwnerEmail(){
        var f1 = new Flashcard("pen", "Stift");
        var f2 = new Flashcard("desk", "Schreibtisch");
        f1.setOwner("anna-example@example.de");
        f2.setOwner("anna-example@example.de");
        var f3 = new Flashcard("cake", "Kuchen");
        f3.setOwner("something@hotmail.de");
        doReturn(List.of(f1, f2)).when(flashcardRepository).findAll();

        List<Flashcard> userFlashcard = flashcardService.getAllFlashcards("anna-example@example.de");

        Assertions.assertSame(userFlashcard.size(), 2);
    }
}
