set GLASSFISH_HOME=e:\JavaApp\payara41
set PATH=%GLASSFISH_HOME%\glassfish\bin;%GLASSFISH_HOME%\bin%PATH%
start appclient -client server\server.jar -targetserver localhost:3700
start appclient -client sender\sender.jar -targetserver localhost:3700 abc ABC
start appclient -client receiver\receiver.jar -targetserver localhost:3700 abc ABC
