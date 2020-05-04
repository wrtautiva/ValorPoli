INSERT INTO categoria (id_categoria, estado, fecha_creacion, titulo) VALUES
(1, 0, '2020-05-03 04:30:53', 'TITULO CATEGORIA');

INSERT INTO sub_categoria (id_sub_categoria, categoria_id_categoria, estado, fecha_creacion, titulo) VALUES
(1, 1, 0, '2020-05-03 04:31:05', 'TITULO SUB CATEGORIA');

INSERT INTO usuario (id_usuario, apellido, descripcion, email, estado, imagen_perfil, nombre, numero_documento, ocupacion, password, tipo_documento) VALUES
(1, 'Juarez', 'Soy el mejor en todo lo que hago', 'pepiJuate@gmail.com', 0, 'yo.jpg', 'Pepito', '123456789', 'Dormir', '123', 0),
(2, 'Pinzon', 'Bla bla bla', 'jopinzon19@poligran.edu.co', 0, 'yo.jpg', 'Jorge', '1078370357', 'Dormir', '123', 0);

INSERT INTO modulo (id_modulo, estado, fecha_creacion, sub_categoria_id_sub_categoria, tipo_contenido, titulo, usuario_id_usuario) VALUES (1, 0, '2020-05-02- 07:57:16', 1, 'No se para que es este campo', 'Prueba mi modulo', 1);

INSERT INTO quiz (id_quiz, descripcion, estado, modulo_id_modulo, titulo) VALUES
(1, 'Este es un quiz de prueba', 0, 1, 'Quiz de reposteria'),
(2, 'Este es un quiz de prueba', 0, 1, 'Quiz de política');

INSERT INTO pregunta (id_pregunta, quiz_id_quiz, tipo_pregunta, titulo) VALUES
(1, 2, 0, '¿Cual es el país más corrupto?');

INSERT INTO respuesta (id_respuesta, correcta, pregunta_id_pregunta, respuesta) VALUES
(1, 2, 1, 'COLOMBIA'),
(2, 3, 1, 'IRÁN'),
(3, 3, 1, 'ECUADOR'),
(4, 3, 1, 'VENEZUELA');

INSERT INTO intento_usuario (id_intento_usuario, correcta, fecha_respuesta, pregunta_id_pregunta, respuesta_abierta, usuario_id_usuario, respuesta_idrespuesta) VALUES
(1, 3, '2020-05-03 04:31:05', 1, 'Campo para el texto que él usuario ingresa para las preguntas abiertas', 1, 2),
(2, 2, '2020-05-03 04:31:05', 1, 'Campo para el texto que él usuario ingresa para las preguntas abiertas', 1, 1),
(3, 2, '2020-05-03 04:31:05', 1, 'Campo para el texto que él usuario ingresa para las preguntas abiertas', 2, 1),
(4, 3, '2020-05-03 04:31:05', 1, 'Campo para el texto que él usuario ingresa para las preguntas abiertas', 2, 3),
(5, 3, '2020-05-03 04:31:05', 1, NULL, 2, 2),
(6, 3, '2020-05-03 04:31:05', 1, NULL, 2, 4);