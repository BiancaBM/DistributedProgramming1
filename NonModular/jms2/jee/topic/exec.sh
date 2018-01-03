#!/bin/bash
GLASSFISH_HOME=/home/mk/JavaApp/glassfish5
export PATH=$GLASSFISH_HOME/glassfish/bin:$PATH
xterm -hold -e appclient -client subscriber/subscriber.jar &
xterm -hold -e appclient -client publisher/publisher.jar &

# -targetserver localhost:3700
