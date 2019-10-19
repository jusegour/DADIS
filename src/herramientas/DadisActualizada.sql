-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-10-2019 a las 21:30:07
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dadis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `iddoctor` int(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `fecha_nacimiento` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `estrato` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `clinica` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `doctor`
--

INSERT INTO `doctor` (`iddoctor`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `edad`, `fecha_nacimiento`, `sexo`, `direccion`, `estrato`, `telefono`, `clinica`, `usuario`, `contraseña`, `identificacion`, `idusuario`) VALUES
(3, 'Rosmery', 'U', 'Uribe', 'Ardila', '54', '2019-oct-01', 'Masculino', 'asdasdasd', '2', '3217758511', 'CLINICA MADRE BERNARDA', 'rosme', '123456', '45483917', 1),
(4, 'diego', 'armando', 'godoy', 'espinoza', '19', '2019-oct-01', 'Masculino', 'Pozon', '1	', '321456789', 'CLINICA DEL NORTE', 'diegoarm', '123456789', '123456789', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hijo`
--

CREATE TABLE `hijo` (
  `idhijo` int(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` varchar(51) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `estrato` varchar(45) NOT NULL,
  `sexo` varchar(51) NOT NULL,
  `registro_civil` varchar(20) NOT NULL,
  `idpadre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hijo`
--

INSERT INTO `hijo` (`idhijo`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `fecha_nacimiento`, `edad`, `direccion`, `estrato`, `sexo`, `registro_civil`, `idpadre`) VALUES
(3, 'rafael', 'andres', 'caro ', 'rivera', '2019-oct-02', '18', 'Pozon', '1	', 'Masculino', '123456789', 5),
(4, 'luis', 'daniel', 'ortega', 'velez', '2019-oct-01', '18', 'Las Gaviotas', '2', 'Masculino', '123456789', 2),
(5, 'Raul', 'Antonio', 'Gonzalez', 'Perez', '2001-dic-21', '4', 'Pozon', '1	', 'Masculino', '123456789', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `padre`
--

CREATE TABLE `padre` (
  `idpadre` int(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `fecha_nacimiento` varchar(45) NOT NULL,
  `estrato` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `idusuario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `padre`
--

INSERT INTO `padre` (`idpadre`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `edad`, `direccion`, `fecha_nacimiento`, `estrato`, `sexo`, `identificacion`, `email`, `usuario`, `contraseña`, `idusuario`) VALUES
(2, 'aaaaaa', 'asfasf', 'asfasf', 'asfasf', '123123', 'asfasf', 'Fri Oct 04 16:23:06 COT 2019', '2', 'Femenino', '1123123', 'jusegour2015@gmail.com', 'juanse', '123456', '2'),
(3, 'asfas', 'asfa', 'asfaasf', 'asfasf', '12', 'asfasf', '2019-oct-02', '1	', 'Masculino', '123123123', 'rafakrox@gmail.com', 'asfasf', 'asfASGA', '2'),
(4, 'fjfhjghj', 'fgfgfgjfg', 'fgjfgjfg', 'fgjfgj', '123', 'dfgdsfgsdfg', '2019-oct-01', '2', 'Masculino', '123123123', 'diegoarmand1971@gmail.com', 'dsfsdf', '123456', '2'),
(5, 'Wilder', 'Jose', 'Gomez', 'Uribe', '22', 'Barrio Pozon', '1997-may-11', '1	', 'Masculino', '123456789', 'wilderuribe52@gmail.com', 'wilder', '123456', '2'),
(6, 'asdasddsa', 'gsdgsdg', 'dfh', 'dfhf', '123', 'asdsgsg', '2019-oct-01', '2', 'Masculino', '12312312412', 'ASDsdg', 'adsffg', 'sfgsh', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_vacunas`
--

CREATE TABLE `registro_vacunas` (
  `idregistro_vacunas` int(11) NOT NULL,
  `Fecha` varchar(45) NOT NULL,
  `idhijo` int(11) NOT NULL,
  `idpadre` int(11) NOT NULL,
  `iddoctor` int(11) NOT NULL,
  `idvacuna` int(11) NOT NULL,
  `fecha_proxima` varchar(45) NOT NULL,
  `Aviso` varchar(45) NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `registro_vacunas`
--

INSERT INTO `registro_vacunas` (`idregistro_vacunas`, `Fecha`, `idhijo`, `idpadre`, `iddoctor`, `idvacuna`, `fecha_proxima`, `Aviso`) VALUES
(4, '1/9/2019', 4, 2, 3, 2, '1/9/2019', 'Si'),
(6, '1/9/2019', 5, 2, 3, 2, '15/9/2019', 'Si'),
(7, '1/5/2019', 5, 2, 3, 1, '1/6/2019', 'No'),
(9, '1/9/2019', 3, 5, 3, 2, '12/9/2019', 'Si'),
(13, '1/10/2019', 3, 5, 3, 3, '31/10/2019', 'No'),
(14, '1/12/2019', 4, 2, 3, 1, '31/12/2019', 'No');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `idtipo_usuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`idtipo_usuario`, `nombre`) VALUES
(1, 'Doctor'),
(2, 'Padre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idvacuna` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idvacuna`, `nombre`) VALUES
(1, 'DTap'),
(2, 'Hepatitis B'),
(3, 'Poliomielitis'),
(4, 'Hib'),
(5, 'Neumocócita');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`iddoctor`);

--
-- Indices de la tabla `hijo`
--
ALTER TABLE `hijo`
  ADD PRIMARY KEY (`idhijo`),
  ADD KEY `idpadre` (`idpadre`);

--
-- Indices de la tabla `padre`
--
ALTER TABLE `padre`
  ADD PRIMARY KEY (`idpadre`);

--
-- Indices de la tabla `registro_vacunas`
--
ALTER TABLE `registro_vacunas`
  ADD PRIMARY KEY (`idregistro_vacunas`),
  ADD KEY `idhijo` (`idhijo`),
  ADD KEY `idpadre` (`idpadre`),
  ADD KEY `iddoctor` (`iddoctor`),
  ADD KEY `idvacuna` (`idvacuna`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`idtipo_usuario`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idvacuna`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `doctor`
--
ALTER TABLE `doctor`
  MODIFY `iddoctor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `hijo`
--
ALTER TABLE `hijo`
  MODIFY `idhijo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `padre`
--
ALTER TABLE `padre`
  MODIFY `idpadre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `registro_vacunas`
--
ALTER TABLE `registro_vacunas`
  MODIFY `idregistro_vacunas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `idtipo_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idvacuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `hijo`
--
ALTER TABLE `hijo`
  ADD CONSTRAINT `hijo_ibfk_1` FOREIGN KEY (`idpadre`) REFERENCES `padre` (`idpadre`);

--
-- Filtros para la tabla `registro_vacunas`
--
ALTER TABLE `registro_vacunas`
  ADD CONSTRAINT `iddoctor` FOREIGN KEY (`iddoctor`) REFERENCES `doctor` (`iddoctor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idhijo` FOREIGN KEY (`idhijo`) REFERENCES `hijo` (`idhijo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idpadre` FOREIGN KEY (`idpadre`) REFERENCES `padre` (`idpadre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idvacuna` FOREIGN KEY (`idvacuna`) REFERENCES `vacuna` (`idvacuna`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
