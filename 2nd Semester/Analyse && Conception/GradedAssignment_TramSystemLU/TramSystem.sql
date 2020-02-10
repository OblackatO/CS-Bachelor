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


--
-- Name: Login(text, text); Type: FUNCTION; Schema: public; Owner: admin
-- Simple login function in postgresSQL

CREATE FUNCTION public."Login"(name text, password text) RETURNS boolean
    LANGUAGE plpgsql
    AS $_$begin
	IF EXISTS(
		SELECT name, password
		FROM "RegisteredCustomer"
		WHERE(name=$1 AND password=$2)
	)THEN
		RETURN TRUE;
	END IF;
	return FALSE;
end
$_$;


ALTER FUNCTION public."Login"(name text, password text) OWNER TO admin;

--
-- Name: check_username(); Type: FUNCTION; Schema: public; Owner: admin
-- Check if username already exists in the database, raise exception if it does

CREATE FUNCTION public.check_username() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	IF EXISTS(
		SELECT name
		FROM "RegisteredCustomer"
		return WHERE(name=NEW.username)
	)THEN
		raise exception 'Username already exists.';
	END IF;
end
$$;


ALTER FUNCTION public.check_username() OWNER TO admin;

--
-- Name: checks_segments(); Type: FUNCTION; Schema: public; Owner: admin
-- 

CREATE FUNCTION public.checks_segments() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE var1 text;
DECLARE var2 integer;
begin
	SELECT id INTO var1 FROM "Station" 
	WHERE NEW.start_station = id;
	if NEW.id != var1 then
		SELECT number_of_segments INTO var2 FROM "Line";
			if number_of_segments < 2 then
				raise EXCEPTION 'There must be at least two segments between two different stations';
			END IF;
	END IF;
end
	
$$;


ALTER FUNCTION public.checks_segments() OWNER TO admin;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: AverageTime; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."AverageTime" (
    minutes integer NOT NULL
);


ALTER TABLE public."AverageTime" OWNER TO admin;

--
-- Name: Coach; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Coach" (
    id text NOT NULL,
    height integer,
    weight integer,
    total_places integer,
    "Train_ID" text,
    "Line_ID" text,
    "PrePaidCard_ID" text,
    "IDCard_ID" text,
    "TripTime" timestamp with time zone
);


ALTER TABLE public."Coach" OWNER TO admin;

--
-- Name: CreditCard; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."CreditCard" (
    "IBAN" text NOT NULL,
    name text,
    "RegisteredCus_ID" text,
    "SymmetricKey_ID" text
);


ALTER TABLE public."CreditCard" OWNER TO admin;

--
-- Name: Customer; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Customer" (
    id text NOT NULL,
    "Name" text,
    "SubscriptionSys_ID" text,
    "RegistrationForm_ID" uuid,
    "Website_ID" text,
    "LoginFormID" text,
    islogged boolean
);


ALTER TABLE public."Customer" OWNER TO admin;

--
-- Name: Direction; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Direction" (
    x integer NOT NULL,
    y integer NOT NULL
);


ALTER TABLE public."Direction" OWNER TO admin;

--
-- Name: Driver; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Driver" (
    id text NOT NULL,
    name text
);


ALTER TABLE public."Driver" OWNER TO admin;

--
-- Name: DriverTrain_Join; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."DriverTrain_Join" (
    "Driver_ID" uuid,
    "Train_ID" text,
    "DrivingTime" time(6) with time zone,
    "DrivingDate" date,
    id text NOT NULL
);


ALTER TABLE public."DriverTrain_Join" OWNER TO admin;

--
-- Name: Driving_Time; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Driving_Time" (
    date date NOT NULL,
    "time" time with time zone NOT NULL
);


ALTER TABLE public."Driving_Time" OWNER TO admin;

--
-- Name: EmailAddress; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."EmailAddress" (
    email_address text NOT NULL,
    "Driver_ID" uuid,
    "RegisteredCustomer_ID" text
);


ALTER TABLE public."EmailAddress" OWNER TO admin;

--
-- Name: EncryptionKey; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."EncryptionKey" (
    "SymmetricKey" text NOT NULL
);


ALTER TABLE public."EncryptionKey" OWNER TO admin;

--
-- Name: HomeAddress; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."HomeAddress" (
    id text NOT NULL,
    address text,
    door_number text,
    post_code integer,
    "Driver_ID" uuid,
    "RegisteredCustomer_ID" text
);


ALTER TABLE public."HomeAddress" OWNER TO admin;

--
-- Name: ID_card; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."ID_card" (
    id text NOT NULL,
    balance money,
    "RegisteredCustomer_ID" text
);


ALTER TABLE public."ID_card" OWNER TO admin;

--
-- Name: Line; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Line" (
    id text NOT NULL,
    number_of_segments integer
);


ALTER TABLE public."Line" OWNER TO admin;

--
-- Name: LoginCredentials; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."LoginCredentials" (
    username text,
    password text,
    id text NOT NULL,
    CONSTRAINT "LoginCredentials_password_check" CHECK ((length(password) >= 12)),
    CONSTRAINT "LoginCredentials_username_check" CHECK ((length(username) >= 6))
);


ALTER TABLE public."LoginCredentials" OWNER TO admin;

--
-- Name: LoginForm; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."LoginForm" (
    id text NOT NULL,
    username text,
    password text
);


ALTER TABLE public."LoginForm" OWNER TO admin;

--
-- Name: Maintenance; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Maintenance" (
    id text NOT NULL,
    last_maintenance date,
    "Train_ID" text,
    "Coach_ID" text
);


ALTER TABLE public."Maintenance" OWNER TO admin;

--
-- Name: MaintenanceProblem_Join; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."MaintenanceProblem_Join" (
    id text NOT NULL,
    "Problem_ID" text,
    "Maintenance_ID" text
);


ALTER TABLE public."MaintenanceProblem_Join" OWNER TO admin;

--
-- Name: PhoneNumber; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."PhoneNumber" (
    phone_number text NOT NULL,
    "Driver_ID" uuid,
    "RegisteredCustomer_ID" text
);


ALTER TABLE public."PhoneNumber" OWNER TO admin;

--
-- Name: PrePaidIDCard; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."PrePaidIDCard" (
    id text NOT NULL,
    balance money,
    "Customer_ID" text,
    "LoginCredentials_ID" text,
    CONSTRAINT "PrePaidIDCard_balance_check" CHECK ((balance >= 0))
);


ALTER TABLE public."PrePaidIDCard" OWNER TO admin;

--
-- Name: Problem; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Problem" (
    id text NOT NULL,
    title text,
    description text
);


ALTER TABLE public."Problem" OWNER TO admin;

--
-- Name: RegisteredCustomer; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."RegisteredCustomer" (
    id text NOT NULL,
    name text,
    password text,
    "HomeAddress_ID" text,
    "SubscriptionSys_ID" text,
    "CreditCard_ID" text,
    "Website_ID" text,
    "LoginForm_ID" text,
    islogged boolean
);


ALTER TABLE public."RegisteredCustomer" OWNER TO admin;

--
-- Name: RegistrationForm; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."RegistrationForm" (
    id uuid NOT NULL,
    name text,
    username text,
    "EmailAddress_ID" text NOT NULL,
    "PhoneNumber_ID" text,
    "HomeAdress_ID" text,
    "CreditCard_ID" text,
    password text
);


ALTER TABLE public."RegistrationForm" OWNER TO admin;

--
-- Name: SSLCertificate; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."SSLCertificate" (
    id text NOT NULL,
    domain text,
    ip_address text,
    signature text,
    "Website_ID" text
);


ALTER TABLE public."SSLCertificate" OWNER TO admin;

--
-- Name: Segment; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Segment" (
    id text NOT NULL,
    "Line_ID" text,
    "CoordinateX" integer,
    "CoordinateY" integer
);


ALTER TABLE public."Segment" OWNER TO admin;

--
-- Name: StartTime; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."StartTime" (
    id timestamp with time zone NOT NULL
);


ALTER TABLE public."StartTime" OWNER TO admin;

--
-- Name: Station; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Station" (
    id text NOT NULL
);


ALTER TABLE public."Station" OWNER TO admin;

--
-- Name: StationLine_Join; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."StationLine_Join" (
    "Station_ID" text,
    "Line_ID" text,
    "AverageTime" integer,
    "Joint_ID" text NOT NULL
);


ALTER TABLE public."StationLine_Join" OWNER TO admin;

--
-- Name: SubscriptionSystem; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."SubscriptionSystem" (
    id text NOT NULL,
    "WebSite_ID" text
);


ALTER TABLE public."SubscriptionSystem" OWNER TO admin;

--
-- Name: Train; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Train" (
    id text NOT NULL,
    height integer,
    weight integer,
    "Line_ID" text,
    start_time timestamp with time zone
);


ALTER TABLE public."Train" OWNER TO admin;

--
-- Name: TripTime; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."TripTime" (
    "time" timestamp with time zone NOT NULL
);


ALTER TABLE public."TripTime" OWNER TO admin;

--
-- Name: Website; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."Website" (
    id text NOT NULL,
    domain text,
    ip_address text,
    "SSLCertificate_ID" text
);


ALTER TABLE public."Website" OWNER TO admin;

--
-- Name: WorkingTime; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public."WorkingTime" (
    id text NOT NULL,
    day date,
    hour timestamp with time zone,
    start_time boolean,
    finish_time boolean,
    "Driver_ID" uuid,
    CONSTRAINT "WorkingTime_check" CHECK ((start_time = (NOT finish_time))),
    CONSTRAINT "WorkingTime_check1" CHECK ((finish_time = (NOT start_time)))
);


ALTER TABLE public."WorkingTime" OWNER TO admin;

--
-- Data for Name: AverageTime; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."AverageTime" (minutes) FROM stdin;
\.


--
-- Data for Name: Coach; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Coach" (id, height, weight, total_places, "Train_ID", "Line_ID", "PrePaidCard_ID", "IDCard_ID", "TripTime") FROM stdin;
\.


--
-- Data for Name: CreditCard; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."CreditCard" ("IBAN", name, "RegisteredCus_ID", "SymmetricKey_ID") FROM stdin;
\.


--
-- Data for Name: Customer; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Customer" (id, "Name", "SubscriptionSys_ID", "RegistrationForm_ID", "Website_ID", "LoginFormID", islogged) FROM stdin;
\.


--
-- Data for Name: Direction; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Direction" (x, y) FROM stdin;
\.


--
-- Data for Name: Driver; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Driver" (id, name) FROM stdin;
\.


--
-- Data for Name: DriverTrain_Join; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."DriverTrain_Join" ("Driver_ID", "Train_ID", "DrivingTime", "DrivingDate", id) FROM stdin;
\.


--
-- Data for Name: Driving_Time; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Driving_Time" (date, "time") FROM stdin;
\.


--
-- Data for Name: EmailAddress; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."EmailAddress" (email_address, "Driver_ID", "RegisteredCustomer_ID") FROM stdin;
\.


--
-- Data for Name: EncryptionKey; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."EncryptionKey" ("SymmetricKey") FROM stdin;
\.


--
-- Data for Name: HomeAddress; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."HomeAddress" (id, address, door_number, post_code, "Driver_ID", "RegisteredCustomer_ID") FROM stdin;
\.


--
-- Data for Name: ID_card; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."ID_card" (id, balance, "RegisteredCustomer_ID") FROM stdin;
\.


--
-- Data for Name: Line; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Line" (id, number_of_segments) FROM stdin;
\.


--
-- Data for Name: LoginCredentials; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."LoginCredentials" (username, password, id) FROM stdin;
\.


--
-- Data for Name: LoginForm; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."LoginForm" (id, username, password) FROM stdin;
\.


--
-- Data for Name: Maintenance; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Maintenance" (id, last_maintenance, "Train_ID", "Coach_ID") FROM stdin;
\.


--
-- Data for Name: MaintenanceProblem_Join; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."MaintenanceProblem_Join" (id, "Problem_ID", "Maintenance_ID") FROM stdin;
\.


--
-- Data for Name: PhoneNumber; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."PhoneNumber" (phone_number, "Driver_ID", "RegisteredCustomer_ID") FROM stdin;
\.


--
-- Data for Name: PrePaidIDCard; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."PrePaidIDCard" (id, balance, "Customer_ID", "LoginCredentials_ID") FROM stdin;
\.


--
-- Data for Name: Problem; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Problem" (id, title, description) FROM stdin;
\.


--
-- Data for Name: RegisteredCustomer; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."RegisteredCustomer" (id, name, password, "HomeAddress_ID", "SubscriptionSys_ID", "CreditCard_ID", "Website_ID", "LoginForm_ID", islogged) FROM stdin;
\.


--
-- Data for Name: RegistrationForm; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."RegistrationForm" (id, name, username, "EmailAddress_ID", "PhoneNumber_ID", "HomeAdress_ID", "CreditCard_ID", password) FROM stdin;
\.


--
-- Data for Name: SSLCertificate; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."SSLCertificate" (id, domain, ip_address, signature, "Website_ID") FROM stdin;
\.


--
-- Data for Name: Segment; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Segment" (id, "Line_ID", "CoordinateX", "CoordinateY") FROM stdin;
\.


--
-- Data for Name: StartTime; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."StartTime" (id) FROM stdin;
\.


--
-- Data for Name: Station; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Station" (id) FROM stdin;
\.


--
-- Data for Name: StationLine_Join; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."StationLine_Join" ("Station_ID", "Line_ID", "AverageTime", "Joint_ID") FROM stdin;
\.


--
-- Data for Name: SubscriptionSystem; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."SubscriptionSystem" (id, "WebSite_ID") FROM stdin;
\.


--
-- Data for Name: Train; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Train" (id, height, weight, "Line_ID", start_time) FROM stdin;
\.


--
-- Data for Name: TripTime; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."TripTime" ("time") FROM stdin;
\.


--
-- Data for Name: Website; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."Website" (id, domain, ip_address, "SSLCertificate_ID") FROM stdin;
\.


--
-- Data for Name: WorkingTime; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public."WorkingTime" (id, day, hour, start_time, finish_time, "Driver_ID") FROM stdin;
\.


--
-- Name: AverageTime AverageTime_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."AverageTime"
    ADD CONSTRAINT "AverageTime_pkey" PRIMARY KEY (minutes);


--
-- Name: Coach Coach_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Coach"
    ADD CONSTRAINT "Coach_pkey" PRIMARY KEY (id);


--
-- Name: CreditCard CreditCard_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."CreditCard"
    ADD CONSTRAINT "CreditCard_pkey" PRIMARY KEY ("IBAN");


--
-- Name: Customer Customer_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Customer"
    ADD CONSTRAINT "Customer_pkey" PRIMARY KEY (id);


--
-- Name: Direction Direction_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Direction"
    ADD CONSTRAINT "Direction_pkey" PRIMARY KEY (x, y);


--
-- Name: Direction Direction_x_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Direction"
    ADD CONSTRAINT "Direction_x_key" UNIQUE (x);


--
-- Name: Direction Direction_y_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Direction"
    ADD CONSTRAINT "Direction_y_key" UNIQUE (y);


--
-- Name: DriverTrain_Join DriverTrain_Join_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."DriverTrain_Join"
    ADD CONSTRAINT "DriverTrain_Join_pkey" PRIMARY KEY (id);


--
-- Name: Driver Driver_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Driver"
    ADD CONSTRAINT "Driver_pkey" PRIMARY KEY (id);


--
-- Name: Driving_Time Driving_Time_date_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Driving_Time"
    ADD CONSTRAINT "Driving_Time_date_key" UNIQUE (date);


--
-- Name: Driving_Time Driving_Time_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Driving_Time"
    ADD CONSTRAINT "Driving_Time_pkey" PRIMARY KEY (date, "time");


--
-- Name: Driving_Time Driving_Time_time_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Driving_Time"
    ADD CONSTRAINT "Driving_Time_time_key" UNIQUE ("time");


--
-- Name: EmailAddress EmailAddress_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."EmailAddress"
    ADD CONSTRAINT "EmailAddress_pkey" PRIMARY KEY (email_address);


--
-- Name: EncryptionKey EncryptionKey_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."EncryptionKey"
    ADD CONSTRAINT "EncryptionKey_pkey" PRIMARY KEY ("SymmetricKey");


--
-- Name: HomeAddress HomeAddress_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."HomeAddress"
    ADD CONSTRAINT "HomeAddress_pkey" PRIMARY KEY (id);


--
-- Name: ID_card ID_card_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."ID_card"
    ADD CONSTRAINT "ID_card_pkey" PRIMARY KEY (id);


--
-- Name: Line Line_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Line"
    ADD CONSTRAINT "Line_pkey" PRIMARY KEY (id);


--
-- Name: LoginCredentials LoginCredentials_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."LoginCredentials"
    ADD CONSTRAINT "LoginCredentials_pkey" PRIMARY KEY (id);


--
-- Name: LoginForm LoginForm_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."LoginForm"
    ADD CONSTRAINT "LoginForm_pkey" PRIMARY KEY (id);


--
-- Name: MaintenanceProblem_Join MaintenanceProblem_Join_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."MaintenanceProblem_Join"
    ADD CONSTRAINT "MaintenanceProblem_Join_pkey" PRIMARY KEY (id);


--
-- Name: Maintenance Maintenance_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Maintenance"
    ADD CONSTRAINT "Maintenance_pkey" PRIMARY KEY (id);


--
-- Name: PhoneNumber PhoneNumber_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."PhoneNumber"
    ADD CONSTRAINT "PhoneNumber_pkey" PRIMARY KEY (phone_number);


--
-- Name: PrePaidIDCard PrePaidIDCard_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."PrePaidIDCard"
    ADD CONSTRAINT "PrePaidIDCard_pkey" PRIMARY KEY (id);


--
-- Name: Problem Problem_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Problem"
    ADD CONSTRAINT "Problem_pkey" PRIMARY KEY (id);


--
-- Name: RegisteredCustomer RegisteredCustomer_id_key; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT "RegisteredCustomer_id_key" UNIQUE (id);


--
-- Name: RegisteredCustomer RegisteredCustomer_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT "RegisteredCustomer_pkey" PRIMARY KEY (id);


--
-- Name: RegistrationForm RegistrationForm_password_check; Type: CHECK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE public."RegistrationForm"
    ADD CONSTRAINT "RegistrationForm_password_check" CHECK ((length(password) >= 12)) NOT VALID;


--
-- Name: RegistrationForm RegistrationForm_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegistrationForm"
    ADD CONSTRAINT "RegistrationForm_pkey" PRIMARY KEY (id);


--
-- Name: RegistrationForm RegistrationForm_username_check; Type: CHECK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE public."RegistrationForm"
    ADD CONSTRAINT "RegistrationForm_username_check" CHECK ((length(username) >= 6)) NOT VALID;


--
-- Name: SSLCertificate SSLCertificate_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."SSLCertificate"
    ADD CONSTRAINT "SSLCertificate_pkey" PRIMARY KEY (id);


--
-- Name: Segment Segment_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Segment"
    ADD CONSTRAINT "Segment_pkey" PRIMARY KEY (id);


--
-- Name: StartTime StartTime_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."StartTime"
    ADD CONSTRAINT "StartTime_pkey" PRIMARY KEY (id);


--
-- Name: StationLine_Join StationLine_Joint_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."StationLine_Join"
    ADD CONSTRAINT "StationLine_Joint_pkey" PRIMARY KEY ("Joint_ID");


--
-- Name: Station Station_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Station"
    ADD CONSTRAINT "Station_pkey" PRIMARY KEY (id);


--
-- Name: SubscriptionSystem SubscriptionSystem_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."SubscriptionSystem"
    ADD CONSTRAINT "SubscriptionSystem_pkey" PRIMARY KEY (id);


--
-- Name: Train Train_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Train"
    ADD CONSTRAINT "Train_pkey" PRIMARY KEY (id);


--
-- Name: TripTime TripTime_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."TripTime"
    ADD CONSTRAINT "TripTime_pkey" PRIMARY KEY ("time");


--
-- Name: Website Website_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Website"
    ADD CONSTRAINT "Website_pkey" PRIMARY KEY (id);


--
-- Name: WorkingTime WorkingTime_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."WorkingTime"
    ADD CONSTRAINT "WorkingTime_pkey" PRIMARY KEY (id);


--
-- Name: RegistrationForm check_username; Type: TRIGGER; Schema: public; Owner: admin
--

CREATE TRIGGER check_username BEFORE INSERT OR UPDATE OF username ON public."RegistrationForm" FOR EACH ROW EXECUTE PROCEDURE public.check_username();


--
-- Name: Station checks_segments; Type: TRIGGER; Schema: public; Owner: admin
--

CREATE TRIGGER checks_segments BEFORE INSERT OR UPDATE ON public."Station" FOR EACH ROW EXECUTE PROCEDURE public.checks_segments();


--
-- Name: Coach Coach_IDCard_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Coach"
    ADD CONSTRAINT "Coach_IDCard_ID_fkey" FOREIGN KEY ("IDCard_ID") REFERENCES public."ID_card"(id);


--
-- Name: Coach Coach_Line_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Coach"
    ADD CONSTRAINT "Coach_Line_ID_fkey" FOREIGN KEY ("Line_ID") REFERENCES public."Line"(id);


--
-- Name: Coach Coach_PrePaidCard_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Coach"
    ADD CONSTRAINT "Coach_PrePaidCard_ID_fkey" FOREIGN KEY ("PrePaidCard_ID") REFERENCES public."PrePaidIDCard"(id);


--
-- Name: Coach Coach_Train_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Coach"
    ADD CONSTRAINT "Coach_Train_ID_fkey" FOREIGN KEY ("Train_ID") REFERENCES public."Train"(id);


--
-- Name: Coach Coach_TripTime_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Coach"
    ADD CONSTRAINT "Coach_TripTime_fkey" FOREIGN KEY ("TripTime") REFERENCES public."TripTime"("time");


--
-- Name: Customer Customer_LoginFormID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Customer"
    ADD CONSTRAINT "Customer_LoginFormID_fkey" FOREIGN KEY ("LoginFormID") REFERENCES public."LoginForm"(id);


--
-- Name: DriverTrain_Join DriverTrain_Join_DrivingDate_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."DriverTrain_Join"
    ADD CONSTRAINT "DriverTrain_Join_DrivingDate_fkey" FOREIGN KEY ("DrivingDate") REFERENCES public."Driving_Time"(date);


--
-- Name: DriverTrain_Join DriverTrain_Join_DrivingTime_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."DriverTrain_Join"
    ADD CONSTRAINT "DriverTrain_Join_DrivingTime_fkey" FOREIGN KEY ("DrivingTime") REFERENCES public."Driving_Time"("time");


--
-- Name: DriverTrain_Join DriverTrain_Join_Train_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."DriverTrain_Join"
    ADD CONSTRAINT "DriverTrain_Join_Train_ID_fkey" FOREIGN KEY ("Train_ID") REFERENCES public."Train"(id);


--
-- Name: EmailAddress EmailAddress_RegisteredCustomer_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."EmailAddress"
    ADD CONSTRAINT "EmailAddress_RegisteredCustomer_ID_fkey" FOREIGN KEY ("RegisteredCustomer_ID") REFERENCES public."RegisteredCustomer"(id);


--
-- Name: HomeAddress HomeAddress_RegisteredCustomer_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."HomeAddress"
    ADD CONSTRAINT "HomeAddress_RegisteredCustomer_ID_fkey" FOREIGN KEY ("RegisteredCustomer_ID") REFERENCES public."RegisteredCustomer"(id);


--
-- Name: ID_card ID_card_RegisteredCustomer_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."ID_card"
    ADD CONSTRAINT "ID_card_RegisteredCustomer_ID_fkey" FOREIGN KEY ("RegisteredCustomer_ID") REFERENCES public."RegisteredCustomer"(id);


--
-- Name: MaintenanceProblem_Join MaintenanceProblem_Join_Maintenance_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."MaintenanceProblem_Join"
    ADD CONSTRAINT "MaintenanceProblem_Join_Maintenance_ID_fkey" FOREIGN KEY ("Maintenance_ID") REFERENCES public."Maintenance"(id);


--
-- Name: MaintenanceProblem_Join MaintenanceProblem_Join_Problem_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."MaintenanceProblem_Join"
    ADD CONSTRAINT "MaintenanceProblem_Join_Problem_ID_fkey" FOREIGN KEY ("Problem_ID") REFERENCES public."Problem"(id);


--
-- Name: Maintenance Maintenance_Coach_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Maintenance"
    ADD CONSTRAINT "Maintenance_Coach_ID_fkey" FOREIGN KEY ("Coach_ID") REFERENCES public."Coach"(id);


--
-- Name: Maintenance Maintenance_Train_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Maintenance"
    ADD CONSTRAINT "Maintenance_Train_ID_fkey" FOREIGN KEY ("Train_ID") REFERENCES public."Train"(id);


--
-- Name: PhoneNumber PhoneNumber_RegisteredCustomer_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."PhoneNumber"
    ADD CONSTRAINT "PhoneNumber_RegisteredCustomer_ID_fkey" FOREIGN KEY ("RegisteredCustomer_ID") REFERENCES public."RegisteredCustomer"(id);


--
-- Name: PrePaidIDCard PrePaidIDCard_Customer_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."PrePaidIDCard"
    ADD CONSTRAINT "PrePaidIDCard_Customer_ID_fkey" FOREIGN KEY ("Customer_ID") REFERENCES public."Customer"(id);


--
-- Name: PrePaidIDCard PrePaidIDCard_LoginCredentials_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."PrePaidIDCard"
    ADD CONSTRAINT "PrePaidIDCard_LoginCredentials_ID_fkey" FOREIGN KEY ("LoginCredentials_ID") REFERENCES public."LoginCredentials"(id);


--
-- Name: RegistrationForm RegistrationForm_EmailAddress_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegistrationForm"
    ADD CONSTRAINT "RegistrationForm_EmailAddress_ID_fkey" FOREIGN KEY ("EmailAddress_ID") REFERENCES public."EmailAddress"(email_address);


--
-- Name: SSLCertificate SSLCertificate_Website_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."SSLCertificate"
    ADD CONSTRAINT "SSLCertificate_Website_ID_fkey" FOREIGN KEY ("Website_ID") REFERENCES public."Website"(id);


--
-- Name: Segment Segment_CoordinateX_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Segment"
    ADD CONSTRAINT "Segment_CoordinateX_fkey" FOREIGN KEY ("CoordinateX") REFERENCES public."Direction"(x) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: Segment Segment_CoordinateY_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Segment"
    ADD CONSTRAINT "Segment_CoordinateY_fkey" FOREIGN KEY ("CoordinateY") REFERENCES public."Direction"(y) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: Segment Segment_Line_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Segment"
    ADD CONSTRAINT "Segment_Line_ID_fkey" FOREIGN KEY ("Line_ID") REFERENCES public."Line"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: StationLine_Join StationLine_Joint_AverageTime_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."StationLine_Join"
    ADD CONSTRAINT "StationLine_Joint_AverageTime_fkey" FOREIGN KEY ("AverageTime") REFERENCES public."AverageTime"(minutes);


--
-- Name: StationLine_Join StationLine_Joint_Line_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."StationLine_Join"
    ADD CONSTRAINT "StationLine_Joint_Line_ID_fkey" FOREIGN KEY ("Line_ID") REFERENCES public."Line"(id);


--
-- Name: Train Train_Line_ID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Train"
    ADD CONSTRAINT "Train_Line_ID_fkey" FOREIGN KEY ("Line_ID") REFERENCES public."Line"(id);


--
-- Name: Train Train_start_time_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Train"
    ADD CONSTRAINT "Train_start_time_fkey" FOREIGN KEY (start_time) REFERENCES public."StartTime"(id);


--
-- Name: RegisteredCustomer has; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT has FOREIGN KEY ("HomeAddress_ID") REFERENCES public."HomeAddress"(id);


--
-- Name: CreditCard has; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."CreditCard"
    ADD CONSTRAINT has FOREIGN KEY ("RegisteredCus_ID") REFERENCES public."RegisteredCustomer"(id);


--
-- Name: Website has; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Website"
    ADD CONSTRAINT has FOREIGN KEY ("SSLCertificate_ID") REFERENCES public."SSLCertificate"(id);


--
-- Name: CreditCard has a key; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."CreditCard"
    ADD CONSTRAINT "has a key" FOREIGN KEY ("SymmetricKey_ID") REFERENCES public."EncryptionKey"("SymmetricKey");


--
-- Name: RegisteredCustomer has cc; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT "has cc" FOREIGN KEY ("CreditCard_ID") REFERENCES public."CreditCard"("IBAN");


--
-- Name: RegisteredCustomer is registered; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT "is registered" FOREIGN KEY ("SubscriptionSys_ID") REFERENCES public."SubscriptionSystem"(id);


--
-- Name: Customer logins; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Customer"
    ADD CONSTRAINT logins FOREIGN KEY ("Website_ID") REFERENCES public."Website"(id);


--
-- Name: RegisteredCustomer logins; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT logins FOREIGN KEY ("Website_ID") REFERENCES public."Website"(id);


--
-- Name: RegisteredCustomer logins attribute; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."RegisteredCustomer"
    ADD CONSTRAINT "logins attribute" FOREIGN KEY ("LoginForm_ID") REFERENCES public."LoginCredentials"(id);


--
-- Name: StationLine_Join none; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."StationLine_Join"
    ADD CONSTRAINT "none" FOREIGN KEY ("Station_ID") REFERENCES public."Station"(id);


--
-- Name: Customer registers; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Customer"
    ADD CONSTRAINT registers FOREIGN KEY ("SubscriptionSys_ID") REFERENCES public."SubscriptionSystem"(id);


--
-- Name: Customer registers_attribute; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public."Customer"
    ADD CONSTRAINT registers_attribute FOREIGN KEY ("RegistrationForm_ID") REFERENCES public."RegistrationForm"(id);


--
-- PostgreSQL database dump complete
--

