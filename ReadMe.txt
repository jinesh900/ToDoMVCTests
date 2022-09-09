Pre-requisite
---------------
a. Tests will be executed in Chrome by default. Correct chromedrive.exe should exist (chromedrive.exe which supports Chrome version 105 is provided.)

b. If cross browser support is intended, user can change the browser to be tested under TestBase class (in definitions package). User can change the 
variable 'browser' to firefox or edge to invoke the required browser. geckodriver.exe and msedgedriver.exe are provided and must be available at 
project folder.

Note: webdrivermanager is not implemented to avoid any complexities which can arise when the script is executed by a third party

1. Run test suite from command prompt
--------------------------------------
a. Invoke cmd prompt.
b. Change to folder where pom.xml exists.
c. Run the command 'mvn clean test'.

2. Run test suite from IDE
------------------------------------
a. Open the project in IDE (e.g. Eclipse).
b. Right click on testng.xml (under src/test/resources).
c. Select Run As --> TestNG Suite.