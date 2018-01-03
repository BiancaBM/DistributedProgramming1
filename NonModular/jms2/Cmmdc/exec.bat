set JMS=e:\JavaApp\openmq5_1_1\mq\lib
set classpath=.;%JMS%\jms.jar;%JMS%\imq.jar;
javac -Xlint -d . src\*.java
start server.bat
start sender.bat
start receiver.bat
