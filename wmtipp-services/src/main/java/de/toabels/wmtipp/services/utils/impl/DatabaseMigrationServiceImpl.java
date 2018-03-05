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
package de.toabels.wmtipp.services.utils.impl;

import de.toabels.wmtipp.services.utiils.IDatabaseMigrationService;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author abels
 */
@Service
public class DatabaseMigrationServiceImpl implements IDatabaseMigrationService {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseMigrationServiceImpl.class);

    private static String MIGRATION_PATH_MYSQL = "src/main/resources/db";

    /* get database configuration from properties file */
    private @Value("${db.migrationPath}")
    String dbMigrationPath;

    private @Value("${db.generateDdl}")
    String dbGenerateDdl;

    private @Value("${db.url}")
    String dbUrl;

    private @Value("${db.username}")
    String dbUser;

    private @Value("${db.password}")
    String dbPassword;

    @Override
    public void updateDatabase() {
        // Create the Flyway instance
        Flyway flyway = new Flyway();
        // skip flyway migration if auto generation is enabled by config
        if(Boolean.parseBoolean(dbGenerateDdl)){
            logger.info("Database auto generation is enabled ... migration is skipped.");
            return;
        }
        // skip flyway migration if path to scripts is missing
        if(dbMigrationPath == null || dbMigrationPath.isEmpty()){
            logger.info("Path to migrations scripts is missing in config ... migration is skipped.");
            return;
        }

        // Start the migration
        flyway.setLocations(dbMigrationPath);
        // Point it to the database
        flyway.setDataSource(dbUrl, dbUser, dbPassword);
        logger.info("Check schema version and apply changes.");
        flyway.migrate();
        logger.info("Database changes successfully applied!");
    }

}
