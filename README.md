# Secure-Pseudo-Queue

Application that acts as a fake queue
Tech stack used: Spring Boot, MySQL Database

Application contains two microservice modules
1. External module: Accepts REST API request from external source
2. Internal module: Accepts encrypted body from the external module

Steps to set up application:
1. Create a DB in the MySQL server, update the schema in application.properties file.
2. Columns in the table Transaction_Data: Account_Number(Varchar), Amount(int), Type(varchar), Currency(varchar), Account_From(varchar)
3. Run both modules separately.
