#!/bin/bash
GLASSFISH_HOME=/home/mk/JavaApp/glassfish5
export PATH=$GLASSFISH_HOME/glassfish/bin:$PATH
xterm -hold -e appclient -client server/server.jar -targetserver localhost:3700 &
xterm -hold -e appclient -client sender/sender.jar -targetserver localhost:3700 abc ABC &
xterm -hold -e appclient -client receiver/receiver.jar -targetserver localhost:3700 abc ABC &

