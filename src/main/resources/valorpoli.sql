-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-04-2020 a las 21:27:48
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
(1, 'Crear un servicio con Java', '2020-04-14 06:13:00', 1, 2, 'Aprenderas a crear una API REST básica y desde 0', NULL),
(2, 'Servicios REST', '2020-04-14 08:10:00', 1, 2, 'Creando un servicio rest con get', NULL);

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
(1, 'Ingeniería de Sistemas', '2020-04-14 00:00:00', 1),
(2, 'Ingeniería de Software', '2020-04-14 00:00:00', 1);

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
  `visible` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`idComentario`, `comentario`, `id_usuario`, `id_carta`, `fecha_creacion`, `visible`) VALUES
(1, 'Aqui va el comentario', 2, 2, '2020-04-14 06:24:00', 1),
(2, 'Aqui va el comentario', 2, 2, '2020-04-14 06:24:00', 1);

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
(1, 'Diseño Web', '2020-04-14 07:16:13', 1, 1, 1, 'De prueba'),
(2, 'Desarrollo de servicios con Java y Spring', '2020-04-14 08:10:00', 1, 1, 1, 'De prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `idPregunta` int(11) NOT NULL,
  `id_quiz` int(11) DEFAULT NULL,
  `tiulo` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `tipoPregunta` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`idPregunta`, `id_quiz`, `tiulo`, `tipoPregunta`) VALUES
(1, 1, 'COLOR FAVORITO', 1),
(2, 1, 'CUANTO ES 2 + 2?', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quiz`
--

CREATE TABLE `quiz` (
  `idQuiz` int(11) NOT NULL,
  `titulo` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_modulo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `quiz`
--

INSERT INTO `quiz` (`idQuiz`, `titulo`, `descripcion`, `id_modulo`) VALUES
(1, 'Prueba de quiz', 'Descripción del quiz', 2),
(2, 'Prueba de quiz 2', 'Descripción del quiz 2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `idRespuesta` int(11) NOT NULL,
  `id_pregunta` int(11) DEFAULT NULL,
  `respuesta` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `resultado` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`idRespuesta`, `id_pregunta`, `respuesta`, `resultado`) VALUES
(1, 2, '4', NULL),
(2, 1, 'NEGRO', NULL);

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
(1, 'Ingeniería de Software I', '2020-04-14 04:12:13', 1, 1),
(2, 'Telecomunicaciones', '2020-04-14 04:12:13', 1, 1);

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
  `rol` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `tipoDocumento`, `numeroDocumento`, `nombre`, `apellido`, `email`, `password`, `ocupacion`, `rol`, `descripcion`) VALUES
(1, 'CC', '1078370357', 'JORGE', 'PINZON', 'jopinzon19@poligran.edu.co', '12345678', 'Estudiante', 'Estudiante', 'Usuario de prueba para trabajar desde el Backend'),
(2, 'CC', '1251222', 'GABRIELA', 'GABRIELA', 'prueba2@prueba.com', '1234567891', 'Estudiante', 'Estudiante', 'Esto es una prueba'),
(3, 'CC', '21312312', 'WILLIAM', 'TAUTIVA', 'prueba3@prueba.com', '12345678910', 'Estudiante', 'Estudiante', 'Esto es una prueba');

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
  MODIFY `idCarta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- AUTO_INCREMENT de la tabla `modulo`
--
ALTER TABLE `modulo`
  MODIFY `idModulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `idPregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `quiz`
--
ALTER TABLE `quiz`
  MODIFY `idQuiz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `idRespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  MODIFY `id_subCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
