--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3 (Debian 10.3-1.pgdg90+1)
-- Dumped by pg_dump version 10.3 (Debian 10.3-1.pgdg90+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: A; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."A" (
    "A1" integer NOT NULL,
    "A2" text,
    "A3" integer DEFAULT 1,
    "B1_pk" text NOT NULL,
    "B2_pk" text NOT NULL
);


ALTER TABLE public."A" OWNER TO admin;

--
-- Name: B; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."B" (
    "B1" text NOT NULL,
    "B2" text NOT NULL,
    "B3" date
);


ALTER TABLE public."B" OWNER TO admin;

--
-- Name: C; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."C" (
    "C1" text NOT NULL,
    "C2" integer,
    "D1_Float" numeric,
    "A1_Pkey" integer
);


ALTER TABLE public."C" OWNER TO admin;

--
-- Name: D; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."D" (
    "D1" numeric
);


ALTER TABLE public."D" OWNER TO admin;

--
-- Data for Name: A; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."A" ("A1", "A2", "A3", "B1_pk", "B2_pk") FROM stdin;
\.


--
-- Data for Name: B; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."B" ("B1", "B2", "B3") FROM stdin;
\.


--
-- Data for Name: C; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."C" ("C1", "C2", "D1_Float", "A1_Pkey") FROM stdin;
\.


--
-- Data for Name: D; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."D" ("D1") FROM stdin;
\.


--
-- Name: A A1_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."A"
    ADD CONSTRAINT "A1_unique" UNIQUE ("A1");


--
-- Name: A A_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."A"
    ADD CONSTRAINT "A_pkey" PRIMARY KEY ("A1");


--
-- Name: B B1_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."B"
    ADD CONSTRAINT "B1_unique" UNIQUE ("B1");


--
-- Name: B B2_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."B"
    ADD CONSTRAINT "B2_unique" UNIQUE ("B2");


--
-- Name: B B_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."B"
    ADD CONSTRAINT "B_pkey" PRIMARY KEY ("B1", "B2");


--
-- Name: C C_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."C"
    ADD CONSTRAINT "C_pkey" PRIMARY KEY ("C1");


--
-- Name: D D1_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."D"
    ADD CONSTRAINT "D1_unique" UNIQUE ("D1");


--
-- Name: A RAB; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."A"
    ADD CONSTRAINT "RAB" FOREIGN KEY ("B1_pk") REFERENCES public."B"("B1");


--
-- Name: A RAB2; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."A"
    ADD CONSTRAINT "RAB2" FOREIGN KEY ("B2_pk") REFERENCES public."B"("B2");


--
-- Name: C RAC; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."C"
    ADD CONSTRAINT "RAC" FOREIGN KEY ("A1_Pkey") REFERENCES public."A"("A1");


--
-- Name: C RAC2; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."C"
    ADD CONSTRAINT "RAC2" FOREIGN KEY ("D1_Float") REFERENCES public."D"("D1");


--
-- PostgreSQL database dump complete
--

