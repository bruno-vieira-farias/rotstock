INSERT INTO "local"
  (id ,nome 					          )
VALUES
  (1  ,'Matriz'				          ),
  (2  ,'Centro de Distribuição' ),
  (3  ,'Imirim'				          ),
  (4  ,'Interlagos'			        ),
  (5  ,'Osasco'				          ),
  (6  ,'Aricanduva'			        ),
  (7  ,'Central Plaza'			    ),
  (8  ,'Santo André'			      ),
  (9  ,'Lar Center'			        ),
  (10 ,'São Bernardo'			      ),
  (11 ,'São Lucas'				      ),
  (12 ,'Fernão Dias'			      ),
  (13 ,'Ponta de Estoque'		    ),
  (14 ,'Santo Andre Colchoes'	  );

ALTER TABLE local SEQUENCE local_id_seq RESTART WITH 15;

INSERT INTO "usuario"
  (id	,email						        ,nome		    ,senha                           )
VALUES
  (1	,'gersonk@gmail.com'		  ,'Gerson'	  ,crypt('gerson'	,gen_salt('bf'))),
  (2	,'bruno@sidlar.com.br'		,'Bruno'	  ,crypt('bruno'	,gen_salt('bf'))),
  (3	,'osvaldo@sidlar.com.br'	,'Osvaldo'	,crypt('osvaldo',gen_salt('bf'))),
  (4	,'rholitiz@sidlar.com.br'	,'Rafael'	  ,crypt('rafael'	,gen_salt('bf')))
;
ALTER SEQUENCE usuario_id_seq RESTART WITH 5;

INSERT INTO "equipamento"
  (id ,serial   ,fabricante ,modelo   ,is_ativo ,proprietario ,id_local  ,discriminator ,processador ,memoria ,hd     ,colorida ,tipo_impressora   ,polegadas  ,tipo_conexao ,sem_fio  ,ip)
VALUES
  (1  ,'SID01'  ,'STI'      ,'CS-1047',TRUE  ,'VIVO'       ,1         ,'Computador'  ,'Intel i5'  ,'8GB'   ,'500GB',NULL     ,NULL              ,NULL       ,NULL         ,NULL     ,NULL),
  (2  ,'SID02'  ,'STI'      ,'CS-1047',TRUE  ,'VIVO'       ,2         ,'Computador'  ,'Intel i5'  ,'8GB'   ,'500GB',NULL     ,NULL              ,NULL       ,NULL         ,NULL     ,NULL),
  (3  ,'SID03'  ,'HP'       ,'1505n'  ,TRUE  ,'SIDLAR'     ,3         ,'Impressora'  ,NULL        ,NULL    ,NULL   ,FALSE    ,'LASER'           ,NULL       ,NULL         ,NULL     ,NULL),
  (4  ,'SID04'  ,'HP'       ,'1605n'  ,TRUE  ,'SIDLAR'     ,4         ,'Impressora'  ,NULL        ,NULL    ,NULL   ,FALSE    ,'LASER'           ,NULL       ,NULL         ,NULL     ,NULL),
  (5  ,'SID05'  ,'EPSON'    ,'C87'    ,TRUE  ,'SIDLAR'     ,5         ,'Impressora'  ,NULL        ,NULL    ,NULL   ,TRUE     ,'JATO_TINTA'      ,NULL       ,NULL         ,NULL     ,NULL),
  (6  ,'SID06'  ,'ELGIN'    ,'BGXTZ'  ,TRUE  ,'SIDLAR'     ,6         ,'Impressora'  ,NULL        ,NULL    ,NULL   ,FALSE    ,'MATRICIAL_CHEQUE',NULL       ,NULL         ,NULL     ,NULL),
  (7  ,'SID07'  ,'SANSUNG'  ,'SYNCB'  ,TRUE  ,'SIDLAR'     ,7          ,'Monitor'     ,NULL        ,NULL    ,NULL   ,NULL     ,NULL              ,'QUINZE'   ,NULL         ,NULL     ,NULL)
;
ALTER SEQUENCE equipamento_id_seq RESTART WITH 15;
