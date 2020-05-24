-- Database: cryptoqr

-- DROP DATABASE cryptoqr;

CREATE DATABASE cryptoqr
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

	CREATE TABLE public.account
(
    id bigint NOT NULL,
    active boolean NOT NULL,
    blocked boolean NOT NULL,
    email character varying(100) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    name character varying(30) COLLATE pg_catalog."default",
    last_name character varying(30) COLLATE pg_catalog."default",
    profile_pic_url character varying(200) COLLATE pg_catalog."default",
    login_fail_attempts integer DEFAULT 0,
    last_login_fail_attempt_time timestamp without time zone,
    last_login_date timestamp without time zone,
    email_verified boolean,
    is_password_change boolean NOT NULL DEFAULT false,
    creation_date timestamp without time zone,
    CONSTRAINT account_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)

--QUERY PARA CREACION DE CUENTA DE USUARIO

INSERT INTO public.account(
	id, active, blocked, creation_date, email, email_verified, is_password_change, last_login_date, last_login_fail_attempt_time, last_name, login_fail_attempts, name, password, profile_pic_url, user_name)
	VALUES (1, true, false, 'NOW()', 'robertorojas20@gmail.com', true, false, null, null, 'rojas', 0, 'Roberto','sha1:64000:18:JT29onC2h1keO8C59BvSpE/JSiPti4fN:58YvrGswKmn0a6fOR9VyoxT5', null, 'rrojas');
