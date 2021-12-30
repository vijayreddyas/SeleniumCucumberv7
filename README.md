# BDD Based JAVA FRAMEWORK FOR UI AUTOMATION

_**# Goal of the framework**_
Framework can be used to automate the UI scenarios using Selenium with BDD approach, in this case we are using Cucumber

##### **_`Capabilities of the framework`_**
*   Page Object Model Design Pattern
*   Cross Browser Support
*   Parallel execution of features and also scenarios.
*   Execution on Local or remote Selenium grid infra.
*   Can be integrated with any CI tool, in this case we tried using Jenkins.
*   Scenarios can be written in a plain English language called Gherkin.
*   Flows can be easily developed using available utility functions.
*   Wonderful html report using the third party plugin called Cluecumber. 

#### **_`TechStack`_**
*   Java 1.8
*   apache-maven-3.6.3
*   TestNG
*   Cucumber Version 7.1.0
*   Selenium 4.1.1
*   Reporting : Cluecumber third party report
*   Editor: Intellij

### **_`Usage`_**
**_#Using maven_**
*   Executing the entire feature files
    
    mvn clean install -DrunType=<local or remote> -Dbrowser=<browser> -DthreadCount=<no. of threads>
    
    Usage:
    mvn clean install -DrunType=local -Dbrowser=MSEdge -DthreadCount=3
    
*   Cucumber tags can be created for marking bunch of cases under a specific category and a specific
    cases can be executed by using the below command
    
    **_`Single Tag`_**
    
    mvn clean install -DrunType=<local or remote> -Dbrowser=<browser> -Dcucumber.filter.tags="@tag name"
    
    Usage:
    mvn clean install -DrunType=local -Dbrowser=MSEdge -Dcucumber.filter.tags=@smoke
    
    ###### **_`Multiple Tags`_**
    
    mvn clean install -DrunType=<local or remote> -Dbrowser=<browser> -Dcucumber.filter.tags="@tag1 or @tag2" -DthreadCount=<no. of threads>
        
    Usage:
    mvn clean install -DrunType=local -Dbrowser=MSEdge -Dcucumber.filter.tags="@Login or @smoke" -DthreadCount=3
    
    These tags should be defined on top of features or it can be defined on scenario as well.
    
## **_`Roadmap`_**
*   Implementation of Docker containerization for execution of the scripts
*   Integration of Excel, Yaml, Json files for capturing the test data during run time.
*   Integration of random test data generation using JFairy Library
*   Integration of static code analysis tools with maven
*   Database connection helpers 
