CREATE TABLE public.mtc_ticket_number (
	id_ticket_number serial NOT NULL,
	prefix varchar(50) NOT NULL,
	number integer NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	PRIMARY KEY (id_ticket_number)
);


COMMENT ON TABLE public.mtc_ticket_number
	IS 'tabla generadora de tickets para la columna ticket de la tabla reclamo';

CREATE TABLE public.mtc_reclamo (
	id_reclamo serial NOT NULL,
	id_estado_reclamo integer NOT NULL,
	id_tipo_reclamo integer NOT NULL,
	id_empresa integer NOT NULL,
	id_dependencia integer NOT NULL,
	descripcion varchar(1000) NOT NULL,
	ticket varchar(30) NOT NULL,
	fecha_hora timestamp with time zone NOT NULL,
	version integer NOT NULL,
	observacion varchar(1000),
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_reclamo)
);

CREATE INDEX ON public.mtc_reclamo
	(id_estado_reclamo);
CREATE INDEX ON public.mtc_reclamo
	(id_tipo_reclamo);
CREATE INDEX ON public.mtc_reclamo
	(id_empresa);
CREATE INDEX ON public.mtc_reclamo
	(id_dependencia);


COMMENT ON COLUMN public.mtc_reclamo.version
	IS 'campo para lidiar con la concurrencia en jpa mediante la anotacion @version';

CREATE TABLE public.mtc_estado_reclamo (
	id_estado_reclamo serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_estado_reclamo)
);


CREATE TABLE public.mtc_empresa (
	id_empresa serial NOT NULL,
	id_razon_social integer NOT NULL,
	id_usuario_contacto integer NOT NULL,
	nombre varchar(50) NOT NULL,
	rubro varchar(200) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_empresa)
);

CREATE INDEX ON public.mtc_empresa
	(id_razon_social);
CREATE INDEX ON public.mtc_empresa
	(id_usuario_contacto);


CREATE TABLE public.mtc_razon_social (
	id_razon_social serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_razon_social)
);


CREATE TABLE public.mtc_tipo_reclamo (
	id_tipo_reclamo serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_tipo_reclamo)
);


CREATE TABLE public.mtc_usuario (
	id_usuario serial NOT NULL,
	id_perfil integer NOT NULL,
	apellido_paterno varchar(20) NOT NULL,
	apellido_materno varchar(20) NOT NULL,
	nombres varchar(30) NOT NULL,
	dni char(8) NOT NULL,
	login varchar(20) NOT NULL,
	password varchar(60) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_usuario)
);

CREATE INDEX ON public.mtc_usuario
	(id_perfil);


CREATE TABLE public.mtc_dependencia (
	id_dependencia serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_dependencia)
);


CREATE TABLE public.mtc_reclamo_respuesta (
	id_reclamo_respuesta serial NOT NULL,
	id_reclamo integer NOT NULL,
	respuesta varchar(1000) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_reclamo_respuesta)
);

CREATE INDEX ON public.mtc_reclamo_respuesta
	(id_reclamo);


CREATE TABLE public.mtc_perfil (
	id_perfil serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_perfil)
);


CREATE TABLE public.mtc_sancion (
	id_sancion serial NOT NULL,
	id_tipo_sancion integer NOT NULL,
	id_reclamo integer NOT NULL,
	descripcion varchar(1000) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_sancion)
);

CREATE INDEX ON public.mtc_sancion
	(id_tipo_sancion);
CREATE INDEX ON public.mtc_sancion
	(id_reclamo);


CREATE TABLE public.mtc_tipo_sancion (
	id_tipo_sancion serial NOT NULL,
	descripcion varchar(100) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_tipo_sancion)
);


CREATE TABLE public.mtc_notificacion (
	id_notificacion serial NOT NULL,
	id_reclamo_respuesta integer NOT NULL,
	id_estado_notificacion integer NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_notificacion)
);

CREATE INDEX ON public.mtc_notificacion
	(id_reclamo_respuesta);
CREATE INDEX ON public.mtc_notificacion
	(id_estado_notificacion);


CREATE TABLE public.mtc_estado_notificacion (
	id_estado_notificacion serial NOT NULL,
	descripcion varchar(50) NOT NULL,
	activo smallint NOT NULL,
	user_crea varchar(20) NOT NULL,
	date_crea timestamp with time zone NOT NULL,
	user_modi varchar(20),
	date_modi timestamp with time zone,
	PRIMARY KEY (id_estado_notificacion)
);


ALTER TABLE public.mtc_reclamo ADD CONSTRAINT FK_mtc_reclamo__id_estado_reclamo FOREIGN KEY (id_estado_reclamo) REFERENCES public.mtc_estado_reclamo(id_estado_reclamo);
ALTER TABLE public.mtc_reclamo ADD CONSTRAINT FK_mtc_reclamo__id_tipo_reclamo FOREIGN KEY (id_tipo_reclamo) REFERENCES public.mtc_tipo_reclamo(id_tipo_reclamo);
ALTER TABLE public.mtc_reclamo ADD CONSTRAINT FK_mtc_reclamo__id_empresa FOREIGN KEY (id_empresa) REFERENCES public.mtc_empresa(id_empresa);
ALTER TABLE public.mtc_reclamo ADD CONSTRAINT FK_mtc_reclamo__id_dependencia FOREIGN KEY (id_dependencia) REFERENCES public.mtc_dependencia(id_dependencia);
ALTER TABLE public.mtc_empresa ADD CONSTRAINT FK_mtc_empresa__id_razon_social FOREIGN KEY (id_razon_social) REFERENCES public.mtc_razon_social(id_razon_social);
ALTER TABLE public.mtc_empresa ADD CONSTRAINT FK_mtc_empresa__id_usuario_contacto FOREIGN KEY (id_usuario_contacto) REFERENCES public.mtc_usuario(id_usuario);
ALTER TABLE public.mtc_usuario ADD CONSTRAINT FK_mtc_usuario__id_perfil FOREIGN KEY (id_perfil) REFERENCES public.mtc_perfil(id_perfil);
ALTER TABLE public.mtc_reclamo_respuesta ADD CONSTRAINT FK_mtc_reclamo_respuesta__id_reclamo FOREIGN KEY (id_reclamo) REFERENCES public.mtc_reclamo(id_reclamo);
ALTER TABLE public.mtc_sancion ADD CONSTRAINT FK_mtc_sancion__id_tipo_sancion FOREIGN KEY (id_tipo_sancion) REFERENCES public.mtc_tipo_sancion(id_tipo_sancion);
ALTER TABLE public.mtc_sancion ADD CONSTRAINT FK_mtc_sancion__id_reclamo FOREIGN KEY (id_reclamo) REFERENCES public.mtc_reclamo(id_reclamo);
ALTER TABLE public.mtc_notificacion ADD CONSTRAINT FK_mtc_notificacion__id_reclamo_respuesta FOREIGN KEY (id_reclamo_respuesta) REFERENCES public.mtc_reclamo_respuesta(id_reclamo_respuesta);
ALTER TABLE public.mtc_notificacion ADD CONSTRAINT FK_mtc_notificacion__id_estado_notificacion FOREIGN KEY (id_estado_notificacion) REFERENCES public.mtc_estado_notificacion(id_estado_notificacion);