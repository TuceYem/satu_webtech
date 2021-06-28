CREATE TABLE if not exist flashcards
(
    id integer NOT NULL,
    deck character varying(255) NOT NULL,
    question character varying(255) NOT NULL,
    answer character varying(255) NOT NULL,
    owner character varying(255) NOT NULL,
    CONSTRAINT flashcards_pk PRIMARY KEY (id)
)
alter table flashcards owner to lbbujmwymcdztk;