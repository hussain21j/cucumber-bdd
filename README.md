# Cucumber Project
The solution has two parts 
 - a spring boot based rest api
 - a maven cucumber based project to do BDD on rest api
### maven project configuration
 - make a maven project
 - include following maaven dependencies
   -- cucumber-java
   -- cucumber-junit
   -- junit
- To run the test from maven command simply use
    -- mvn test      or
    -- mvn clean install

### Steps to follow
- start the rest api project
- Make your maven project as explained above
- install `cucmber for java plugin` on Intellij
- create a cucumber runner class, The runner class is responsible for running all the feature files as junit. remeber the runner class should follow the naming convention of unit test file i.e. *Test, Test*, *TestCase. If not then you have to do the configuration in maven surefire plugin to specify your test classes
- In runner class specify the options 
    * features - directory where all your features present
    * glue - directory of step definitions java classes
- create the feature file.
- create the step definitions file
 * if the `cucmber for java` is installed , when hover over any scenario intellij suggest to create the step definition
 * if you run the feature file and if step definitions is not available, it fails and suggest the step definition

### How to run the tests
- if `cucumber for java` plug is installed , Right click on your feature class an click on `run feature`. It will run the specific feature file
- Right click on your runner class and click run. This will run all the feature files refered by this runner class
- use mvn , `mvn test` or `mvn clean install` 

### Refernces 
- Very nice documentation on official page of cucumber docs https://cucumber.io/docs/guides/overview/
- quick video tutorial on youtube https://www.youtube.com/watch?v=5-eeD-wRSGQ&list=PL5UbgrlC4caYH4xx3A1b5bxS7nZROmFP-&index=1