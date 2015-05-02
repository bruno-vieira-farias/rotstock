INSERT INTO "local"
  (id ,nome 					          ,logradouro       														                        ,cep 		      ,cidade					        ,estado)
VALUES
  (1  ,'Matriz'				          ,'Av. do Oratorio,4339'													                      ,'03221-200'  ,'Sao Paulo'		    	  ,'SP'),
  (2  ,'Centro de Distribuição' ,'Estrada Velha de Bragança,5311 / Estrada Estadual,5301 – Galpão 01' ,'07600-000'  ,'Mairiporã'	    		  ,'SP'),
  (3  ,'Imirim'				          ,'Av. Imirim,1419'														                        ,'02465-100'  ,'Sao Paulo'    			  ,'SP'),
  (4  ,'Interlagos'			        ,'Av. Interlagos,2225 Loja 128'											                  ,'04661-100'  ,'São Paulo'  			    ,'SP'),
  (5  ,'Osasco'				          ,'Av. Autonomistas,3183'												                      ,'06090-015'  ,'Osasco'				        ,'SP'),
  (6  ,'Aricanduva'			        ,'Av. Aricanduva, 5555 Loja 106/10'										                ,'03527-000'  ,'São Paulo'			      ,'SP'),
  (7  ,'Central Plaza'			    ,'Av. Francisco Mesquita,1000'											                  ,'03152-001'  ,'São Paulo'			      ,'SP'),
  (8  ,'Santo André'			      ,'Av. Industrial,600 Loja 209/210'										                ,'09080-500'  ,'Santo Andre'	  		  ,'SP'),
  (9  ,'Lar Center'			        ,'Av. Otto Baumgart,500 Loja 344'										                  ,'02049-000'  ,'São Paulo'			      ,'SP'),
  (10 ,'São Bernardo'			      ,'Rua Jurubatuba,369'													                        ,'09725-630'  ,'São Bernardo do Campo','SP'),
  (11 ,'São Lucas'				      ,'Av.do Oratório,2817/2825'												                    ,'03221-100'  ,'São Paulo'			      ,'SP'),
  (12 ,'Fernão Dias'			      ,'Rod. Fernão Dias, Km 68'												                    ,'07600-000'  ,'Mairiporã'			      ,'SP'),
  (13 ,'Ponta de Estoque'		    ,'Rua Coronel Jose da Silva Neto,85'									                ,'03238-010'  ,'São Paulo'			      ,'SP'),
  (14 ,'Santo Andre Colchoes'	  ,'Av. Industrial,600'													                        ,'09080-500'  ,'Santo Andre'			    ,'SP')

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