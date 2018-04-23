CREATE TABLE public.mtc_ticket_number (
	id_ticket_number serial NOT NULL,
	prefix varchar(50) NOT NULL,
	number integer NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	PRIMARY KEY (id_ticket_number)
);


CREATE TABLE public.mtc_reclamo (
	id_reclamo serial NOT NULL,
	id_estado_reclamo integer NOT NULL,
	descripcion varchar(1000) NOT NULL,
	ticket varchar(30) NOT NULL,
	date timestamp with time zone NOT NULL,
	version integer NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	PRIMARY KEY (id_reclamo)
);

CREATE INDEX ON public.mtc_reclamo
	(id_estado_reclamo);


CREATE TABLE public.mtc_estado_reclamo (
	id_estado_reclamo serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	PRIMARY KEY (id_estado_reclamo)
);


ALTER TABLE public.mtc_reclamo ADD CONSTRAINT FK_mtc_reclamo__id_estado_reclamo FOREIGN KEY (id_estado_reclamo) REFERENCES public.mtc_estado_reclamo(id_estado_reclamo);