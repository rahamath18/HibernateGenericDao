DB
--
CREATE SCHEMA `test` ;

$ mvn eclipse:eclipse

$ mvn package -Dmaven.test.skip=true

mvn resources:copy-resources -PcopyJsps

http://localhost:8080/<app_context>

http://localhost:8080/<app_context>/customer/getAllCustomers

