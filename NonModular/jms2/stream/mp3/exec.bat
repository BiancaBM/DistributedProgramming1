set JMS=e:\JavaApp\MessageQueue5.1.1\mq\lib
set classpath=.;%JMS%\jms.jar;%JMS%\imq.jar;lib\jl1.0.1.jar
javac -d . src\*.java
java msgmp3.MsgPS
