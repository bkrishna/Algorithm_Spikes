Build and Deploy:

1) Import the listNumbersApp project into eclipse workspace.
2) You can set up the build.properties and deploy the files with the included Ant script.
3) You can either build the application using ant from the terminal/command
4) Use clean, build and deploy command while executing the ant
5) You need an web server to deploy the listNumbersApp and you can access the application with the 
URL : http://localhost:8080/listNumbersApp/
6) I used jdk 1.6, ant 1.8.4 and tomcat 7


Deploy and check:

1) Just drop listNumbersApp.war into your Tomcat webapps directory.


Given Assignment:

Write a java application that lists all of the whole numbers between 1 and 100 and will output them to XML file. 
The XML file should list each number and indicate if it is even or odd.  
The last step is to create an XLST that returns a confirmation html page with two columns, the first column should list the odd numbers and the second column lists the even numbers.

Assumptions:

1) I assumed that the whole numbers are constant as the requirement says 1 to 100 and not 1 to n.

Approach:

1) I used a simple web application to write this program.
2) Rendering the html output from the xml using XSLT can be done in many ways.
	I came up with 3 of them.
	a) By using the spring framework configurations
	b) generating the xml and saving in the tomcat bin and some working repository and reading them again when needed for the html transformation using xslt
	c) saving the generated xml in the cache and retrieving it for the HTML transformation using xslt.

3) I used approach 3 given the scope of the project, I did not want to over engineer. And as there might be a need to download the generated xml for verification, 
I did not want to recreate the xml by calling the same method which I would have already done for the HTML conversion. Hence I used the session cache.
Again given the scope, I felt this is the best solution. But for larger applications this is not a good solution and the elegant way would be (a) or (b) given the nature of the project.