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