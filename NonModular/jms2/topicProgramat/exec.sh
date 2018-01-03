#!/bin/bash
JMS=/home/mk/JavaApp/glassfish4/mq/lib
classpath=./:build:$JMS/jms.jar:$JMS/imq.jar;
javac -cp $classpath -d build src/*.java
java -cp $classpath topicprogramat.MsgPS
