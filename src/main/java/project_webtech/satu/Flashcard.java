package project_webtech.satu;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name = "flashcards")
@EntityListeners(AuditingEntityListener.class)
public class Flashcard {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name = "deck", nullable = false)
        private String deck;

        @Column(name = "front_message")
        private String frontMsg;

        @Column(name = "back_message")
        private String backMsg;


        /**
         * Gets ID.
         * @return the id
         */
        public long getId() {
            return id;
        }

        /**
         * Sets ID.
         * @param id the id
         */
        public void setId(long id) {
            this.id = id;
        }

        /**
         * Gets deck name.
         * @return the deck name
         */
        public String getDeck() {
            return deck;
        }

        /**
         * Sets deck name.
         * @param deck the name of the deck
         */
        public void setDeck(String deck) {
            this.deck = deck;
        }

        /**
         * Gets front message
         * @return the front message
         */
        public String getFrontMsg() {
            return frontMsg;
        }

        /**
         * Sets front message.
         * @param frontMsg the front message
         */
        public void setFrontMsg(String frontMsg) {
            this.frontMsg = frontMsg;
        }

        /**
         * Gets back message
         * @return the back message
         */
        public String getBackMsg() {
            return backMsg;
        }

        /**
         * Sets back message.
         * @param backMsg the back message
         */
        public void setBackMsg(String backMsg) {
            this.backMsg= backMsg;
        }


}

