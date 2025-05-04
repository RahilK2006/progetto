-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 04, 2025 alle 13:57
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `progetto`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `buono_di_consegna`
--

CREATE TABLE `buono_di_consegna` (
  `id` int(11) NOT NULL,
  `id_polizza` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `peso_riferito` decimal(10,2) NOT NULL,
  `data_emissione` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `conducente`
--

CREATE TABLE `conducente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `guida`
--

CREATE TABLE `guida` (
  `id` int(11) NOT NULL,
  `id_conducente` int(11) NOT NULL,
  `id_camion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `polizzacarico`
--

CREATE TABLE `polizzacarico` (
  `id` int(11) NOT NULL,
  `id_viaggio` int(11) NOT NULL,
  `id_fornitore` int(11) NOT NULL,
  `tipologia_merce` varchar(100) NOT NULL,
  `peso_totale` decimal(10,2) NOT NULL,
  `giorni_franchigia` decimal(12,2) NOT NULL,
  `tariffa_giornaliera` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `id` int(11) NOT NULL,
  `nome_porto` varchar(100) NOT NULL,
  `nazione` varchar(100) NOT NULL,
  `linea` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `transazione`
--

CREATE TABLE `transazione` (
  `id` int(11) NOT NULL,
  `id_polizza` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `importo` decimal(12,2) NOT NULL,
  `data_ora_pagamento` datetime NOT NULL,
  `metodo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `id` int(11) NOT NULL,
  `id_nave` int(11) NOT NULL,
  `porto_partenza` int(11) NOT NULL,
  `porto_arrivo` int(11) NOT NULL,
  `data_partenza` date NOT NULL,
  `data_arrivo` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_polizza` (`id_polizza`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `conducente`
--
ALTER TABLE `conducente`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `guida`
--
ALTER TABLE `guida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_conducente` (`id_conducente`),
  ADD KEY `id_camion` (`id_camion`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `polizzacarico`
--
ALTER TABLE `polizzacarico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_viaggio` (`id_viaggio`),
  ADD KEY `id_fornitore` (`id_fornitore`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `transazione`
--
ALTER TABLE `transazione`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_polizza` (`id_polizza`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_nave` (`id_nave`),
  ADD KEY `porto_partenza` (`porto_partenza`),
  ADD KEY `porto_arrivo` (`porto_arrivo`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  ADD CONSTRAINT `buono_di_consegna_ibfk_1` FOREIGN KEY (`id_polizza`) REFERENCES `polizzacarico` (`id`),
  ADD CONSTRAINT `buono_di_consegna_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

--
-- Limiti per la tabella `guida`
--
ALTER TABLE `guida`
  ADD CONSTRAINT `guida_ibfk_1` FOREIGN KEY (`id_conducente`) REFERENCES `conducente` (`id`),
  ADD CONSTRAINT `guida_ibfk_2` FOREIGN KEY (`id_camion`) REFERENCES `camion` (`targa`);

--
-- Limiti per la tabella `polizzacarico`
--
ALTER TABLE `polizzacarico`
  ADD CONSTRAINT `polizzacarico_ibfk_1` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`id`),
  ADD CONSTRAINT `polizzacarico_ibfk_2` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`);

--
-- Limiti per la tabella `transazione`
--
ALTER TABLE `transazione`
  ADD CONSTRAINT `transazione_ibfk_1` FOREIGN KEY (`id_polizza`) REFERENCES `polizzacarico` (`id`),
  ADD CONSTRAINT `transazione_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`id_nave`) REFERENCES `nave` (`id`),
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`porto_partenza`) REFERENCES `porto` (`id`),
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
