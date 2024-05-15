
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`departamento` (
  `iddepartamento` INT NOT NULL auto_increment,
  `codDepartamento` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `idJefe` INT NOT NULL,
  PRIMARY KEY (`iddepartamento`),
  UNIQUE INDEX `codDepartamento_UNIQUE` (`codDepartamento` ASC) VISIBLE,
  UNIQUE INDEX `idJefe_UNIQUE` (`idJefe` ASC) VISIBLE,
  CONSTRAINT `idJefe`
    FOREIGN KEY (`idJefe`)
    REFERENCES `mydb`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Profesor` (
  `idProfesor` INT NOT NULL auto_increment,
  `nombre` VARCHAR(33) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `DNI` VARCHAR(9) NOT NULL,
  `perfilAcceso` ENUM('SUPERUSUARIO','ADMINISTRADOR','EQUIPO_DIRECTIVO','PROFESOR') NOT NULL,
  `fk_departamento` VARCHAR(30) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `activo` TINYINT NOT NULL,
  `contraseña` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE,
  CONSTRAINT `fk_departamento`
    FOREIGN KEY (`fk_departamento`)
    REFERENCES `mydb`.`departamento` (`codDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`curso` (
  `idcurso` INT NOT NULL auto_increment,
  `codcurso` VARCHAR(10) NOT NULL,
  `descripcion` VARCHAR(60) NOT NULL,
  `etapa` ENUM('ESO','BACHILLERATO','FPGS','FPGM','FPB','FPCE') NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`idcurso`),
  UNIQUE INDEX `codcurso_UNIQUE` (`codcurso` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`grupoAlumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`grupoAlumnos` (
  `codGrupo` VARCHAR(10) NOT NULL,
  `fk_curso` INT NOT NULL,
  `numAlumnos` VARCHAR(45) NOT NULL,
  `activo` TINYINT NOT NULL,
  `idGrupo` INT NOT NULL auto_increment,
  PRIMARY KEY (`idGrupo`),
  CONSTRAINT `fk_curso`
    FOREIGN KEY (`fk_curso`)
    REFERENCES `mydb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Solicitud` (
  `idActividad` INT NOT NULL auto_increment,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `comentarios` VARCHAR(50) NULL,
  `prevista` TINYINT NOT NULL,
  `Departamento` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `tipo` ENUM('EXTRAESCOLAR','COMPLEMENTARIA') NOT NULL,
  `profesor` INT NOT NULL,
  `alojamiento` TINYINT NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFinal` DATE NOT NULL,
  `totalParticipantes` INT NOT NULL,
  `estado` ENUM('SOLICITADA','APROBADA','DENEGADA','REALIZADA') NOT NULL,
  PRIMARY KEY (`idActividad`),
  UNIQUE INDEX `profesor_UNIQUE` (`profesor` ASC) VISIBLE,
  UNIQUE INDEX `Departamento_UNIQUE` (`Departamento` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ActividadProgramada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ActividadProgramada` (
  `idActividadProgramada` INT NOT NULL,
  `estado` ENUM('SOLICITADA','APROBADA','DENEGADA','REALIZADA') NOT NULL,
  `comentario` VARCHAR(45) NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `prevista` TINYINT NOT NULL,
  `Departamento` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `tipo` ENUM('EXTRAESCOLAR','COMPLEMENTARIA') NOT NULL,
  `medioTransporte` TINYINT NOT NULL,
  `profesor` INT NOT NULL,
  `alojamiento` TINYINT NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFinal` DATE NOT NULL,
  `comenAlojamiento` VARCHAR(45) NULL,
  `totalParticipantes` VARCHAR(45) NOT NULL,
  `comenRealizada` VARCHAR(45) NULL,
  PRIMARY KEY (`idActividadProgramada`),
  UNIQUE INDEX `fk_Departamento_UNIQUE` (`Departamento` ASC) VISIBLE,
  UNIQUE INDEX `profesor_UNIQUE` (`profesor` ASC) VISIBLE,
  CONSTRAINT `idActividadProgramada`
    FOREIGN KEY (`idActividadProgramada`)
    REFERENCES `mydb`.`Solicitud` (`idActividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FotoActividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FotoActividad` (
  `url` VARCHAR(45) NOT NULL,
  `descripción` VARCHAR(45) NOT NULL,
  `idFoto` INT NOT NULL,
  `fk_idActividad` INT NOT NULL,
  PRIMARY KEY (`idFoto`),
  UNIQUE INDEX `fk_idActividad_UNIQUE` (`fk_idActividad` ASC) VISIBLE,
  CONSTRAINT `idActividad3`
    FOREIGN KEY (`fk_idActividad`)
    REFERENCES `mydb`.`ActividadProgramada` (`idActividadProgramada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MedioTransporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MedioTransporte` (
  `idTransporte` INT NOT NULL,
  `tipo` ENUM('ANDANDO','BICI','BUS','TAXI','TREN','BARCO','AVION') NOT NULL,
  PRIMARY KEY (`idTransporte`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CursoParticipa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CursoParticipa` (
  `fk_idCurso` INT NOT NULL,
  `fk_idActividad2` INT NOT NULL,
  `Numparticipantes` INT NOT NULL,
  INDEX `fk_idActividad_idx` (`fk_idActividad2` ASC) VISIBLE,
  UNIQUE INDEX `fk_idActividad_UNIQUE` (`fk_idActividad2` ASC) VISIBLE,
  UNIQUE INDEX `fk_idCurso_UNIQUE` (`fk_idCurso` ASC) VISIBLE,
  PRIMARY KEY (`fk_idCurso`, `fk_idActividad2`),
  CONSTRAINT `idActividad2`
    FOREIGN KEY (`fk_idActividad2`)
    REFERENCES `mydb`.`Solicitud` (`idActividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idCurso`
    FOREIGN KEY (`fk_idCurso`)
    REFERENCES `mydb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`GrupoParticipa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`GrupoParticipa` (
  `fk_idGrupo` INT NOT NULL,
  `fk_idActividad` INT NOT NULL,
  `Numparticipantes` INT NOT NULL,
  UNIQUE INDEX `fk_idGrupo_UNIQUE` (`fk_idGrupo` ASC) VISIBLE,
  UNIQUE INDEX `fk_idActividad_UNIQUE` (`fk_idActividad` ASC) VISIBLE,
  PRIMARY KEY (`fk_idGrupo`, `fk_idActividad`),
  CONSTRAINT `fk_idGrupo`
    FOREIGN KEY (`fk_idGrupo`)
    REFERENCES `mydb`.`grupoAlumnos` (`idGrupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idActividad1`
    FOREIGN KEY (`fk_idActividad`)
    REFERENCES `mydb`.`Solicitud` (`idActividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ProfesorSolicita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ProfesorSolicita` (
  `rol` ENUM('SUPERUSUARIO','ADMINISTRADOR','EQUIPO DIRECTIVO','PROFESOR') NOT NULL,
  `fk_idProfesor` INT NOT NULL,
  `fk_idActividad` INT NOT NULL,
  UNIQUE INDEX `fk_idProfesor_UNIQUE` (`fk_idProfesor` ASC) VISIBLE,
  UNIQUE INDEX `fk_idActividad_UNIQUE` (`fk_idActividad` ASC) VISIBLE,
  PRIMARY KEY (`fk_idProfesor`, `fk_idActividad`),
  CONSTRAINT `fk_idProfesor`
    FOREIGN KEY (`fk_idProfesor`)
    REFERENCES `mydb`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idActividad4`
    FOREIGN KEY (`fk_idActividad`)
    REFERENCES `mydb`.`Solicitud` (`idActividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MedioTransporteUtiliza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MedioTransporteUtiliza` (
  `kilometros` DOUBLE NOT NULL,
  `fk_transporte` INT NOT NULL,
  `fk_actividad` INT NOT NULL,
  `importe` DOUBLE NOT NULL,
  `comentario` VARCHAR(45) NULL,
  UNIQUE INDEX `fk_transporte_UNIQUE` (`fk_transporte` ASC) VISIBLE,
  UNIQUE INDEX `fk_actividad_UNIQUE` (`fk_actividad` ASC) VISIBLE,
  PRIMARY KEY (`fk_transporte`, `fk_actividad`),
  CONSTRAINT `fk_transporte`
    FOREIGN KEY (`fk_transporte`)
    REFERENCES `mydb`.`MedioTransporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad`
    FOREIGN KEY (`fk_actividad`)
    REFERENCES `mydb`.`ActividadProgramada` (`idActividadProgramada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
