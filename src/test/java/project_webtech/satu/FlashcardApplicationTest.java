/*
package project_webtech.satu;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import project_webtech.satu.Service.FlashcardService;
import project_webtech.satu.entity.Flashcard;
import project_webtech.satu.repository.FlashcardRepository;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class FlashcardApplicationTest {
    @Autowired
    private FlashcardService serviceTest;

    @MockBean
    private FlashcardRepository repoTest;

    @Test
    @DisplayName("Cards by Owner should not be empty after registering it")
    public void shouldRegisterFlashcardByOwner() {
        Flashcard f1 = new Flashcard("pen", "Stift");
        f1.setOwner("anna-example@example.de");
        doReturn(List.of(f1)).when(repoTest).findAll();
        List<Flashcard> actual = serviceTest.getAllFlashcards("anna-example@example.de");
        assertFalse(actual.isEmpty());
    }

    @Test
    @DisplayName("Should identify the amount of cards registered")
    public void shouldRegisterFlashcardByOwnerWithNumberOfRegistration() {
        Flashcard f1 = new Flashcard("pen", "Stift");
        f1.setOwner("anna-example@example.de");
        Flashcard f2 = new Flashcard("deck", "Stapel");
        f2.setOwner("anna-example@example.de");
        Flashcard f3 = new Flashcard("sugar", "Zucker");
        f3.setOwner("something@something.de");
        doReturn(List.of(f1, f2, f3)).when(repoTest).findAll();
        List<Flashcard> actual = serviceTest.getAllFlashcards("anna-example@example.de");
        assertEquals(2, actual.size());
    }

    @Test
    @DisplayName("Should register cards with the correct content")
    public void shouldRegisterFlashcardByOwnerWithCorrectContent() {
        Flashcard f1 = new Flashcard("pen", "Stift");
        f1.setOwner("anna-example@example.de");
        Flashcard f2 = new Flashcard("deck", "Stapel");
        f2.setOwner("anna-example@example.de");
        Flashcard f3 = new Flashcard("sugar", "Zucker");
        f3.setOwner("something@something.de");
        doReturn(List.of(f1, f2, f3)).when(repoTest).findAll();
        List<Flashcard> actual = serviceTest.getAllFlashcards("anna-example@example.de");
        List<Flashcard> expected = new ArrayList<Flashcard>();
        expected.add(new Flashcard("pen", "Stift"));
        expected.add(new Flashcard("deck", "Stapel"));
        assertEquals(expected.toString(), actual.toString());
    }

}*/