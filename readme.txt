1.I was not able to see any External reporting part with this framework which sometime needed by the client.
So i have implemented the Extent reports with screenshots.

2.I can see we were not using any specific pattern in this framework so i have implemented the page object Pattern with Page Fectory
to manage the code in a better way.

3.There was no base class for test or Page so i have implemented same all the common work among these class can be done in base itself.
All other classes are inheritting these base classes.

4.Was not able to see any object Repository for the locators so i have implemented in this framework so that all locators are at 1 place and it is easy to maintain
and they are also easily trackable using the PageFactory too .

5.I can see some of the data was hard coded .So i have created the properties files for the same as per the best practice data should be seprated from the code.
In future we may need the data from third party , so it is better it is seprated.

6.There was no gitignore file but i have commited the same as we dont want to commit everthing

7.I need to update the chromedriver on my windows PC as it was not compatiable with my browser.

8.As we can use TestNG but there was no file for same so i have created the same.

9.If needed we can even seprate out the Framework from Project in seprate jar and upload the same in company Central server using nexuz or Jfrog.

10.There are no dependency between any test case and if needed it can be run parallely also.

11.There was lot of code which was duplicated but i have removed it and put at a common place

Note: If time permits we can have many more utilities created in this framework like related to date,Excel which can be reused by others too.

