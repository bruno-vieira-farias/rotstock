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
  (14 ,'Santo Andre Colchoes'	  )

ALTER SEQUENCE local_id_seq RESTART WITH 15;

INSERT INTO "usuario"
  (id	,email						        ,nome		    ,senha                           )
VALUES
  (1	,'gersonk@gmail.com'		  ,'Gerson'	  ,crypt('gerson'	,gen_salt('bf'))),
  (2	,'bruno@sidlar.com.br'		,'Bruno'	  ,crypt('bruno'	,gen_salt('bf'))),
  (3	,'osvaldo@sidlar.com.br'	,'Osvaldo'	,crypt('osvaldo',gen_salt('bf'))),
  (4	,'rholitiz@sidlar.com.br'	,'Rafael'	  ,crypt('rafael'	,gen_salt('bf')))
;
ALTER SEQUENCE usuario_id_seq RESTART WITH 10;