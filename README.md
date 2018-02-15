# wmtipp - a football betting game in progress ... planned release in May 2018

Quick guide to run project:
- copy wmtipp-services/src/main/resources/app/wmtipp.properties into directory ${USER_HOME}.wmtipp/
- define datasource in wmtipp.properties, check consistency with db.properties
- currently only auto schema generation is working (flyway scripts have to be updated)
- cd wmtipp -> mvn clean install
- cd wmtipp-web -> mvn jetty:run

The application is available under http://localhost:1234/wmtipp

Have fun.

