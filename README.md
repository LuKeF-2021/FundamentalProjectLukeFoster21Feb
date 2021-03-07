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
<img src="https://user-images.githubusercontent.com/78487781/110254179-f9027d80-7f85-11eb-9740-bacf459b879e.png">
<br>
As shown there are various Epics, Stories and tasks displayed on the board. Jira also allows developers to further manage their  
tasks by splitting them into 'Sprints', these sprints are all the tasks you or your team are going to complete in the time  
scale specified upon creating the Sprint. This project was mainly seperated out into sprints based off what layer was being  
worked on, Front-End grouped together, Database etc.  
Below is a screenshot demonstrating a Sprint being used in this project:  
<br>
<img src="https://user-images.githubusercontent.com/78487781/110254416-f6ecee80-7f86-11eb-82bc-da790dcc68fa.png">
<br>
<h3>Database Table Visualised</h3>  
<img src="https://user-images.githubusercontent.com/78487781/110254958-50561d00-7f89-11eb-97d1-017a103f347b.png">
<br>
As shown above, this application will have one table only called 'Champions'. This will store various information about  
each League of Legends champion a user inputs. The application will make use of these various fields to create custom  
queries that filter returned fields by Cost, Roles etc. thus allowing the end user to make an informed decision on  
who they can play in a certain role, or which champions they do not own and might want to purchase in the future.  
<h3>Workflow of Application</h3>  

<h3>Front-End</h3>  
The Front-End of the application was laid out with a webpage for each of the CRUD functions, with a nav bar to let the  
user access each of them. The 'Create Champion' page simply provides a form for the user to imput all necessary fields,  
The screenshot below shows the layout and the validation checks triggering properly:  
<img src="https://user-images.githubusercontent.com/78487781/110259122-01ff4900-7f9e-11eb-8c21-513da86b2d40.png">
<br>
The 'Read Champion' page lets the user filter returned entries of champions that match the criteria the user wants.  
The 'Show champ with ID' button fulfills the Read functionality of the MVP, the other filters are custom queries that  
were included for a better user experience and to prove understanding of the code written beyond the scope of the MVP.  
Below is the page for this:  
<img src="https://user-images.githubusercontent.com/78487781/110259278-c0bb6900-7f9e-11eb-827a-bcc327af1b5c.png">


<h3>Back-End</h3>  

<h3>Testing</h3>  
<h4>Integration Testing</h4>  
<h4>Unit Testing</h4>

<h3>Tools Used</h3>  
Other tools used during the development of this application that haven't been discussed are as follows:  
<li>Git - has been used to push up 'Commits' of code changes, whether that be Front-End or Back-End code. This has been very  
helpful when making experimental changes to my code, each time my codebase is working as intended and has no errors,  
a commit was pushed to GitHub. If any of my changes did not work as intended or caused issues, code could be rolled back  
to a stable point to continue working on.</li>
<li>Spring H2 database - This component of Spring was leveraged during development, a localhost version of the application  
database could be spun up while in use and spun down when the application stopped. With just a few lines of code in an  
application properties file, this functionality was added and enabled quick user testing that code updates were working.</li>
<li>Postman - Postman was used before the application had a frontend created. As the Business Layer of the application was  
produced first, Postman acted as a mock Front-End to test POST,GET,PUT and DELETE http requests to the built Back-End.  
When the Front-End had been coded and styled, the relevant Fetch requests could be coded using JavaScript and they were  
already verified to be working by Postman prior to this stage.</li>
<li>Maven & Mockito - Both of these tools were used within the unit testing of the application. Creating the project as a  
Maven build meant that versions could be made easily (version control) and that dependancies like JUnit could be imported  
to assist with unit testing. Mockito Allows a developer to make MockBeans that imitate how the regular Bean would function,  
however it creates an entity of its own to store this away from your actual application code. Mocking the service and repo  
means that those layers are not impacted by tests.</li>
<li>Spring - This was a pivotal part of the application building process. Spring is an external framework that has been made  
specifically to take away the heavy lifting from the developer, allowing them to focus on the application specifics instead  
of processes such as setting up a jdbc connection or creating sql query strings painstakingly. Additionally, the table schema  
was auto generated by Spring using annotations on columns, and annotations on the class itself to auto generate getters and  
setters for the variables. This 'inversion of control' that Spring provided meant that as the developer I could focus more on  
the logic of the application specific to my goals.</li>
<h3>Future Improvements</h3>  
If this project were to be expanded on at a future date, some of the improvements to be included would be as follows:  
<li>Fix the issue where tables that JavaScript generates and populates with records would not clear upon another query being  
requested. If for instance a user wanted to filter returned champions by cost, and then wanted to either change the filtered  
cost or filter by class for example, then the table would not clear and instead just add additional rows with the new query  
data.</li>
<li>Create a more professional looking design for the webpage. Adhere to more design principles that professional website  
builders use.</li>
<li>Add more filters for the user, enabling them to analyse the data recieved back more meaningfully.</li>
<li>To make the webpage less cluttered for the user, and to increase readability, less buttons could be used to achieve  
the same outcome. Rather than a button for each query, a single button could be used that contains a more complex JavaScript  
function, that analyses which fields have been populated with values, and filters returned data based off those populated  
fields.</li>
<br>
All of the improvements mentioned above go above and beyond what was required as the MVP for this project, so while they would  
be nice features to have, there simply wasn't time to implement them during the project. Alternatively some of the ideas were  
never demonstrated conceptually during training, meaning I didn't have the knowledge to implement some of these into code.
