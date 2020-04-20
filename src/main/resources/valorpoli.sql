-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-04-2020 a las 19:33:46
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `valorpoli`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carta_aprendizaje`
--

CREATE TABLE `carta_aprendizaje` (
  `idCarta` int(11) NOT NULL,
  `titulo` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `visible` int(1) DEFAULT NULL,
  `idModulo` int(11) DEFAULT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `imagen` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carta_aprendizaje`
--

INSERT INTO `carta_aprendizaje` (`idCarta`, `titulo`, `fechaCreacion`, `visible`, `idModulo`, `descripcion`, `imagen`) VALUES
(1, 'Introducción a los limites', '2020-04-17 06:00:00', 1, 1, 'Aquí va el contenido que se muestra en la carta', 'Imagen de la carta'),
(2, 'Limites intermedios', '2020-04-17 00:00:00', 1, 1, 'Aquí va el contenido que se muestra en la carta', 'Imagen de la carta'),
(3, 'Introducción a la pastelería', '2020-04-29 00:00:00', 1, 4, 'Aquí va el contenido que se muestra en la carta', 'Imagen de la carta'),
(5, 'Nuestro primer pan', '2020-04-17 06:03:00', 1, 5, 'Aquí va el contenido que se muestra en la carta', 'Imagen de la carta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `titulo` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `visible` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `titulo`, `fechaCreacion`, `visible`) VALUES
(1, 'Matemáicas', '2020-04-17 08:00:15', 1),
(2, 'Cocina', '2020-04-16 09:00:45', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `idComentario` int(11) NOT NULL,
  `comentario` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_carta` int(11) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `visible` int(1) DEFAULT NULL COMMENT 'Si es 1 es visible el comentario'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`idComentario`, `comentario`, `id_usuario`, `id_carta`, `fecha_creacion`, `visible`) VALUES
(1, 'Es un excelente contenido', 1, 5, '2020-04-17 06:18:00', 1),
(2, 'Siento que hace falta profundizar más sobre los ingredientes', 3, 5, '2020-04-18 08:22:14', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_modulo`
--

CREATE TABLE `detalle_modulo` (
  `idDetalle_Modulo` int(11) NOT NULL,
  `id_modulo` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle_modulo`
--

INSERT INTO `detalle_modulo` (`idDetalle_Modulo`, `id_modulo`, `id_usuario`, `id_rol`) VALUES
(1, 5, 1, 1),
(2, 5, 3, 1),
(3, 4, 1, 1),
(4, 4, 3, 1),
(5, 1, 2, 1),
(6, 1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `intento_usuario`
--

CREATE TABLE `intento_usuario` (
  `idIntento_usuario` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_pregunta` int(11) DEFAULT NULL,
  `int_respuesta_user` int(11) DEFAULT NULL,
  `correcta` int(11) DEFAULT NULL COMMENT 'A través de un SP se llena este campo según el id de la respuesta',
  `respuesta_abierta` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Se utiliza para almacenar las respuestas del usuario  a las preguntas abiertas.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `intento_usuario`
--

INSERT INTO `intento_usuario` (`idIntento_usuario`, `id_usuario`, `id_pregunta`, `int_respuesta_user`, `correcta`, `respuesta_abierta`) VALUES
(1, 1, 1, 8, 1, NULL),
(2, 1, 1, 9, 1, NULL),
(3, 1, 2, 4, 1, NULL),
(4, 1, 2, 5, 1, NULL),
(5, 1, 2, 7, 0, NULL),
(6, 1, 3, 2, 0, NULL),
(7, 1, 4, NULL, NULL, 'Me parece un excelente campo de trabajo.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE `modulo` (
  `idModulo` int(11) NOT NULL,
  `titulo` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `visible` int(1) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_subCategoria` int(11) DEFAULT NULL,
  `tipoContenido` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`idModulo`, `titulo`, `fechaCreacion`, `visible`, `id_usuario`, `id_subCategoria`, `tipoContenido`) VALUES
(1, 'Limites', '2020-04-17 06:03:00', 1, 1, 4, 'Matemáticas básicas'),
(2, 'Funciones algoritmicas', '2020-04-17 06:03:00', 1, 1, 4, 'Matemáticas básicas'),
(3, 'Matemáticas intermedias', '2020-04-18 06:03:00', 1, 1, 3, 'Matemáticas intermedias'),
(4, 'Introducción a las fresas con cremas', '2020-04-23 00:00:00', 1, 2, 1, 'Panadería y reposteria'),
(5, 'Como hacer un croissant', '2020-04-17 04:20:00', 1, 2, 1, 'Panadería y reposteria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `idPregunta` int(11) NOT NULL,
  `id_quiz` int(11) DEFAULT NULL,
  `tiulo` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `tipoPregunta` int(1) NOT NULL COMMENT 'Si es 0 es cerrada y 1 es abierta'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`idPregunta`, `id_quiz`, `tiulo`, `tipoPregunta`) VALUES
(1, 1, '¿Que ingredientes tiene un croissant?', 0),
(2, 1, '¿Cual de la siguientes es la masa ideal para un croissant?', 0),
(3, 1, '¿El croissant es originario de?', 0),
(4, 1, '¿Que piensa acerca de la reposteria?', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quiz`
--

CREATE TABLE `quiz` (
  `idQuiz` int(11) NOT NULL,
  `titulo` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_modulo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `quiz`
--

INSERT INTO `quiz` (`idQuiz`, `titulo`, `descripcion`, `id_modulo`) VALUES
(1, 'Quiz croissant', 'El siguiente cuestionario es para confirmar las lecciones aprendidas', 5),
(2, 'Quiz de fresas', 'En este quiz reforzaras conceptos de como preparar unas ricas Fresas con crema', 4),
(3, 'Quiz fresas 2', 'Quiz de refuerzo para preparar fresas', 4),
(4, 'Quiz fresas 3', 'Quiz de refuerzo para preparar fresas 2', 4),
(5, 'Lección para limites', 'Aplicar los conceptos aprendidos en el modulo de limites', 1),
(6, 'Lección para limites 2', 'Aplicar los conceptos aprendidos en el modulo de limites', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `idRespuesta` int(11) NOT NULL,
  `id_pregunta` int(11) DEFAULT NULL,
  `respuesta` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `correcta` int(1) DEFAULT NULL COMMENT 'Si es 1 es correcta'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`idRespuesta`, `id_pregunta`, `respuesta`, `correcta`) VALUES
(1, 3, 'Italia', 1),
(2, 3, 'España', 0),
(3, 3, 'Colombia', 0),
(4, 2, 'Arina', 1),
(5, 2, 'Agua', 1),
(6, 2, 'Huevo', 1),
(7, 2, 'Carne de cerdo', 0),
(8, 1, 'Piña', 1),
(9, 1, 'Salchicha', 1),
(10, 1, 'Chorizo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombreRol` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `visible` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`, `descripcion`, `visible`) VALUES
(1, 'Estudiante', 'Estudiante que hace parte de la institución POLI', 1),
(2, 'Administrativo', 'Funcionario o colaborador de la institución POLI', 1),
(3, 'Usuario externo', 'Persona que no tiene vinculo con la institución POLI ', 1),
(4, 'Prfesor', 'Colaborador de la institución POLI', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sub_categoria`
--

CREATE TABLE `sub_categoria` (
  `id_subCategoria` int(11) NOT NULL,
  `titulo` varchar(70) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `visible` int(1) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sub_categoria`
--

INSERT INTO `sub_categoria` (`id_subCategoria`, `titulo`, `fechaCreacion`, `visible`, `id_categoria`) VALUES
(1, 'Reposteria', '2020-04-17 05:15:01', 1, 2),
(2, 'Cocina de mar', '2020-04-17 06:03:00', 1, 2),
(3, 'Calculo Integral', '2020-04-17 06:03:00', 1, 1),
(4, 'Calculo Diferencial', '2020-04-17 06:03:00', 1, 1),
(5, 'Precalculo', '2020-04-17 06:03:00', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `tipoDocumento` varchar(3) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `numeroDocumento` varchar(11) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(42) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ocupacion` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `imagenPerfil` varchar(75) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `tipoDocumento`, `numeroDocumento`, `nombre`, `apellido`, `email`, `password`, `ocupacion`, `descripcion`, `imagenPerfil`) VALUES
(1, 'CC', '1078370357', 'Jorge', 'Pinzon', 'jopinzon19@poligran.edu.co', '123456789', 'Prueba de insertar base de datos', 'Estudiante de prueba con notas muy malas.', '../imagenes/perfil.png'),
(2, 'CC', '12254111', 'Gabriela', 'Samper', 'prueba@gmail.com', '1234567890', 'Estudiante', 'Prueba estudiante', NULL),
(3, 'CC', '21541', 'William', 'Tautiva', 'prueba2@gmail.com', '987654321', 'Estudiante', NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carta_aprendizaje`
--
ALTER TABLE `carta_aprendizaje`
  ADD PRIMARY KEY (`idCarta`),
  ADD KEY `fx_carta_x_modulo_idx` (`idModulo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idComentario`),
  ADD KEY `fx_comentario_x_usuario_idx` (`id_usuario`),
  ADD KEY `fx_comentario_x_carta_idx` (`id_carta`);

--
-- Indices de la tabla `detalle_modulo`
--
ALTER TABLE `detalle_modulo`
  ADD PRIMARY KEY (`idDetalle_Modulo`),
  ADD KEY `fk_detalle_rol_idx` (`id_rol`),
  ADD KEY `fk_detalle_modulo_idx` (`id_modulo`),
  ADD KEY `fk_detalle_usuario_idx` (`id_usuario`);

--
-- Indices de la tabla `intento_usuario`
--
ALTER TABLE `intento_usuario`
  ADD PRIMARY KEY (`idIntento_usuario`),
  ADD KEY `fk_intento_pregunta_idx` (`id_pregunta`),
  ADD KEY `fk_intento_usuario_idx` (`id_usuario`);

--
-- Indices de la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`idModulo`),
  ADD KEY `fk_usuario_x_modulo_idx` (`id_usuario`),
  ADD KEY `fk_subCategoria_x_modulo_idx` (`id_subCategoria`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`idPregunta`),
  ADD KEY `fx_pregunta_x_quiz_idx` (`id_quiz`);

--
-- Indices de la tabla `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`idQuiz`),
  ADD KEY `fk_quiz_x_modulo_idx` (`id_modulo`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`idRespuesta`),
  ADD KEY `fk_respuesta_x_pregunta_idx` (`id_pregunta`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  ADD PRIMARY KEY (`id_subCategoria`),
  ADD KEY `fk_categoria_x_subcategoria_idx` (`id_categoria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `password_UNIQUE` (`password`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD UNIQUE KEY `numeroDocumento_UNIQUE` (`numeroDocumento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carta_aprendizaje`
--
ALTER TABLE `carta_aprendizaje`
  MODIFY `idCarta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `idComentario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_modulo`
--
ALTER TABLE `detalle_modulo`
  MODIFY `idDetalle_Modulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `intento_usuario`
--
ALTER TABLE `intento_usuario`
  MODIFY `idIntento_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `modulo`
--
ALTER TABLE `modulo`
  MODIFY `idModulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `idPregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `quiz`
--
ALTER TABLE `quiz`
  MODIFY `idQuiz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `idRespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  MODIFY `id_subCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carta_aprendizaje`
--
ALTER TABLE `carta_aprendizaje`
  ADD CONSTRAINT `fx_carta_x_modulo` FOREIGN KEY (`idModulo`) REFERENCES `modulo` (`idModulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `fx_comentario_x_carta` FOREIGN KEY (`id_carta`) REFERENCES `carta_aprendizaje` (`idCarta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fx_comentario_x_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_modulo`
--
ALTER TABLE `detalle_modulo`
  ADD CONSTRAINT `fk_detalle_modulo` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`idModulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_detalle_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_detalle_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `intento_usuario`
--
ALTER TABLE `intento_usuario`
  ADD CONSTRAINT `fk_intento_pregunta` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`idPregunta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_intento_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD CONSTRAINT `fk_subCategoria_x_modulo` FOREIGN KEY (`id_subCategoria`) REFERENCES `sub_categoria` (`id_subCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_x_modulo` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `fx_pregunta_x_quiz` FOREIGN KEY (`id_quiz`) REFERENCES `quiz` (`idQuiz`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `fk_quiz_x_modulo` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`idModulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `fk_respuesta_x_pregunta` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`idPregunta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  ADD CONSTRAINT `fk_categoria_x_subcategoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
