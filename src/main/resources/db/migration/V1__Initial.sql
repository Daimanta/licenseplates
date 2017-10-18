-- noinspection SqlNoDataSourceInspectionForFile


--
-- TOC entry 185 (class 1259 OID 16390)
-- Name: country; Type: TABLE; Schema: public; Owner: licenceplate_test
--

CREATE TABLE country (
    country_code character varying(255) NOT NULL
);



--
-- TOC entry 186 (class 1259 OID 16395)
-- Name: hibernate_sequences; Type: TABLE; Schema: public; Owner: licenceplate_test
--

CREATE TABLE hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    sequence_next_hi_value bigint
);


--
-- TOC entry 187 (class 1259 OID 16400)
-- Name: series; Type: TABLE; Schema: public; Owner: licenceplate_test
--

CREATE TABLE series (
    id bigint NOT NULL,
    full_regex character varying(255),
    name character varying(255),
    stripped_regex character varying(255),
    country_country_code character varying(255) NOT NULL
);


--
-- TOC entry 2059 (class 2606 OID 16394)
-- Name: country country_pkey; Type: CONSTRAINT; Schema: public; Owner: licenceplate_test
--

ALTER TABLE ONLY country
    ADD CONSTRAINT country_pkey PRIMARY KEY (country_code);


--
-- TOC entry 2061 (class 2606 OID 16399)
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: licenceplate_test
--

ALTER TABLE ONLY hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);



--
-- TOC entry 2063 (class 2606 OID 16407)
-- Name: series series_pkey; Type: CONSTRAINT; Schema: public; Owner: licenceplate_test
--

ALTER TABLE ONLY series
    ADD CONSTRAINT series_pkey PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 16408)
-- Name: series fk3ig2wfvycpx2uda6stobpks7i; Type: FK CONSTRAINT; Schema: public; Owner: licenceplate_test
--

ALTER TABLE ONLY series
    ADD CONSTRAINT fk3ig2wfvycpx2uda6stobpks7i FOREIGN KEY (country_country_code) REFERENCES country(country_code);


-- Completed on 2017-10-18 21:50:27

--
-- PostgreSQL database dump complete
--

