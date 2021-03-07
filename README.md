# FundamentalProjectLukeFoster21Feb
## League Of Legends Champion Database  
  
This project was a CRUD (Create,Read,Update,Delete) application due by end of Week 5 for QA Academy 21Feb Cloud Native.  
<br>
<br>
Links to all resources can be found below:  
[GitHub-BackEnd](https://github.com/LuKeF-2021/FundamentalProjectLukeFoster21Feb)  
[GitHub-FrontEnd](https://github.com/LuKeF-2021/FundamentalProject21FebFrontEnd)  
[Jira Board](https://lukef.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=FPQA&selectedIssue=FPQA-1)  
[Risk Assessment](https://github.com/LuKeF-2021/FundamentalProjectLukeFoster21Feb/blob/main/Risk%20Assessment%20Luke%20Foster%20Fundamentals%20Project%2021Feb.docx)  
<br>
<br>
### Project requirements  
The MVP for this project was as follows:  
* A database with one or more tables.
* CRUD functionality on atleast one table.
* testing of code implemented.
* Database hosted on GCP SQL server.
* Risk assessment relevant to the project.
* ERD (Entity Relationship Diagram).
* Front-End webpage on localhost for users to enter data into db.  
<br>
<br>
<h3> Why I chose a champion database </h3>
The MVP was to incorporate CRUD functionality into the application, my idea satisfied this criteria but also had scope  
to expand the application with other functionality as strech goals and to display my coding proficiency/understanding.  
<br>
The application at the very least, upon completion, would be able to add champion details from the popular MOBA game  
League of Legends, read the contents of the champions listed in the table, update a specific champion if any details  
changed about them, and also delete the record of a champion requested by the user.  
<br>
<h3>General approach to project</h3>
To make the front end of the application HTML, CSS and JavaScript were needed. The back end or 'Business Layer' of the application  
leveraged Java with SpringBoot, and finally the database was hosted on GCP (Google Cloud Platform). While extra functionality can  
be interesting and appealing to the user, to ensure a successful project was submitted the specifications in the MVP needed to be  
focused on first and foremost. To seperate the essential from the 'would be nice to have', a MOSCOW analysis was incorporated as  
stated below:  
<br>
<br>

Must have:  
* One DB table with CRUD functionality: Add, Read, Update, Delete Champions. Hosted on GCP.
* Jira board with epics, user stories and tasks.
* Evidence of testing to some degree within the application back-end.
* Functioning front-end webpage(s) that interact with the back-end and DB.
* Documentation e.g. Risk Assessment.  

Should have:  
* Home Page with form for input.  

Could have:  
* Seperate pages for Create, Read, Update and Delete Forms.
* Visual representation of table contents on webpage (e.g. html table)
* Custom queries that the user can filter champions by, such as cost, release year.
* Some Level of Styling and formatting done to the webpage so it's not as bland.
* Second table that keeps track of champions on sale, and relates back to the main table.  

Wont have:  
* Professional level webpage design.  
<br>
Further into this document it will be clear that some of the functionality outside of the 'must have' section was implemented.  
However, by setting expectations early about what to focus on, the MVP was completed first and extra features added afterwards.  
<h3>Analysis of Risk Assessment after application has been built</h3>  
Of the Four risks highlighted in the risk assessment, only one of them needed to be resolved. As this project has not been demonstrated  
yet, there have been no issues with my database being offline during development and testing.  
<br>
<br>
Within the five week duration for this  project, no illnesses have had to be accounted for. While this is out of a developers control,  
it has ensured the project has remained on schedule and that all relevant information on how to build an application was gained via  
teams tutoring.  
<br>
<br>
As discussed in the risk assessment, the project would not be creating or interacting with any sensitive information. This has remained  
true throughtout the project, and the final solution mitigates the lack of extra security the HTTP Protocol misses out on compared to  
it's HTTPS counterpart.  
<br>
<br>
The risk that was encountered during the build process of this project was invalid data being passed into the backend via user input.  
While developing the application even I as the developer sometimes left fields empty in a hurry, making it very understandable that  
an unfamiliar user might also fall victim to this. To combat this problem if statements and various logic was implemented into the  
JavaScript codebase to find these issues and alert the user, and only sending the completed form contents via a POST request after  
the input had been verified. This will be highlighted and discussed more in the 'Front-End' section of this readme later on.  
<h3>Using Jira to visualise tasks</h3>  
To visualise the progress of the application, and have a reference for completed, in progress, and outstanding tasks  
a Jira Kanban board was used to store epics, user stories and tasks. Epics are Large Parts of the code base that  
provide a lot of functionality that is broken down into User Stories and Tasks associated with the Epic. Below  
is a screenshot of the Jira Board for the project (also the Board is linked at the top of this document):  
<br>
[Jira Board Image](https://user-images.githubusercontent.com/78487781/110254179-f9027d80-7f85-11eb-9740-bacf459b879e.png)
<br>
As shown there are various Epics, Stories and tasks displayed on the board. Jira also allows developers to further manage their  
tasks by splitting them into 'Sprints', these sprints are all the tasks you or your team are going to complete in the time  
scale specified upon creating the Sprint. This project was mainly seperated out into sprints based off what layer was being  
worked on, Front-End grouped together, Database etc.  
Below is a screenshot demonstrating a Sprint being used in this project:  
[Jira Sprint](https://user-images.githubusercontent.com/78487781/110254416-f6ecee80-7f86-11eb-82bc-da790dcc68fa.png)


<h3>Database Table Visualised</h3>  

<h3>Workflow of Application</h3>  
discuss all layers, how they interact, the methods in each layer, demonstrate POST GET DELETE PUT workflow
<h3>Front-End</h3>  

<h3>Back-End</h3>  

<h3>Testing</h3>  
<h4>Integration Testing</h4>  
<h4>Unit Testing</h4>

<h3>Tools Used</h3>  

<h3>Future Improvements</h3>  

