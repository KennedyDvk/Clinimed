-- Gerado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   em:        2023-03-06 17:14:13 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE tb_consulta (
    id_consulta             NUMBER NOT NULL,
    tb_paciente_id_paciente NUMBER NOT NULL,
    tb_medico_id_medico     NUMBER NOT NULL,
    dt_hora                 TIMESTAMP(3) NOT NULL,
    ds_sintomas             VARCHAR2(100) NOT NULL,
    ds_diagnostico          VARCHAR2(100) NOT NULL,
    ds_prescricoes          VARCHAR2(100) NOT NULL,
    vl_consulta             NUMBER NOT NULL
);

ALTER TABLE tb_consulta ADD CONSTRAINT tb_consulta_pk PRIMARY KEY ( id_consulta );

CREATE TABLE tb_exame (
    id_exame                NUMBER NOT NULL,
    ds_exame                VARCHAR2(100) NOT NULL,
    nm_paciente             VARCHAR2(100) NOT NULL,
    tb_paciente_id_paciente NUMBER NOT NULL,
    dt_hora_ex              TIMESTAMP(3) NOT NULL,
    tb_medico_id_medico     NUMBER NOT NULL
);

ALTER TABLE tb_exame ADD CONSTRAINT tb_exame_pk PRIMARY KEY ( id_exame );

CREATE TABLE tb_internacao (
    id_internacao           NUMBER NOT NULL,
    dt_inicio               TIMESTAMP NOT NULL,
    dt_fim                  TIMESTAMP NOT NULL,
    ds_quarto               VARCHAR2(20) NOT NULL,
    tb_consulta_id_consulta NUMBER NOT NULL
);

ALTER TABLE tb_internacao ADD CONSTRAINT tb_internacao_pk PRIMARY KEY ( id_internacao );

CREATE TABLE tb_medico (
    id_medico        NUMBER NOT NULL,
    nm_medico        VARCHAR2(100) NOT NULL,
    nr_cpf           VARCHAR2(100) NOT NULL,
    ds_email         VARCHAR2(100) NOT NULL,
    nr_telefone      NUMBER(14) NOT NULL,
    ds_especialidade VARCHAR2(100) NOT NULL
);

ALTER TABLE tb_medico ADD CONSTRAINT tb_medico_pk PRIMARY KEY ( id_medico );

CREATE TABLE tb_paciente (
    id_paciente   NUMBER NOT NULL,
    nm_paciente   VARCHAR2(100) NOT NULL,
    nr_cpf        VARCHAR2(11) NOT NULL,
    nr_telefone   VARCHAR2(14) NOT NULL,
    ds_endereco   VARCHAR2(100) NOT NULL,
    dt_nascimento DATE NOT NULL
);

ALTER TABLE tb_paciente ADD CONSTRAINT tb_paciente_pk PRIMARY KEY ( id_paciente );

ALTER TABLE tb_consulta
    ADD CONSTRAINT tb_consulta_tb_medico_fk FOREIGN KEY ( tb_medico_id_medico )
        REFERENCES tb_medico ( id_medico );

ALTER TABLE tb_consulta
    ADD CONSTRAINT tb_consulta_tb_paciente_fk FOREIGN KEY ( tb_paciente_id_paciente )
        REFERENCES tb_paciente ( id_paciente );

ALTER TABLE tb_exame
    ADD CONSTRAINT tb_exame_tb_medico_fk FOREIGN KEY ( tb_medico_id_medico )
        REFERENCES tb_medico ( id_medico );

ALTER TABLE tb_exame
    ADD CONSTRAINT tb_exame_tb_paciente_fk FOREIGN KEY ( tb_paciente_id_paciente )
        REFERENCES tb_paciente ( id_paciente );

ALTER TABLE tb_internacao
    ADD CONSTRAINT tb_internacao_tb_consulta_fk FOREIGN KEY ( tb_consulta_id_consulta )
        REFERENCES tb_consulta ( id_consulta );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             10
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
