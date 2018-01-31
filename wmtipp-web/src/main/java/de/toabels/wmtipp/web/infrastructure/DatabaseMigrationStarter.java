/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.toabels.wmtipp.web.infrastructure;

import de.toabels.wmtipp.services.utiils.IDatabaseMigrationService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author abels
 */
@WebListener
public class DatabaseMigrationStarter implements ServletContextListener {

    @Autowired
    private IDatabaseMigrationService databaseMigrationService;
    
    private static final Logger logger = LoggerFactory.getLogger(DatabaseMigrationStarter.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Database migration starts now.");
        // workaround: context for spring injection not set at this point, 
        // so manually initialize beans
        WebApplicationContextUtils
                .getRequiredWebApplicationContext(sce.getServletContext())
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
        // call database migration service
        databaseMigrationService.updateDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Server is going down :-((");
    }

}
