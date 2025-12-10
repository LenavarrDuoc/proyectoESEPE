--DROP TABLE marca;
DROP TABLE TARJETA_GRAFICA;

--DROP SEQUENCE seq_id_user; //Se implementó como default en la tabla usuario para generar id_user, pero si bien se generaba un valor en secuencia, currVal y nextVal revelaban que seguía en 1. Hay conflictos de secuencias aunque se hayan borrado y creado nuevamente.
--También se implentó fuera de la tabla, agregando el valor en el insert con id_user.nextval. Mismo problema.
DROP TABLE usuario CASCADE CONSTRAINTS;

--CREATE SEQUENCE seq_id_user;
create table usuario (
    id_user NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_name VARCHAR2(20) CONSTRAINT nn_user_name NOT NULL CONSTRAINT un_user_name UNIQUE,
    pass VARCHAR2(20) CONSTRAINT nn_password_usuario NOT NULL,
    rol VARCHAR2(20)  DEFAULT 'REPORTE' CONSTRAINT ck_rol_usuario CHECK (rol IN('REPORTE', 'INVENTARIO', 'ADMIN')),
    fec_reg DATE DEFAULT SYSDATE --Nuevo catributo a implementar para llevar registro de creación y modificación de usuarios.
);




--create table MARCA (
--    id_marca NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY,
--    nombre_marca VARCHAR2(10) CONSTRAINT nn_nombre_marca NOT NULL CONSTRAINT un_nombre_marca UNIQUE
--);


create table TARJETA_GRAFICA (
    codigo NUMBER CONSTRAINT pk_codigo_TARJETA_GRAFICA PRIMARY KEY CONSTRAINT ck_codigo_TARJETA_GRAFICA CHECK (codigo > 0),
    nombre VARCHAR2(20) CONSTRAINT nn_nombre_TARJETA_GRAFICA NOT NULL,
    cantidad NUMBER CONSTRAINT nn_cantidad_TARJETA_GRAFICA NOT NULL CONSTRAINT ck_cantidad_TARJETA_GRAFICA CHECK (cantidad > 0),
    estado CHAR(1) DEFAULT 'N' CONSTRAINT ck_estado_TARJETA_GRAFICA CHECK (estado IN('N', 'U', 'R')),
    marca VARCHAR2(20) CONSTRAINT nn_marca_TARJETA_GRAFICA NOT NULL CONSTRAINT ck_marca_TARJETA_GRAFICA CHECK (marca != 'NO SELECCIONADO')
    
);


INSERT INTO usuario (user_name, pass, rol) VALUES ('admin', 'admin25', 'ADMIN');
INSERT INTO usuario (user_name, pass, rol) VALUES ('Margarita', 'Cuchito1+', 'REPORTE');
COMMIT;

SELECT id_user AS ID, user_name AS NOMBRE, rol AS ROL, pass AS PASSWRD, FEC_REG as FECHA_REGISTRO FROM usuario ORDER BY id_user;
--SELECT data_default FROM user_tab_columns WHERE table_name = 'USUARIO' AND column_name = 'ID_USER';



--SELECT seq_id_user.CURRVAL FROM dual;
--SELECT seq_id_user.NEXTVAL FROM dual;
--SELECT sequence_name, last_number FROM user_sequences ORDER BY sequence_name;
--SELECT sequence_owner, sequence_name, last_number FROM all_sequences WHERE sequence_name = 'SEQ_ID_USER';
--SELECT column_name, identity_options FROM user_tab_identity_cols WHERE table_name = 'USUARIO';

