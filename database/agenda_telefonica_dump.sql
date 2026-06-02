--
-- PostgreSQL database dump
--

\restrict yKBCaXn9EJ8Ce8BUk8dZJIIqBaAEct00yeNpgkwz7CSZO5autPGh3TICaMgh98g

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-06-01 01:53:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16386)
-- Name: contatos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contatos (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    telefone character varying(20) NOT NULL,
    email character varying(100) NOT NULL
);


ALTER TABLE public.contatos OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16385)
-- Name: contatos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contatos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.contatos_id_seq OWNER TO postgres;

--
-- TOC entry 5015 (class 0 OID 0)
-- Dependencies: 219
-- Name: contatos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contatos_id_seq OWNED BY public.contatos.id;


--
-- TOC entry 4856 (class 2604 OID 16389)
-- Name: contatos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contatos ALTER COLUMN id SET DEFAULT nextval('public.contatos_id_seq'::regclass);


--
-- TOC entry 5009 (class 0 OID 16386)
-- Dependencies: 220
-- Data for Name: contatos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contatos (id, nome, telefone, email) FROM stdin;
1	Ana Souza	(62) 99999-1111	ana@email.com
2	Carlos Lima	(62) 98888-2222	carlos@email.com
3	Mariana Alves	(62) 97777-3333	mariana@email.com
\.


--
-- TOC entry 5016 (class 0 OID 0)
-- Dependencies: 219
-- Name: contatos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contatos_id_seq', 3, true);


--
-- TOC entry 4858 (class 2606 OID 16397)
-- Name: contatos contatos_nome_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contatos
    ADD CONSTRAINT contatos_nome_unique UNIQUE (nome);


--
-- TOC entry 4860 (class 2606 OID 16395)
-- Name: contatos contatos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contatos
    ADD CONSTRAINT contatos_pkey PRIMARY KEY (id);


-- Completed on 2026-06-01 01:53:42

--
-- PostgreSQL database dump complete
--

\unrestrict yKBCaXn9EJ8Ce8BUk8dZJIIqBaAEct00yeNpgkwz7CSZO5autPGh3TICaMgh98g

