# Files

There are three commma separated files in `data` directory:

 * departments.csv  - list of departments
 * employees.csv    - first column contains position of department in alphabetically sorted department list, followed by employee name and salary
 * ages.csv         - first column contains employee name, followed by age

# Challenge

Write a Java program that will generate the following reports in corresponding files.

 * income-by-department.csv - median income by department
 * income-95-by-department.csv - 95-percentile income by department
 * income-average-by-age-range.csv - average income by age ranges with factor of ten
 * employee-age-by-department.csv - median employee age by department

Reports must be generated in a comma separated format with header columns.

# Conditions

 * Code should be compilable with Oracle JDK 1.8 and run with path to directory containing data files as first parameter.
 * Only libraries that are part of Oracle Java Runtime are allowed in production code.
 * provide the solution source code either as zip or as a link to the code repository
 * time cap is hard to quantify, as a rough guideline 3h should be enough but please spend as much time as you need to come up with a solution you are satisfied with and confident about
 
 # How to use the result
 
 * Download project source code
 * Build the project with `mvn clean package `
 * Copy `hubrick-backend-challenge-1.0.jar` somewhere and put near this file the original data folder with csv files or specify data folder path as first parameter:
   ```
   /some-folder
    |-- hubrick-backend-challenge-1.0.jar
    |-- /data
         |-- ages.csv
         |-- departments.csv
         |-- employees.csv
   ```
 * Run reports generation with:
   ```bash
    java -jar hubrick-backend-challenge-1.0.jar
   ```
   or
   ```bash
    java -jar hubrick-backend-challenge-1.0.jar data
   ```
   or
   ```bash
    java -jar hubrick-backend-challenge-1.0.jar {path-to-data-folder}
   ```

 * The reports should be generated into `reports` directory under the same root directory:
   ```
   /some-folder
    |-- hubrick-backend-challenge-1.0.jar
    |-- /data
         ...
    |-- /reports
         |-- income-by-department.csv
         |-- income-95-by-department.csv
         |-- income-average-by-age-range.csv
         |-- employee-age-by-department.csv
   ```
 * Also, there is a way to print reports into console instead of csv files, it is possible with following command:
   ```bash
    java -jar hubrick-backend-challenge-1.0.jar data true
   ``` 
