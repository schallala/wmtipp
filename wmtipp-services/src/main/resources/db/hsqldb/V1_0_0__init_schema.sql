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
CREATE TABLE PUBLIC.COMMUNITY (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	AUTOGENERATE_MATCHES BOOLEAN NOT NULL,
	AUTORELEASE_ROUNDS BOOLEAN NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	SCORE_CORRECT_TIP BIGINT NOT NULL,
	SCORE_CORRECT_TREND BIGINT NOT NULL,
	SCORE_CORRECT_WINNER BIGINT NOT NULL,
	SHORTNAME VARCHAR(255) NOT NULL,
	TITLE VARCHAR(255) NOT NULL,
	PRIMARY KEY (ID)
) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10092_10101 ON PUBLIC.COMMUNITY (ID) ;

CREATE TABLE PUBLIC.COMPETITION (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	EXTERNALID VARCHAR(255),
	FLAGS_PATH VARCHAR(255) NOT NULL,
	IMAGE_PATH VARCHAR(255) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	POINTS_DRAW BIGINT NOT NULL,
	POINTS_WIN BIGINT NOT NULL,
	SHORTNAME VARCHAR(255) NOT NULL,
	SORT_ORDER INTEGER,
	TITLE VARCHAR(255) NOT NULL,
	PRIMARY KEY (ID)
) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10119_10127 ON PUBLIC.COMPETITION (ID) ;

CREATE TABLE PUBLIC.COMMUNITY_COMPETITION (
	COMMUNITY_ID BIGINT NOT NULL,
	COMPETITION_ID BIGINT NOT NULL,
	CONSTRAINT FKJDNL9MFQ4A1R12YVWAPVU09HB FOREIGN KEY (COMMUNITY_ID) REFERENCES PUBLIC.COMMUNITY(ID),
	CONSTRAINT FKS18QITQBFGPEVDVOKIA93L3GN FOREIGN KEY (COMPETITION_ID) REFERENCES PUBLIC.COMPETITION(ID)
) ;
CREATE INDEX SYS_IDX_FKJDNL9MFQ4A1R12YVWAPVU09HB_10116 ON PUBLIC.COMMUNITY_COMPETITION (COMMUNITY_ID) ;
CREATE INDEX SYS_IDX_FKS18QITQBFGPEVDVOKIA93L3GN_10221 ON PUBLIC.COMMUNITY_COMPETITION (COMPETITION_ID) ;

CREATE TABLE PUBLIC.NEWS (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	CREATED_AT TIMESTAMP NOT NULL,
	SUBJECT VARCHAR(255),
	TEXT VARCHAR(255),
	PRIMARY KEY (ID)
) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10149_10151 ON PUBLIC.NEWS (ID) ;

CREATE TABLE PUBLIC.T_GROUP (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	COMPETITION_FK BIGINT,
	NAME VARCHAR(255) NOT NULL,
	SORT_ORDER INTEGER,
	PRIMARY KEY (ID),
	CONSTRAINT FK_group_competition FOREIGN KEY (COMPETITION_FK) REFERENCES PUBLIC.COMPETITION(ID)
) ;
CREATE INDEX IDX_FK_group_competition ON PUBLIC.T_GROUP (COMPETITION_FK) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10173_10175 ON PUBLIC.T_GROUP (ID) ;

CREATE TABLE PUBLIC.TEAM (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	GOAL_DIFFERENCE INTEGER,
	GOALS_CONCEEDED INTEGER,
	GOALS_SCORED INTEGER,
	IS_NULL BOOLEAN NOT NULL,
	MATCHES_FINISHED INTEGER,
	NAME VARCHAR(255),
	POINTS INTEGER,
	T_STATE INTEGER,
	T_WON BOOLEAN NOT NULL,
	URL_FLAG_IMAGE VARCHAR(255),
	URL_INFO VARCHAR(255),
	GROUP_FK BIGINT,
	PRIMARY KEY (ID),
	CONSTRAINT FKCDS931D56PDUEP5W8HGPKM0L6 FOREIGN KEY (GROUP_FK) REFERENCES PUBLIC.T_GROUP(ID)
) ;
CREATE INDEX SYS_IDX_FKCDS931D56PDUEP5W8HGPKM0L6_10206 ON PUBLIC.TEAM (GROUP_FK) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10199_10202 ON PUBLIC.TEAM (ID) ;

CREATE TABLE PUBLIC.PLAYER (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	EMAIL VARCHAR(255),
	FIRST_NAME VARCHAR(255),
	LAST_ACTIVITY TIMESTAMP,
	LOGIN VARCHAR(255) NOT NULL,
	NAME VARCHAR(255),
	PASSWORD VARCHAR(255),
	PHONE VARCHAR(255),
	PRIMARY KEY (ID)
) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10155_10157 ON PUBLIC.PLAYER (ID) ;

CREATE TABLE PUBLIC.PLAYER_CONTEXT (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	CORRECT_TIPS INTEGER,
	CORRECT_TRENDS INTEGER,
	FEE_PAID BOOLEAN,
	SCORE INTEGER,
	TIPS_VISIBLE BOOLEAN NOT NULL,
	USER_ROLE VARCHAR(255) NOT NULL,
	COMMUNITY_ID BIGINT,
	PLAYER_ID BIGINT,
	PREDICTED_CHAMPION BIGINT,
	PRIMARY KEY (ID),
	CONSTRAINT FK7B5MB49WTCQCS2WEKQT6Y78KE FOREIGN KEY (PLAYER_ID) REFERENCES PUBLIC.PLAYER(ID),
	CONSTRAINT FKMAEWJ7UT9U91UJO6EHRIVEK0Q FOREIGN KEY (PREDICTED_CHAMPION) REFERENCES PUBLIC.TEAM(ID),
	CONSTRAINT FKSCK7OMN1NGP8K9OVIDB5KADPY FOREIGN KEY (COMMUNITY_ID) REFERENCES PUBLIC.COMMUNITY(ID)
) ;
CREATE INDEX SYS_IDX_FK7B5MB49WTCQCS2WEKQT6Y78KE_10170 ON PUBLIC.PLAYER_CONTEXT (PLAYER_ID) ;
CREATE INDEX SYS_IDX_FKMAEWJ7UT9U91UJO6EHRIVEK0Q_10239 ON PUBLIC.PLAYER_CONTEXT (PREDICTED_CHAMPION) ;
CREATE INDEX SYS_IDX_FKSCK7OMN1NGP8K9OVIDB5KADPY_10168 ON PUBLIC.PLAYER_CONTEXT (COMMUNITY_ID) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10161_10164 ON PUBLIC.PLAYER_CONTEXT (ID) ;

CREATE TABLE PUBLIC.MESSAGE (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	CREATED_AT TIMESTAMP NOT NULL,
	MESSAGE_READ BOOLEAN NOT NULL,
	SUBJECT VARCHAR(255) NOT NULL,
	TEXT VARCHAR(255) NOT NULL,
	RECIPIENT BIGINT,
	SENDER BIGINT,
	PRIMARY KEY (ID),
	CONSTRAINT FK91NKG77GMGR22OMYJUN6YCQIX FOREIGN KEY (RECIPIENT) REFERENCES PUBLIC.PLAYER(ID),
	CONSTRAINT FKJGFUHLCV0PYCIM5D1CKRJ6ET1 FOREIGN KEY (SENDER) REFERENCES PUBLIC.PLAYER(ID)
) ;
CREATE INDEX SYS_IDX_FK91NKG77GMGR22OMYJUN6YCQIX_10225 ON PUBLIC.MESSAGE (RECIPIENT) ;
CREATE INDEX SYS_IDX_FKJGFUHLCV0PYCIM5D1CKRJ6ET1_10232 ON PUBLIC.MESSAGE (SENDER) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10137_10142 ON PUBLIC.MESSAGE (ID) ;

CREATE TABLE PUBLIC.T_ROUND (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	COMPETITION_FK BIGINT,
	APPROVED BOOLEAN NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	SORT_ORDER SMALLINT,
	PRIMARY KEY (ID),
	CONSTRAINT FK_round_competition FOREIGN KEY (COMPETITION_FK) REFERENCES PUBLIC.COMPETITION(ID)
) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10191_10194 ON PUBLIC.T_ROUND (ID) ;
CREATE INDEX IDX_FK_round_competition ON PUBLIC.T_ROUND (COMPETITION_FK) ;

CREATE TABLE PUBLIC.T_MATCH (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	AUTO_KNOCKOUT_POS_TEAM_ONE_FK BIGINT,
	AUTO_KNOCKOUT_POS_TEAM_TWO_FK BIGINT,
	AUTO_KNOCKOUT_GROUP_TEAM_ONE_FK BIGINT,
	AUTO_KNOCKOUT_GROUP_TEAM_TWO_FK BIGINT,
	AUTO_KNOCKOUT_TEAM_ONE_FK BIGINT,
	AUTO_KNOCKOUT_TEAM_TWO_FK BIGINT,
	DESCRIPTION VARCHAR(255),
	EXTERNAL_ID VARCHAR(255),
	GOALS_TEAM_ONE INTEGER,
	GOALS_TEAM_TWO INTEGER,
	NAME VARCHAR(255),
	START_DATE TIMESTAMP NOT NULL,
	STATUS SMALLINT NOT NULL,
	TICKER_MATCH_ID VARCHAR(255),
	TICKER_URL VARCHAR(255),
	TREND INTEGER,
	COMPETITION_FK BIGINT,
	GROUP_FK BIGINT,
	ROUND_FK BIGINT,
	TEAM_ONE_FK BIGINT,
	TEAM_TWO_FK BIGINT,
	PRIMARY KEY (ID),
	CONSTRAINT FK93KT2LWP4BI6ULOOJ6AF1R0L5 FOREIGN KEY (ROUND_FK) REFERENCES PUBLIC.T_ROUND(ID),
	CONSTRAINT FK9FFW1P38RXS9G3GYG6XDCUYC7 FOREIGN KEY (TEAM_ONE_FK) REFERENCES PUBLIC.TEAM(ID),
	CONSTRAINT FKG9AAGWIWCHXIDAJ82TJK3UGFA FOREIGN KEY (TEAM_TWO_FK) REFERENCES PUBLIC.TEAM(ID),
	CONSTRAINT FKLOYN2H2CSVV6ETOTR11424B1S FOREIGN KEY (GROUP_FK) REFERENCES PUBLIC.T_GROUP(ID),
	CONSTRAINT FKS0HFUIQ25H9PTX6Q8EUQ8PJQC FOREIGN KEY (COMPETITION_FK) REFERENCES PUBLIC.COMPETITION(ID)
) ;
CREATE INDEX SYS_IDX_FK93KT2LWP4BI6ULOOJ6AF1R0L5_10244 ON PUBLIC.T_MATCH (ROUND_FK) ;
CREATE INDEX SYS_IDX_FK9FFW1P38RXS9G3GYG6XDCUYC7_10249 ON PUBLIC.T_MATCH (TEAM_ONE_FK) ;
CREATE INDEX SYS_IDX_FKG9AAGWIWCHXIDAJ82TJK3UGFA_10254 ON PUBLIC.T_MATCH (TEAM_TWO_FK) ;
CREATE INDEX SYS_IDX_FKLOYN2H2CSVV6ETOTR11424B1S_10188 ON PUBLIC.T_MATCH (GROUP_FK) ;
CREATE INDEX SYS_IDX_FKS0HFUIQ25H9PTX6Q8EUQ8PJQC_10186 ON PUBLIC.T_MATCH (COMPETITION_FK) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10179_10182 ON PUBLIC.T_MATCH (ID) ;

CREATE TABLE PUBLIC.TIP (
	ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	CREATED_AT TIMESTAMP NOT NULL,
	GOALS_TEAME_ONE INTEGER,
	GOALS_TEAM_TWO INTEGER,
	PLAYER_SCORE INTEGER,
	TREND INTEGER,
	UPDATED_AT TIMESTAMP NOT NULL,
	MATCH_FK BIGINT,
	PLAYERCONTEXT_FK BIGINT,
	PRIMARY KEY (ID),
	CONSTRAINT FK8WWY9MXT6A4XN15SYKITN061G FOREIGN KEY (PLAYERCONTEXT_FK) REFERENCES PUBLIC.PLAYER_CONTEXT(ID),
	CONSTRAINT FKII1EGW2BB3O26N4Q7JHVVN4GO FOREIGN KEY (MATCH_FK) REFERENCES PUBLIC.T_MATCH(ID)
) ;
CREATE INDEX SYS_IDX_FK8WWY9MXT6A4XN15SYKITN061G_10218 ON PUBLIC.TIP (PLAYERCONTEXT_FK) ;
CREATE INDEX SYS_IDX_FKII1EGW2BB3O26N4Q7JHVVN4GO_10216 ON PUBLIC.TIP (MATCH_FK) ;
CREATE UNIQUE INDEX SYS_IDX_SYS_PK_10209_10212 ON PUBLIC.TIP (ID) ;

