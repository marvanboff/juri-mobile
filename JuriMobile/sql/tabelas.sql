--------------------------------------------------------
--  Arquivo criado - Quarta-feira-Abril-29-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADVOGADO
--------------------------------------------------------

  CREATE TABLE ADVOGADO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	NOME TEXT, 
	NUMERO_OAB TEXT, 
	DATA_ULT_ATUALIZACAO TEXT
   ) ;

--------------------------------------------------------
--  DDL for Table COMPLEMENTO_MOVIMENTO
--------------------------------------------------------

  CREATE TABLE COMPLEMENTO_MOVIMENTO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	COD_MOVIMENTO_CNJ INTEGER REFERENCES MOVIMENTOS_CNJ(COD_MOVIMENTO), 
	GLOSSARIO TEXT
   ) ;

--------------------------------------------------------
--  DDL for Table GRUPO
--------------------------------------------------------

  CREATE TABLE GRUPO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	NOME TEXT
   ) ;

--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE USUARIO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	NOME TEXT, 
	LOGIN TEXT
   ) ;
   
--------------------------------------------------------
--  DDL for Table PROCESSO
--------------------------------------------------------

  CREATE TABLE PROCESSO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	ASSUNTO TEXT, 
	COMARCA TEXT, 
	DATA_DISTRIBUICAO TEXT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	NUMERO TEXT, 
	ORGAO_JULGADOR TEXT, 
	SITUACAO TEXT, 
	ID_USUARIO INTEGER REFERENCES USUARIO(ID)
   ) ;
   
--------------------------------------------------------
--  DDL for Table GRUPO_PROCESSO
--------------------------------------------------------

  CREATE TABLE GRUPO_PROCESSO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	ID_GRUPO INTEGER REFERENCES GRUPO(ID), 
	ID_PROCESSO INTEGER REFERENCES PROCESSO(ID)
   ) ;

--------------------------------------------------------
--  DDL for Table PROCESSO_MOVIMENTO
--------------------------------------------------------

  CREATE TABLE PROCESSO_MOVIMENTO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	DATA_MOVIMENTACAO TEXT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	DESCRICAO TEXT, 
	ID_PROCESSO INTEGER REFERENCES PROCESSO(ID)
   ) ;

--------------------------------------------------------
--  DDL for Table PROCESSO_PARTICIPANTE
--------------------------------------------------------

  CREATE TABLE PROCESSO_PARTICIPANTE 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	NOME TEXT, 
	TIPO_PARTICIPACAO TEXT, 
	TIPO_PARTICIPANTE TEXT, 
	ID_PROCESSO INTEGER REFERENCES PROCESSO(ID)
   ) ;

--------------------------------------------------------
--  DDL for Table PROCESSO_PARTICIPANTE_ADVOGADO
--------------------------------------------------------

  CREATE TABLE PROCESSO_PARTICIPANTE_ADVOGADO 
   (	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	DATA_ULT_ATUALIZACAO TEXT, 
	ID_PARTICIPANTE INTEGER REFERENCES PROCESSO_PARTICIPANTE(ID), 
	ID_ADVOGADO INTEGER REFERENCES ADVOGADO(ID)
   ) ;

--------------------------------------------------------
--  DDL for Index SYS_C007110
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007110 ON ADVOGADO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index COMPLEMENTO_MOVIMENTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX COMPLEMENTO_MOVIMENTO_PK ON COMPLEMENTO_MOVIMENTO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007078
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007078 ON GRUPO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007080
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007080 ON GRUPO_PROCESSO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007085
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007085 ON PROCESSO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007091
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007091 ON PROCESSO_MOVIMENTO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007096
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007096 ON PROCESSO_PARTICIPANTE (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007102
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007102 ON USUARIO (ID) 
  ;

--------------------------------------------------------
--  DDL for Index SYS_C007098
--------------------------------------------------------

  CREATE UNIQUE INDEX SYS_C007098 ON PROCESSO_PARTICIPANTE_ADVOGADO (ID) 
  ;

--------------------------------------------------------
--  Constraints for Table ADVOGADO
--------------------------------------------------------