select * from mtc_ticket_number order by id_ticket_number;
select * from mtc_estado_reclamo;
select * from mtc_reclamo;

truncate table mtc_reclamo;
select nextval('mtc_reclamo_id_reclamo_seq');
select setval('mtc_reclamo_id_reclamo_seq',1, false);

select public.generateticket();


select generateticket(3);

select public.insert_reclamo(1, 'testing v3');