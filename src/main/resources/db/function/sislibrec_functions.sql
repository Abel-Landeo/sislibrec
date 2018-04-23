create or replace function public.generateticket(p_id_ticket_number integer)
returns varchar 
AS $function$ 
declare
	p_prefix varchar(50);
	p_number integer;
	p_ticket varchar(50);
begin
	lock table mtc_ticket_number in access exclusive mode;
	select prefix, number into p_prefix, p_number from mtc_ticket_number where id_ticket_number = p_id_ticket_number;
	p_number := p_number + 1;
	p_ticket := p_prefix || to_char(p_number, 'fm000000000');
	update mtc_ticket_number set number = p_number where id_ticket_number = p_id_ticket_number;
	return p_ticket;	
end;
$function$ LANGUAGE plpgsql;


create or replace function public.insert_reclamo(p_id_estado_reclamo integer, p_descripcion varchar)
returns varchar 
AS $function$ 
declare
	p_ticket varchar(50);
begin
	p_ticket := generateticket(3);
	INSERT INTO public.mtc_reclamo(id_estado_reclamo, descripcion, ticket, "date", "version", activo, user_crea, date_crea)
	VALUES(p_id_estado_reclamo, p_descripcion, p_ticket, now(), 0, 1, 'function', now());
	return 'OK';
end;
$function$ LANGUAGE plpgsql;
