set JMS=e:\JavaApp\MessageQueue5.1.1\mq\lib
set classpath=build;%JMS%\jms.jar;%JMS%\imq.jar
javac -d build src/*.java
java sharedprogramat.MsgPS
