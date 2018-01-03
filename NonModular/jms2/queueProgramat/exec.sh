#!/bin/bash
JMS=/home/mk/JavaApp/mq/lib
classpath=./:build:$JMS/jms.jar:$JMS/imq.jar;
javac -cp $classpath -d build src/*.java
java -cp $classpath queueprogramat.MsgHelloT
