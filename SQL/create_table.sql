CREATE TABLE public.director
(
    id integer NOT NULL DEFAULT nextval('director_id_seq'::regclass),
    birth_date timestamp without time zone,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT director_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.director
    OWNER to postgres;


CREATE TABLE public.film
(
    id integer NOT NULL DEFAULT nextval('film_id_seq'::regclass),
    genre character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    release_date timestamp without time zone,
    director_id integer,
    CONSTRAINT film_pkey PRIMARY KEY (id),
    CONSTRAINT director_film_fk FOREIGN KEY (director_id)
        REFERENCES public.director (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE public.film
    OWNER to postgres;


INSERT INTO director (first_name, last_name, birth_date) VALUES
('Steven', 'Spielberg', '1946-12-18'),
('Peter', 'Jackson', '1961-10-31'),
('Martin', 'Scorsese', '1942-11-17'),
('Christopher', 'Nolan', '1970-08-30'),
('Stephen', 'Soderbergh', '1963-01-14'),
('Ridley', 'Scott', '1937-11-30'),
('Michael', 'Mann', '1943-02-05');


INSERT INTO film (director_id, name, release_date, genre) VALUES
(1, 'Real Steel', '2011-10-06', 'action'),
(1, 'Super 8', '2011-06-09', 'fantasy'),
(1, 'Bumblebee', '2018-12-20', 'adventure'),
(1, 'Ready Player One', '2018-03-28', 'fantasy'),
(2, 'King Kong', '2005-12-14', 'adventure'),
(3, null, null, null),
(4, 'Tenet', '2020-08-26', 'crime'),
(5, 'Insomnia', '2002-06-06', 'drama'),
(5, 'Now Apocalypse', '2019-10-03', 'comedy'),
(6, 'The Passage', '2019-01-14', 'horror'),
(6, 'The Hot Zone', '2019-01-14', 'fantasy'),
(7, 'Ali', '2001-12-25', 'sports'),
(7, 'Heat', '1996-01-13', 'thriller'),
(7, 'The Last of the Mohicans', '1992-08-26', 'adventure');
