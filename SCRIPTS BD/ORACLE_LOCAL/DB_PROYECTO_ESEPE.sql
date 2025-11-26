DROP TABLE usuario;
DROP TABLE TARJETA_GRAFICA;


create table usuario (
    id_user NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1 CONSTRAINT pk_id_user PRIMARY KEY,
    user_name VARCHAR2(20) CONSTRAINT nn_user_name NOT NULL CONSTRAINT un_user_name UNIQUE,
    pass VARCHAR2(20) CONSTRAINT nn_password_usuario NOT NULL,
    rol_tipo_usuario VARCHAR2(10) DEFAULT 'vendedor' CONSTRAINT ck_valor_tipo_usuario CHECK (valor_tipo_usuario IN('administrador', 'bodeguero', 'vendedor'))
    
);

create table MARCA (
    id_marca NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY,
    nombre_marca VARCHAR2(10) CONSTRAINT nn_nombre_marca NOT NULL CONSTRAINT un_nombre_marca UNIQUE
);


create table TARJETA_GRAFICA (
    codigo NUMBER CONSTRAINT pk_codigo_TARJETA_GRAFICA PRIMARY KEY CONSTRAINT ck_codigo_TARJETA_GRAFICA CHECK (codigo > 0),
    nombre VARCHAR2(20) CONSTRAINT nn_nombre_TARJETA_GRAFICA NOT NULL,
    cantidad NUMBER CONSTRAINT nn_cantidad_TARJETA_GRAFICA NOT NULL CONSTRAINT ck_cantidad_TARJETA_GRAFICA CHECK (cantidad > 0),
    estado CHAR(1) DEFAULT 'N' CONSTRAINT ck_estado_TARJETA_GRAFICA CHECK (estado IN('N', 'U', 'R')),
    id_marca VARCHAR2(20) CONSTRAINT nn_marca_TARJETA_GRAFICA NOT NULL CONSTRAINT ck_marca_TARJETA_GRAFICA CHECK (marca != 'NO SELECCIONADO')
    
);

INSERT INTO usuario (user_name, pass) VALUES ('admin', 'admin25');

COMMIT;
