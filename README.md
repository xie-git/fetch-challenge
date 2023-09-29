# fetch-challenge
The Fetch Receipt Processor Challenge is an API designed to process receipts and calculate points based on parameters of the receipt based on the rules found [here](https://github.com/fetch-rewards/receipt-processor-challenge/blob/main/README.md)

In summary, there are two endpoints and a suite of automated tests. 

A POST endpoint designed to intake a receipt's details, analyze the content, and calculate total points based on the rules above. When a receipt is successfully processed, a UUID is generated for the receipt and stored in memory.

A GET endpoint which allows users to retrieve the total points calculated for a previously processed receipt. Users provide the UUID of the receipt and the system will return the associated points.

Testing includes Junit tests for controller and service components, as well as Cucumber testing for more comprehensive coverage of a multitude of different data scenarios. Cucumber testing is also great for modularity and allows for more efficient support if new business logic is added. 

<h1>Running Locally</h1>

<h4>Prequisites:</h4>

1. <b>Git:</b> to clone the project repository
2. <b>Java:</b> to compile and run Java code
3. <b>Maven:</b> to manage project dependencies and run the project
4. <b>IDE:</b> a Java development environment of your choice (I use IntelliJ)

<h4>Setup:</h4>

<h5>1. Installing Git</h5>

<h6>Windows:</h6>
Download and install it from [Git for Windows](https://www.gitforwindows.org)

After installation, you can use the `Git Bash` terminal for Git commands.

<h6>MacOS:</h6>
Install using Homebrew: `brew install git`

<h5>2. Installing Java</h5>

Download the JDK from [Oracle's official website](https://www.oracle.com/java/technologies/downloads/#java16)
and follow the installation instructions. This project uses Java 17.

<h5>3. Installing Maven</h5>
   
<h6>Windows:</h6> Download Maven from [Maven's official website](https://maven.apache.org/download.cgi) and follow the installation instructions [here](https://maven.apache.org/install.html)

<h6>MacOS:</h6> Install using Homebrew: `brew install maven`
<h5>4. Clone the project</h5>

Navigate to a project directory in terminal and run the following command

```git clone https://github.com/xie-git/fetch-challenge.git```
<h5>5. Run the application</h5>

While inside the project directory run the following commands

```
./mvnw clean install
./mvnw spring-boot:run
```

This will start your application. You can access it via browser or API tool (such as Postman) at the designated port (http://localhost:8080)
<h5>6. Run the tests</h5>

To run Junit tests run the following command
```./mvnw test```


Because of the business logic and the scenarios involved, a more comprehensive test is created using cucumber testing found in `receipt_processing.feature`

To run cucumber tests, use the IDE's built in run function after navigating to the file, or run it directly from CucumberRunnerTest.java by right clicking on the main class and selecting Run.

<h1>Future Improvements</h1>

<b>Database Integration:</b> Implement a database layer to persist receipt data, including receipt objects and their corresponding IDs. This allows for data storage beyond in-memory storage and makes it possible to retrieve receipts even after the application restarts.

<b>Data Validation:</b> Enhance data validation for incoming receipt data. Implement robust validation checks to ensure that the data meets specific criteria and is error-free before processing.

<b>Authentication and Authorization:</b> Add authentication and authorization to secure this API. This ensures that only authorized users can submit and retrieve receipts.

<b>Logging and Monitoring:</b> Implement logging and monitoring to track the application's performance and usage. This can help identify issues, troubleshoot problems, and gather insights into user behavior.

<b>Error Handling and Reporting:</b> Enhance error handling by providing more informative error messages to clients. Implement a standardized error response format, including error codes and descriptions.

There are many other useful enhancements to be made to this API including an even more enhanced and comprehensive testing suite built for applications at the enterprise production ready level, analytics and reporting of the data, setting up a CI/CD pipeline, and adding support for scalability in case of load and performance issues. 

To the engineer grading this: I hope you find this implementation sufficient. Thank you for your consideration into my application.

