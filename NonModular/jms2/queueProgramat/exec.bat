set JMS=e:\JavaApp\openmq5_1_1\mq\lib
set classpath=build;%JMS%\jms.jar;%JMS%\imq.jar
javac -d build src/*.java
java queueprogramat.MsgHelloT
