/* 
 * Copyright (C) 2018 abels
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * Author:  abels
 * Created: 31.01.2018
 */
-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: 192.168.99.100    Database: wmtipp
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:01' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Tabellenstruktur für Tabelle `community`
--

CREATE TABLE `community` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `autogenerate_matches` bit(1) NOT NULL,
  `autorelease_rounds` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `score_correct_tip` bigint(20) NOT NULL,
  `score_correct_trend` bigint(20) NOT NULL,
  `score_correct_winner` bigint(20) NOT NULL,
  `shortname` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `competition`
--

CREATE TABLE `competition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `externalId` varchar(255) DEFAULT NULL,
  `flags_path` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `points_draw` bigint(20) NOT NULL,
  `points_win` bigint(20) NOT NULL,
  `shortname` varchar(255) NOT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `community_competition`
--

CREATE TABLE `community_competition` (
  `COMMUNITY_ID` bigint(20) NOT NULL,
  `COMPETITION_ID` bigint(20) NOT NULL,
  KEY `FK_community_id` (`COMPETITION_ID`),
  KEY `FK_competition_id` (`COMMUNITY_ID`),
  CONSTRAINT `FK_community_id` FOREIGN KEY (`COMMUNITY_ID`) REFERENCES `community` (`id`),
  CONSTRAINT `FK_competition_id` FOREIGN KEY (`COMPETITION_ID`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `community_fk` bigint(20),
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_community_fk` FOREIGN KEY (`COMMUNITY_FK`) REFERENCES `community` (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `message_read` bit(1) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `recipient` bigint(20) DEFAULT NULL,
  `sender` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_message_recipient` (`recipient`),
  KEY `FK_message_sender` (`sender`),
  CONSTRAINT `FK_message_recipient` FOREIGN KEY (`recipient`) REFERENCES `player` (`id`),
  CONSTRAINT `FK_message_sender` FOREIGN KEY (`sender`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_group`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `competition_fk` bigint(20),
  `name` varchar(255) NOT NULL,
  `sort_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_team_competition` (`competition_fk`),
  CONSTRAINT `FK_team_competition` FOREIGN KEY (`competition_fk`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goal_difference` int(11) DEFAULT NULL,
  `goals_conceeded` int(11) DEFAULT NULL,
  `goals_scored` int(11) DEFAULT NULL,
  `IS_NULL` bit(1) NOT NULL,
  `matches_finished` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `t_state` int(11) DEFAULT NULL,
  `t_won` bit(1) NOT NULL,
  `url_flag_image` varchar(255) DEFAULT NULL,
  `url_info` varchar(255) DEFAULT NULL,
  `group_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_team_group` (`group_fk`),
  CONSTRAINT `FK_team_group` FOREIGN KEY (`group_fk`) REFERENCES `t_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `player`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_activity` datetime DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Tabellenstruktur für Tabelle `player_context`
--

CREATE TABLE `player_context` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `correct_tips` int(11) DEFAULT NULL,
  `correct_trends` int(11) DEFAULT NULL,
  `fee_paid` bit(1) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `tips_visible` bit(1) NOT NULL,
  `user_role` varchar(255) NOT NULL,
  `community_id` bigint(20) DEFAULT NULL,
  `player_id` bigint(20) NOT NULL,
  `predicted_champion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_playercontext_community` (`community_id`),
  KEY `FK_playercontext_player` (`player_id`),
  KEY `FK_playercontext_champion` (`predicted_champion`),
  CONSTRAINT `FK_playercontext_community` FOREIGN KEY (`community_id`) REFERENCES `community` (`id`),
  CONSTRAINT `FK_playercontext_player` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
  CONSTRAINT `FK_playercontext_champion` FOREIGN KEY (`predicted_champion`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

--
-- Table structure for table `t_round`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_round` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `competition_fk` bigint(20) DEFAULT NULL,
  `approved` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort_order` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_round_competition` (`competition_fk`),
  CONSTRAINT `FK_round_competition` FOREIGN KEY (`competition_fk`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_match`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_match` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `external_id` varchar(255) DEFAULT NULL,
  `auto_knockout_pos_team_one_fk` bigint(20) DEFAULT NULL,
  `auto_knockout_pos_team_two_fk` bigint(20) DEFAULT NULL,
  `auto_knockout_group_team_one_fk` bigint(20) DEFAULT NULL,
  `auto_knockout_group_team_two_fk` bigint(20) DEFAULT NULL,
  `auto_knockout_team_one_fk` bigint(20) DEFAULT NULL,
  `auto_knockout_team_two_fk` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `goals_team_one` int(11) DEFAULT NULL,
  `goals_team_two` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `Status` smallint(6) NOT NULL,
  `ticker_match_id` varchar(255) DEFAULT NULL,
  `ticker_url` varchar(255) DEFAULT NULL,
  `trend` int(11) DEFAULT NULL,
  `group_fk` bigint(20) DEFAULT NULL,
  `round_fk` bigint(20) DEFAULT NULL,
  `team_one_fk` bigint(20) DEFAULT NULL,
  `team_two_fk` bigint(20) DEFAULT NULL,
  `competition_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_match_group` (`group_fk`),
  KEY `FK_match_round` (`round_fk`),
  KEY `FK_match_teamone` (`team_one_fk`),
  KEY `FK_match_teamtwo` (`team_two_fk`),
  KEY `FK_match_competition` (`competition_fk`),
  CONSTRAINT `FK_match_round` FOREIGN KEY (`round_fk`) REFERENCES `t_round` (`id`),
  CONSTRAINT `FK_match_teamone` FOREIGN KEY (`team_one_fk`) REFERENCES `team` (`id`),
  CONSTRAINT `FK_match_teamtwo` FOREIGN KEY (`team_two_fk`) REFERENCES `team` (`id`),
  CONSTRAINT `FK_match_group` FOREIGN KEY (`group_fk`) REFERENCES `t_group` (`id`),
  CONSTRAINT `FK_match_competition` FOREIGN KEY (`competition_fk`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tip`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `goals_teame_one` int(11) DEFAULT NULL,
  `goals_team_two` int(11) DEFAULT NULL,
  `player_score` int(11) DEFAULT NULL,
  `trend` int(11) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `match_fk` bigint(20) DEFAULT NULL,
  `playercontext_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tip_match` (`match_fk`),
  KEY `FK_tip_playercontext` (`playercontext_fk`),
  CONSTRAINT `FK_tip_player` FOREIGN KEY (`playercontext_fk`) REFERENCES `player_context` (`id`),
  CONSTRAINT `FK_tip_match` FOREIGN KEY (`match_fk`) REFERENCES `t_match` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'wmtipp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-28 22:46:46
