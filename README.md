# fetch-challenge
The Fetch Receipt Processor Challenge is an API designed to process receipts and calculate points based on parameters of the receipt based on the rules found here:

https://github.com/fetch-rewards/receipt-processor-challenge/blob/main/README.md 

In summary, there are two endpoints and a suite of automated tests. 

A POST endpoint designed to intake a receipt's details, analyze the content, and calculate total points based on the rules above. When a receipt is successfully processed, a UUID is generated for the receipt and stored in memory.

A GET endpoint which allows users to retrieve the total points calculated for a previously processed receipt. Users provide the UUID of the receipt and the system will return the associated points.

<h1>Running Locally</h1>

Prequisites:
1. <b>Git:</b> to clone the project repository
2. <b>Java:</b> to compile and run Java code
3. <b>Maven:</b> to manage project dependencies and run the project
4. <b>IDE:</b> a Java development environment of your choice (I use IntelliJ)

Setup:

1. Installing Git

Windows:
Download and install it from [Git for Windows](https://gitforwindows.org).

After installation, you can use the `Git Bash` terminal for Git commands.

MacOS:
Install using Homebrew: `brew install git`

2. Installing Java

Download the JDK from [Oracle's official website](https://www.oracle.com/java/technologies/downloads/#java16) and follow the installation instructions. This project uses Java 17.

3. Installing Maven
   
Windows: Download Maven from [Maven's official website](https://maven.apache.org/download.cgi) and follow the installation instructions [here](https://maven.apache.org/install.html).

MacOS: Install using Homebrew: `brew install maven`
4. Clone the project

Navigate to project folder in terminal and run the following command

```git clone https://github.com/xie-git/fetch-challenge.git```
5. Run the application

While inside the project directory run the following commands

```
./mvnw clean install
./mvnw spring-boot:run
```

This will start your application. You can access it via browser or API tool (such as Postman) at the designated port (http://localhost:8080)
6. Run the tests

To run Junit tests run the following command
```./mvnw test```


Because of the business logic and the scenarios involved, a more comprehensive test is created using cucumber testing found in `receipt_processing.feature`

To run cucumber tests, use the IDE's built in run function after navigating to the file, or run it directly from CucumberRunnerTest.java by right clicking on the main class and selecting Run.



