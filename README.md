# Crisis Information System for Retail Customers
This programming project aims to develop an information system to address the challenges faced by retail systems during pandemics, such as the current COVID-19 crisis. The project recognizes that pandemic regulations can weaken the economy and create panic buying behaviors, leading to shortages and overcrowded stores. The goal is to provide a solution that enables retail stores to efficiently distribute scarce goods and empowers customers with relevant information, including inventory levels, restricted opening hours, and product limitations. By developing this information system, the project aims to support retail systems in handling high demand, ensuring safety standards, and improving overall efficiency during pandemic situations. The practical course paper outlines the development and implementation of this information system.

## Project Structure
Backend is located at 'cis-retail-web/PRIS (master), also on backend branch    
Frontend is located at 'cis-retail-web/pris-frontend (master), also on frontend branch

## Requirements
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  or later
- [Gradle 4+](http://www.gradle.org/downloads)  or  [Maven 3.2+](https://maven.apache.org/download.cgi)
- [Node.js 12.18.3+](https://nodejs.org/en/) installed
- [MySQL 8.0](https://dev.mysql.com/doc/refman/8.0/en/installing.html) installed and created a database with followed characteristics:  

`database_name=PRIS on http://localhost:3306/PRIS;      
username=root;     
password=1234;`

### Optional
Import **all** given CSV example files located in .... into the database PRIS by executing followed SQL Command on CommandLine:  

`LOAD DATA LOCAL  
INFILE '/pathToDownloadedCSVFile/tablenameData.csv'  
INTO TABLE tablename  
FIELDS TERMINATED BY ';'   
LINES TERMINATED BY '\r\n'              
IGNORE 1 LINES
(column1, column2,...)`  

Column names are given in the first line of the csv files, make sure these are correct.

**Note:** Make sure to follow this order by importing the files because of the primary and foreign keys: category, user, address, retail store, product

**If Error "Loading local data is disabled" (default in mysql)** occurs on CommandLine run following code before importing:  
- `cd C:\Program Files\MySQL\MySQL Server 8.0\bin`
- `mysql -u root -p`
- `mysql> SET GLOBAL local_infile=1;`
- `mysql> quit`
- `mysql --local-infile=1 -u root -p`
- `mysql> use database pris;`   

## Start Application

1. **Build frontend**: $PathToWhereFrontendIsLocated `npm run build`
2. Put frontend build in PRIS/src/main/resources/public in order to bundle it together with the backend.
3. **Run backend**    
a) Via Command Line: $PathToWhereBackendIsLocated `java -jar pris.jar`    
b) Via IDE: Open/Clone retailWeb, run Backend as Spring Boot Application

**Note:** Default database entries are build within backend (in BuildExamples.class). Since entires can not be duplicated after they are initialized once in database with the first run of backend this class has to be commmented out to prevent errors.
