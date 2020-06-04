set projectLocation=C:\Users\sairajath.s\.jenkins\workspace\GitTestNg
cd %projectLocation%
set classpath=%projectLocation%\lib\*;%projectLocation%\bin
java org.testng.TestNG %projectLocation%\testng.xml
pause
