#!/bin/bash
GLASSFISH_HOME=/home/mk/JavaApp/glassfish5
$GLASSFISH_HOME/glassfish/bin/appclient -client dist/simple-client.jar -targetserver localhost:3700 
