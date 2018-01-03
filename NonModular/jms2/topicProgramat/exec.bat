set JMS=e:\JavaApp\MessageQueue5.1.1\mq\lib
set classpath=.;%JMS%\jms.jar;%JMS%\imq.jar
javac -d build src/*.java
java -cp build topicprogramat.MsgPS
