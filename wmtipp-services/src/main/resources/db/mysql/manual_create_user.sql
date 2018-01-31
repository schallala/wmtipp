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
/**
 *  In order to run the project the target database and user has to be created 
 *  manually in MySql, use database client.
 *  The database table will be created in innodb format.
 */
/* create target database as specified in bd.properties file */
create database targetdb;
/* create target database user and password as specified in bd.properties file */
create user 'user'@'%' identified by 'password';
/* grant needed privileges to user , pay attention to access from network (localhost, all/%, ...) */
grant create, select, insert, update, delete, index on targetdb.* to 'user'@'%';
