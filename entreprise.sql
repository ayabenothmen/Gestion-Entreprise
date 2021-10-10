-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 30 jan. 2021 à 14:56
-- Version du serveur :  10.4.16-MariaDB
-- Version de PHP : 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `entreprise`
--

-- --------------------------------------------------------

--
-- Structure de la table `bon_livraison`
--

CREATE TABLE `bon_livraison` (
  `code` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `date_bon` varchar(255) NOT NULL,
  `date_livraison` varchar(255) NOT NULL,
  `adresse_livraison` varchar(255) NOT NULL,
  `num_cmd_vente` int(11) NOT NULL,
  `ligne_bl` blob NOT NULL,
  `m_total_TVA` float NOT NULL,
  `m_total_hors_TVA` float NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bon_livraison`
--

INSERT INTO `bon_livraison` (`code`, `code_client`, `date_bon`, `date_livraison`, `adresse_livraison`, `num_cmd_vente`, `ligne_bl`, `m_total_TVA`, `m_total_hors_TVA`, `m_total_Payer`) VALUES
(661, 2, '2021-01-22', '2021-01-14', 'gbg', 1, 0x5b4c69676e655f424c205b7265663d353633332c20636f64655f636c69656e743d322c2064657369676e6174696f6e3d74656c652c20756e6974655f6d65737572653d50696563652c207174655f6c69767265653d322c2050555f686f72735f5456413d313030302e302c205456413d32302e302c20505f746f74616c5f686f72735456413d323030302e305d2c204c69676e655f424c205b7265663d353738392c20636f64655f636c69656e743d322c2064657369676e6174696f6e3d6f7264696e61746575722c20756e6974655f6d65737572653d50696563652c207174655f6c69767265653d322c2050555f686f72735f5456413d313530302e302c205456413d32302e302c20505f746f74616c5f686f72735456413d333030302e305d5d, 40, 5000, 7000),
(662, 1, '2021-01-01', '2021-01-17', 'sousse', 2, 0x5b4c69676e655f424c205b7265663d313232322c20636f64655f636c69656e743d312c2064657369676e6174696f6e3d696d7072696d616e74652c20756e6974655f6d65737572653d50696563652c207174655f6c69767265653d352c2050555f686f72735f5456413d3135302e302c205456413d33302e302c20505f746f74616c5f686f72735456413d3735302e305d2c204c69676e655f424c205b7265663d35363538352c20636f64655f636c69656e743d312c2064657369676e6174696f6e3d74656c652c20756e6974655f6d65737572653d50696563652c207174655f6c69767265653d362c2050555f686f72735f5456413d313030302e302c205456413d32302e302c20505f746f74616c5f686f72735456413d363030302e305d5d, 50, 6750, 10125);

-- --------------------------------------------------------

--
-- Structure de la table `bon_reception`
--

CREATE TABLE `bon_reception` (
  `code` int(11) NOT NULL,
  `code_fournisseur` int(11) NOT NULL,
  `date_bon` varchar(255) NOT NULL,
  `date_reception` varchar(255) NOT NULL,
  `adresse_reception` varchar(255) NOT NULL,
  `num_cmd_achat` int(11) NOT NULL,
  `ligne_br` blob NOT NULL,
  `m_total_TVA` float NOT NULL,
  `m_total_hors_TVA` float NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bon_reception`
--

INSERT INTO `bon_reception` (`code`, `code_fournisseur`, `date_bon`, `date_reception`, `adresse_reception`, `num_cmd_achat`, `ligne_br`, `m_total_TVA`, `m_total_hors_TVA`, `m_total_Payer`) VALUES
(15526, 2222, '2021-01-09', '2021-01-22', 'ghj', 1, 0x5b4d6f64656c2e4c69676e655f42524031333064613065372c204d6f64656c2e4c69676e655f42524037613339353162645d, 40, 270, 378),
(15527, 30000, '2021-01-16', '2021-01-15', 'dfg', 2, 0x5b4d6f64656c2e4c69676e655f42524031373833393063635d, 20, 80, 96);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `code` int(11) NOT NULL,
  `matricule_fiscale` varchar(255) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `compte_bancaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `num_tlf_fixe` int(11) NOT NULL,
  `num_tlf_mobile` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `site_web` varchar(255) NOT NULL,
  `etat_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`code`, `matricule_fiscale`, `raison_sociale`, `type`, `description`, `compte_bancaire`, `adresse`, `num_tlf_fixe`, `num_tlf_mobile`, `fax`, `email`, `site_web`, `etat_fiscale`) VALUES
(1, 'sdf145', 'Mariem', 'morale', 'vente tele', 'uib/sousse/125478', 'khnis/khnis/khnis/2585/monastir/tunis', 73600100, 98200100, 73600101, 'mariem@gmail', 'www.mmm', 'valider'),
(2, 'aetgyhj', 'sdfghj', 'morale', 'aaaa', 'uib/mahdia/125478', 'fghjkl/fgthyjuk/fghj/2585/erty/erftgyhu', 525268, 5888, 586565, 'sdfgh', 'defrgthy', 'ghjkl'),
(4, 'sdf145', 'sarra', 'morale', 'vente tele', 'uib/sousse/125478', 'khnis/khnis/khnis/2585/monastir/tunis', 73600100, 98200100, 73600101, 'mariem@gmail', 'www.mmm', 'valider');

-- --------------------------------------------------------

--
-- Structure de la table `compte_bancaire`
--

CREATE TABLE `compte_bancaire` (
  `id` int(11) NOT NULL,
  `nom_banque` varchar(255) NOT NULL,
  `agence` varchar(255) NOT NULL,
  `Rib` int(11) NOT NULL,
  `code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

CREATE TABLE `devis` (
  `code` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `code_client` int(11) NOT NULL,
  `ligne_devis` blob NOT NULL,
  `m_total_TVA` float NOT NULL,
  `m_total_hors_TVA` float NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `devis`
--

INSERT INTO `devis` (`code`, `date`, `code_client`, `ligne_devis`, `m_total_TVA`, `m_total_hors_TVA`, `m_total_Payer`) VALUES
(4, '2021-01-16', 2, 0x5b4c69676e655f6465766973205b7265663d313233342c20636f64655f636c69656e743d322c2064657369676e6174696f6e3d74656c652c20756e6974655f6d65737572653d50696563652c207174655f726563657074696f6e6e65653d322c2050555f686f72735f5456413d313030302e302c205456415f6170706c69717565653d32302e302c20505f746f74616c5f686f72735456413d323030302e305d5d, 20, 2000, 2400),
(5, '2021-01-10', 1, 0x5b4c69676e655f6465766973205b7265663d323331342c20636f64655f636c69656e743d312c2064657369676e6174696f6e3d6f7264696e61746575722c20756e6974655f6d65737572653d50696563652c207174655f726563657074696f6e6e65653d332c2050555f686f72735f5456413d313530302e302c205456415f6170706c69717565653d32302e302c20505f746f74616c5f686f72735456413d343530302e305d2c204c69676e655f6465766973205b7265663d343436352c20636f64655f636c69656e743d312c2064657369676e6174696f6e3d74656c652c20756e6974655f6d65737572653d50696563652c207174655f726563657074696f6e6e65653d332c2050555f686f72735f5456413d313030302e302c205456415f6170706c69717565653d32302e302c20505f746f74616c5f686f72735456413d333030302e305d5d, 40, 7500, 10500);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `matricule_fiscale` varchar(255) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description_activite` varchar(255) NOT NULL,
  `compte_bancaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `num_tel_fixe` int(11) NOT NULL,
  `num_tel_mobile` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `site_web` varchar(255) NOT NULL,
  `etat_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`matricule_fiscale`, `raison_sociale`, `type`, `description_activite`, `compte_bancaire`, `adresse`, `num_tel_fixe`, `num_tel_mobile`, `fax`, `email`, `site_web`, `etat_fiscale`) VALUES
('1456hr555', 'info_service', 'physique', 'site web ', 'uib/sousse/1456789', 'habib bourgiba /vvvvv/sousse/4100/sousse/tunis', 73200100, 98500100, 73500100, 'fgh', 'www.info.tn', 'cv');

-- --------------------------------------------------------

--
-- Structure de la table `facture_avoir`
--

CREATE TABLE `facture_avoir` (
  `code` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `date_facture` varchar(255) NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `code_facture_client` int(11) NOT NULL,
  `qte_retour` int(11) NOT NULL,
  `desig_prod` varchar(255) NOT NULL,
  `MTPayer` float NOT NULL,
  `MRetour` float NOT NULL,
  `MAR` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture_avoir`
--

INSERT INTO `facture_avoir` (`code`, `code_client`, `date_facture`, `mode_payement`, `code_facture_client`, `qte_retour`, `desig_prod`, `MTPayer`, `MRetour`, `MAR`) VALUES
(125, 2, '2021-01-17', 'cheque', 766, 1, 'ordinateur', 7000, 1800, 5200),
(12585, 2, '2021-01-17', 'virement', 766, 2, 'ordinateur', 7000, 3300, 3700);

-- --------------------------------------------------------

--
-- Structure de la table `facture_client`
--

CREATE TABLE `facture_client` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `client` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_de_payement` varchar(255) NOT NULL,
  `facture_client_BL` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_client_bl`
--

CREATE TABLE `facture_client_bl` (
  `code` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `date_facture` varchar(255) NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `code_bonlivr` int(11) NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture_client_bl`
--

INSERT INTO `facture_client_bl` (`code`, `code_client`, `date_facture`, `mode_payement`, `type_facture`, `code_bonlivr`, `m_total_Payer`) VALUES
(124, 1, '2021-01-16', 'espece', 'F.F.BL', 662, 10125),
(766, 2, '2021-01-17', 'cheque', 'F.F.BL', 661, 7000);

-- --------------------------------------------------------

--
-- Structure de la table `facture_client_libre`
--

CREATE TABLE `facture_client_libre` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `client` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_livrée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fournisseur`
--

CREATE TABLE `facture_fournisseur` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fournisseur_bl`
--

CREATE TABLE `facture_fournisseur_bl` (
  `code` int(11) NOT NULL,
  `code_fournisseur` int(11) NOT NULL,
  `date_facture` varchar(255) NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `code_bon_recep` int(11) NOT NULL,
  `m_total_Payer` float NOT NULL,
  `m_Payer` float NOT NULL,
  `m_Reste` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture_fournisseur_bl`
--

INSERT INTO `facture_fournisseur_bl` (`code`, `code_fournisseur`, `date_facture`, `mode_payement`, `type_facture`, `code_bon_recep`, `m_total_Payer`, `m_Payer`, `m_Reste`) VALUES
(1254, 30000, '2021-01-10', 'cheque', 'F.F.BL', 15527, 96, 50, 46);

-- --------------------------------------------------------

--
-- Structure de la table `facture_fournisseur_libre`
--

CREATE TABLE `facture_fournisseur_libre` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_receptionnée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `code` int(11) NOT NULL,
  `matricule_fiscale` varchar(255) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `compte_bancaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `num_tlf_fixe` int(11) NOT NULL,
  `num_tlf_mobile` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `site_web` varchar(255) NOT NULL,
  `etat_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`code`, `matricule_fiscale`, `raison_sociale`, `type`, `description`, `compte_bancaire`, `adresse`, `num_tlf_fixe`, `num_tlf_mobile`, `fax`, `email`, `site_web`, `etat_fiscale`) VALUES
(3, '263hjjk', 'sami', 'morale', 'vente tele', 'bna/sousse/1245', 'ss/ss/sousse/5000/hammem sousse/tunis', 73222111, 22300100, 73222111, 'sami@gmail', 'www.ami', 'valider'),
(2222, 'dfgh', 'mohamed', 'morale', 'laaa', 'frgthnj,/dfrgth/15656', 'dfgh/dfgh/fghn/5555/dfghnj/dfgbhn', 147896, 7822, 4652, 'fghjk', 'ghjkl', 'hjkl'),
(30000, 'dfgh', 'salah', 'physique', 'laaa', 'frgthnj,/dfrgth/0', 'dfgh/dfgh/fghn/5555/dfghnj/dfgbhn', 147896, 685, 4652, 'fghjk', 'ghjkl', 'hjkl');

-- --------------------------------------------------------

--
-- Structure de la table `ligne_bl`
--

CREATE TABLE `ligne_bl` (
  `ref` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `qte_livree` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_bl`
--

INSERT INTO `ligne_bl` (`ref`, `code_client`, `designation`, `unite_mesure`, `qte_livree`, `PU_hors_TVA`, `TVA`, `P_total_horsTVA`) VALUES
(1222, 1, 'imprimante', 'Piece', 5, 150, 30, 750),
(5633, 2, 'tele', 'Piece', 2, 1000, 20, 2000),
(5789, 2, 'ordinateur', 'Piece', 2, 1500, 20, 3000),
(56585, 1, 'tele', 'Piece', 6, 1000, 20, 6000);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_br`
--

CREATE TABLE `ligne_br` (
  `ref` int(11) NOT NULL,
  `code_fournisseur` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `qte_receptionnee` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_br`
--

INSERT INTO `ligne_br` (`ref`, `code_fournisseur`, `designation`, `unite_mesure`, `qte_receptionnee`, `PU_hors_TVA`, `TVA`, `P_total_horsTVA`) VALUES
(1456, 30000, 'table', 'Piece', 2, 300, 20, 600),
(1545, 30000, 'ordinateur', 'Piece', 4, 1500, 20, 6000),
(145689, 2222, 'ordinateur', 'Piece', 3, 1500, 20, 4500);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_devis`
--

CREATE TABLE `ligne_devis` (
  `ref` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `qte_receptionnee` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquee` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_devis`
--

INSERT INTO `ligne_devis` (`ref`, `code_client`, `designation`, `unite_mesure`, `qte_receptionnee`, `PU_hors_TVA`, `TVA_appliquee`, `P_total_horsTVA`) VALUES
(1234, 2, 'tele', 'Piece', 2, 1000, 20, 2000),
(2314, 1, 'ordinateur', 'Piece', 3, 1500, 20, 4500),
(4465, 1, 'tele', 'Piece', 3, 1000, 20, 3000);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_facture_client`
--

CREATE TABLE `ligne_facture_client` (
  `id` int(11) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_livrée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_facture_fournisseur`
--

CREATE TABLE `ligne_facture_fournisseur` (
  `id` int(11) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_receptionnée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_facture_produit_rendu`
--

CREATE TABLE `ligne_facture_produit_rendu` (
  `id` int(11) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_retour` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `code` int(11) NOT NULL,
  `ref` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `famille_produit` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `stock_min` int(11) NOT NULL,
  `PU_hors_taxe` int(11) NOT NULL,
  `TVA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`code`, `ref`, `designation`, `unite_mesure`, `fournisseur`, `famille_produit`, `stock`, `stock_min`, `PU_hors_taxe`, `TVA`) VALUES
(1234, '145re56', 'ordinateur', 'Piece', 'mohamed', '1457/electronique', 533, 10, 1500, 20),
(4145, '25858', 'tele', 'Piece', 'salah', '5478/tv', 110, 6, 1000, 20),
(4782, '145re11', 'table', 'Piece', 'salah', '1458/meuble', 5, 6, 300, 20),
(14558, '56dh478', 'imprimante', 'Piece', 'salah', '124/elctronique', 493, 8, 150, 30);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bon_livraison`
--
ALTER TABLE `bon_livraison`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `bon_reception`
--
ALTER TABLE `bon_reception`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `devis`
--
ALTER TABLE `devis`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`matricule_fiscale`);

--
-- Index pour la table `facture_avoir`
--
ALTER TABLE `facture_avoir`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `facture_client`
--
ALTER TABLE `facture_client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture_client_bl`
--
ALTER TABLE `facture_client_bl`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `facture_client_libre`
--
ALTER TABLE `facture_client_libre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture_fournisseur`
--
ALTER TABLE `facture_fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture_fournisseur_bl`
--
ALTER TABLE `facture_fournisseur_bl`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `facture_fournisseur_libre`
--
ALTER TABLE `facture_fournisseur_libre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `ligne_bl`
--
ALTER TABLE `ligne_bl`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `ligne_br`
--
ALTER TABLE `ligne_br`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `ligne_devis`
--
ALTER TABLE `ligne_devis`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ligne_facture_fournisseur`
--
ALTER TABLE `ligne_facture_fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ligne_facture_produit_rendu`
--
ALTER TABLE `ligne_facture_produit_rendu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bon_livraison`
--
ALTER TABLE `bon_livraison`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=663;

--
-- AUTO_INCREMENT pour la table `bon_reception`
--
ALTER TABLE `bon_reception`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15528;

--
-- AUTO_INCREMENT pour la table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `devis`
--
ALTER TABLE `devis`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `facture_avoir`
--
ALTER TABLE `facture_avoir`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144759;

--
-- AUTO_INCREMENT pour la table `facture_client`
--
ALTER TABLE `facture_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_client_bl`
--
ALTER TABLE `facture_client_bl`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=767;

--
-- AUTO_INCREMENT pour la table `facture_client_libre`
--
ALTER TABLE `facture_client_libre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_fournisseur`
--
ALTER TABLE `facture_fournisseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_fournisseur_bl`
--
ALTER TABLE `facture_fournisseur_bl`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1255;

--
-- AUTO_INCREMENT pour la table `facture_fournisseur_libre`
--
ALTER TABLE `facture_fournisseur_libre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_bl`
--
ALTER TABLE `ligne_bl`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56586;

--
-- AUTO_INCREMENT pour la table `ligne_br`
--
ALTER TABLE `ligne_br`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145690;

--
-- AUTO_INCREMENT pour la table `ligne_devis`
--
ALTER TABLE `ligne_devis`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14533;

--
-- AUTO_INCREMENT pour la table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_facture_fournisseur`
--
ALTER TABLE `ligne_facture_fournisseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_facture_produit_rendu`
--
ALTER TABLE `ligne_facture_produit_rendu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42544;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
