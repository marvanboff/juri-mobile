--------------------------------------------------------
--  arquivo criado - quarta-feira-abril-29-2015   
--------------------------------------------------------
--------------------------------------------------------
--  ddl for table advogado
--------------------------------------------------------

  create table advogado 
   (	_id integer primary key autoincrement, 
	nome text, 
	numero_oab text, 
	data_ult_atualizacao text
   ) ;

--------------------------------------------------------
--  ddl for table complemento_movimento
--------------------------------------------------------

  create table complemento_movimento 
   (	_id integer primary key autoincrement, 
	cod_movimento_cnj integer references movimentos_cnj(cod_movimento), 
	glossario text
   ) ;

--------------------------------------------------------
--  ddl for table grupo
--------------------------------------------------------

  create table grupo 
   (	_id integer primary key autoincrement, 
	data_ult_atualizacao text, 
	nome text
   ) ;

--------------------------------------------------------
--  ddl for table usuario
--------------------------------------------------------

  create table usuario 
   (	_id integer primary key autoincrement, 
	data_ult_atualizacao text, 
	nome text, 
	login text
   ) ;
   
--------------------------------------------------------
--  ddl for table processo
--------------------------------------------------------

  create table processo 
   (	_id integer primary key autoincrement, 
	assunto text, 
	comarca text, 
	data_distribuicao text, 
	data_ult_atualizacao text, 
	numero text, 
	orgao_julgador text, 
	situacao text, 
	id_usuario integer references usuario(_id)
   ) ;
   
--------------------------------------------------------
--  ddl for table grupo_processo
--------------------------------------------------------

  create table grupo_processo 
   (	_id integer primary key autoincrement, 
	data_ult_atualizacao text, 
	id_grupo integer references grupo(_id), 
	id_processo integer references processo(_id)
   ) ;

--------------------------------------------------------
--  ddl for table processo_movimento
--------------------------------------------------------

  create table processo_movimento 
   (	_id integer primary key autoincrement, 
	data_movimentacao text, 
	data_ult_atualizacao text, 
	descricao text, 
	id_processo integer references processo(_id)
   ) ;

--------------------------------------------------------
--  ddl for table processo_participante
--------------------------------------------------------

  create table processo_participante 
   (	_id integer primary key autoincrement, 
	data_ult_atualizacao text, 
	nome text, 
	tipo_participacao text, 
	tipo_participante text, 
	id_processo integer references processo(_id)
   ) ;

--------------------------------------------------------
--  ddl for table processo_participante_advogado
--------------------------------------------------------

  create table processo_participante_advogado 
   (	_id integer primary key autoincrement, 
	data_ult_atualizacao text, 
	id_participante integer references processo_participante(_id), 
	id_advogado integer references advogado(_id)
   ) ;

--------------------------------------------------------
--  ddl for index sys_c007110
--------------------------------------------------------

  create unique index sys_c007110 on advogado (_id) 
  ;

--------------------------------------------------------
--  ddl for index complemento_movimento_pk
--------------------------------------------------------

  create unique index complemento_movimento_pk on complemento_movimento (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007078
--------------------------------------------------------

  create unique index sys_c007078 on grupo (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007080
--------------------------------------------------------

  create unique index sys_c007080 on grupo_processo (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007085
--------------------------------------------------------

  create unique index sys_c007085 on processo (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007091
--------------------------------------------------------

  create unique index sys_c007091 on processo_movimento (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007096
--------------------------------------------------------

  create unique index sys_c007096 on processo_participante (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007102
--------------------------------------------------------

  create unique index sys_c007102 on usuario (_id) 
  ;

--------------------------------------------------------
--  ddl for index sys_c007098
--------------------------------------------------------

  create unique index sys_c007098 on processo_participante_advogado (_id) 
  ;

--------------------------------------------------------
--  constraints for table advogado
--------------------------------------------------------