-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 16, 2025 alle 02:36
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.0.30

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
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `nome`, `cognome`, `username`, `password`) VALUES
(1, '2', '2', '2', 'c81e728d9d4c2f636f067f89cc14862c');

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

--
-- Dump dei dati per la tabella `buono_di_consegna`
--

INSERT INTO `buono_di_consegna` (`id`, `id_polizza`, `id_cliente`, `peso_riferito`, `data_emissione`) VALUES
(22, 2, 1, 87.00, '2025-05-16'),
(23, 5, 1, 2.00, '2025-05-16'),
(24, 5, 1, 1.00, '2025-05-16');

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
  `cognome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `azienda` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cognome`, `email`, `username`, `password`, `azienda`) VALUES
(1, '1', '1', '1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '1'),
(2, '1', '2', '2@hg', 'tre', 'c4ca4238a0b923820dcc509a6f75849b', '1'),
(3, 'rahil', '2', '2@hg', '2', 'e77dbaf6759253c7c6d0efc5690369c7', '1'),
(4, '2', '32', '423@g', '4234', 'faa9afea49ef2ff029a833cccc778fd0', ''),
(6, '22', '32', '321@312', '22', 'b6d767d2f8ed5d21a44b0e5886680cb9', '2'),
(7, '22', '2222', 'rahilkumar2006@gmail.com', '77', '15de21c670ae7c3f6f3f1f37029303c9', '5');

-- --------------------------------------------------------

--
-- Struttura della tabella `conducente`
--

CREATE TABLE `conducente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `conducente`
--

INSERT INTO `conducente` (`id`, `nome`, `cognome`, `username`, `password`, `email`) VALUES
(1, '3', '3', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '3');

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `azienda` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `fornitore`
--

INSERT INTO `fornitore` (`id`, `nome`, `cognome`, `azienda`, `username`, `password`, `email`) VALUES
(1, '4', '4', '4', '4', 'a87ff679a2f3e71d9181a67b7542122c', '4'),
(5, 'rahil', 'kumar', 'fsdf', '5', 'e4da3b7fbbce2345d7772b0674a318d5', 'rahil@2006');

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
-- Struttura della tabella `linea`
--

CREATE TABLE `linea` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `linea`
--

INSERT INTO `linea` (`id`, `nome`) VALUES
(2, 'ciao'),
(3, 'gfhfg'),
(4, 'd');

-- --------------------------------------------------------

--
-- Struttura della tabella `merce`
--

CREATE TABLE `merce` (
  `id` int(11) NOT NULL,
  `tipologia` varchar(100) NOT NULL,
  `idFornitore` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `merce`
--

INSERT INTO `merce` (`id`, `tipologia`, `idFornitore`) VALUES
(8, '3rewq', 5),
(9, 'fsd', 1),
(10, 'x<z', 1),
(11, 'das', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `nave`
--

INSERT INTO `nave` (`id`, `nome`) VALUES
(3, '12'),
(4, '2'),
(5, '3'),
(7, '3123'),
(8, '111');

-- --------------------------------------------------------

--
-- Struttura della tabella `polizzacarico`
--

CREATE TABLE `polizzacarico` (
  `id` int(11) NOT NULL,
  `id_viaggio` int(11) NOT NULL,
  `id_fornitore` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `tipologia_merce` int(11) NOT NULL,
  `peso_totale` decimal(10,2) NOT NULL,
  `giorni_franchigia` int(11) NOT NULL,
  `tariffa_giornaliera` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `polizzacarico`
--

INSERT INTO `polizzacarico` (`id`, `id_viaggio`, `id_fornitore`, `id_cliente`, `tipologia_merce`, `peso_totale`, `giorni_franchigia`, `tariffa_giornaliera`) VALUES
(1, 16, 1, 2, 9, 2.00, 2, 2.00),
(2, 16, 1, 1, 10, 111.00, 11, 111.00),
(3, 18, 1, 1, 9, 2222.00, 22, 22.00),
(4, 16, 1, 1, 9, 33333.00, 22, 22.00),
(5, 16, 1, 1, 9, 11.00, 11, 11.00);

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `id` int(11) NOT NULL,
  `nome_porto` varchar(100) NOT NULL,
  `nazione` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `porto`
--

INSERT INTO `porto` (`id`, `nome_porto`, `nazione`) VALUES
(12, 'br', 'brasile'),
(13, 'ing', 'inghilterra');

-- --------------------------------------------------------

--
-- Struttura della tabella `richiesta_buono`
--

CREATE TABLE `richiesta_buono` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_polizza` int(11) NOT NULL,
  `peso_richiesto` decimal(10,2) NOT NULL,
  `data_richiesta` datetime NOT NULL DEFAULT current_timestamp(),
  `stato` enum('in attesa','approvata','rifiutata') NOT NULL DEFAULT 'in attesa'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `richiesta_buono`
--

INSERT INTO `richiesta_buono` (`id`, `id_cliente`, `id_polizza`, `peso_richiesto`, `data_richiesta`, `stato`) VALUES
(1, 1, 2, 22.00, '2025-05-15 00:00:00', 'approvata'),
(2, 1, 2, 2222.00, '2025-05-15 00:00:00', 'rifiutata'),
(3, 1, 3, 22.00, '2025-05-15 00:00:00', 'approvata'),
(4, 1, 3, 33333.00, '2025-05-15 00:00:00', 'approvata'),
(5, 1, 4, 33330.00, '2025-05-15 00:00:00', 'approvata'),
(6, 1, 4, 3.00, '2025-05-15 00:00:00', 'approvata'),
(7, 1, 2, 2.00, '2025-05-16 01:27:43', 'approvata'),
(8, 1, 2, 87.00, '2025-05-16 01:39:27', 'approvata'),
(9, 1, 5, 2.00, '2025-05-16 01:44:33', 'approvata'),
(10, 1, 5, 1.00, '2025-05-16 01:54:03', 'approvata');

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
  `data_arrivo` date DEFAULT NULL,
  `linea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dump dei dati per la tabella `viaggio`
--

INSERT INTO `viaggio` (`id`, `id_nave`, `porto_partenza`, `porto_arrivo`, `data_partenza`, `data_arrivo`, `linea`) VALUES
(16, 3, 12, 13, '2025-05-13', '2025-05-30', 2),
(18, 5, 13, 12, '2025-05-23', '2025-05-15', 3),
(20, 3, 12, 12, '2025-05-16', '2025-05-30', 2),
(21, 3, 13, 12, '2025-05-16', '2025-05-23', 2),
(22, 3, 13, 12, '2025-05-16', '2025-05-25', 3);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indici per le tabelle `conducente`
--
ALTER TABLE `conducente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `username_2` (`username`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indici per le tabelle `guida`
--
ALTER TABLE `guida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_conducente` (`id_conducente`),
  ADD KEY `id_camion` (`id_camion`);

--
-- Indici per le tabelle `linea`
--
ALTER TABLE `linea`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `merce`
--
ALTER TABLE `merce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fornitore` (`idFornitore`);

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
  ADD KEY `id_fornitore` (`id_fornitore`),
  ADD KEY `tipologia_merce` (`tipologia_merce`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `richiesta_buono`
--
ALTER TABLE `richiesta_buono`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_polizza` (`id_polizza`);

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
  ADD KEY `porto_arrivo` (`porto_arrivo`),
  ADD KEY `linea` (`linea`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `buono_di_consegna`
--
ALTER TABLE `buono_di_consegna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `conducente`
--
ALTER TABLE `conducente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `fornitore`
--
ALTER TABLE `fornitore`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `guida`
--
ALTER TABLE `guida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `linea`
--
ALTER TABLE `linea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `merce`
--
ALTER TABLE `merce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT per la tabella `nave`
--
ALTER TABLE `nave`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `polizzacarico`
--
ALTER TABLE `polizzacarico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `porto`
--
ALTER TABLE `porto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT per la tabella `richiesta_buono`
--
ALTER TABLE `richiesta_buono`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `transazione`
--
ALTER TABLE `transazione`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

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
-- Limiti per la tabella `merce`
--
ALTER TABLE `merce`
  ADD CONSTRAINT `merce_ibfk_1` FOREIGN KEY (`idFornitore`) REFERENCES `fornitore` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `polizzacarico`
--
ALTER TABLE `polizzacarico`
  ADD CONSTRAINT `polizzacarico_ibfk_1` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`id`),
  ADD CONSTRAINT `polizzacarico_ibfk_2` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`),
  ADD CONSTRAINT `polizzacarico_ibfk_3` FOREIGN KEY (`tipologia_merce`) REFERENCES `merce` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `polizzacarico_ibfk_4` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `richiesta_buono`
--
ALTER TABLE `richiesta_buono`
  ADD CONSTRAINT `richiesta_buono_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `richiesta_buono_ibfk_2` FOREIGN KEY (`id_polizza`) REFERENCES `polizzacarico` (`id`);

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
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`id`),
  ADD CONSTRAINT `viaggio_ibfk_4` FOREIGN KEY (`linea`) REFERENCES `linea` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
