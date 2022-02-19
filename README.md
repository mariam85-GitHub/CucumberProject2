# CucumberProject2
README.md File for Cucumber Framework Project

Created a BDD Framework
Using Maven as a project build tool, for it's advatages for ex: folder structure and pom.xml to store teh dependenices and the versions.

Implemeinting Cucumber for it's benefits, in creating the feature files, and using Gherkin language inside of it.

After that creating the step denfintion in the steps package, using Given, When, And, Then annotaion.

In this project we are using Singleton to run all the scripts only with one driver, which is reading from the confing.proprties file. Which driver it should run.

Also, using Page Object Modal as a design pattern, by creating page package and with that we create classes,
and each class is representing a web page and storing all the elements in that page.

We are having runner package, and class to run all the scripts from that class, and with entering the plugins, we can create our reports on the target.

Including a package for steps, in that package we have hooks class for seting up and tear down actions, 
and a BaseSteps for only setting up before the execution, and the common step stored as a @Given annotaion there.


To be able to write our scripts in the Gherkin langauage, we had create the feature file under resources.

Finally, we have the utilities package which is the first created to help us to keep everything dynamic, and been controled in one place since it's been used overall the project.

Inside this utilites package, we have ConfigReader to be able to read our confing.properties, and creating our method inside that class to use it in the other class
Driver class, to set up the driver and to tear it down.


Also, implementing Waiter class using explicit wait, by creating methods to help us overall the project. Lastly we have the Screenshot class to take a screenshot, which is used in Hooks class too.
