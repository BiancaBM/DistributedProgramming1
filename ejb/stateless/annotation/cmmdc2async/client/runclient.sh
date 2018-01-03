#!/bin/bash
GLASSFISH_HOME=/home/mk/JavaApp/glassfish5
$GLASSFISH_HOME/glassfish/bin/appclient -client dist/cmmdc-iiop.jar -targetserver localhost:3700 
