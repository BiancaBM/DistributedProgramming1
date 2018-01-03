#!/bin/bash
GLASSFISH_HOME=/home/mk/JavaApp/glassfish5
export PATH=$GLASSFISH_HOME/glassfish/bin:$PATH
xterm -hold -e appclient -client syncrcv/syncrcv.jar &
xterm -hold -e appclient -client sender/sender.jar &
echo "Press any key to continue..."
read -n1 any_key
xterm -hold -e appclient -client asyncrcv/asyncrcv.jar &
xterm -hold -e appclient -client sender/sender.jar &

# -targetserver localhost:3700
