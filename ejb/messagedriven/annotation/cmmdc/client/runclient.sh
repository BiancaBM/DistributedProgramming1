#!/bin/bash
GLASSFISH_HOME=/home/mk/JavaApp/glassfish5
$GLASSFISH_HOME/glassfish/bin/appclient -client dist/cmmdc_sender.jar -targetserver localhost:3700 
$GLASSFISH_HOME/glassfish/bin/appclient -client dist/cmmdc_receiver.jar -targetserver localhost:3700 

