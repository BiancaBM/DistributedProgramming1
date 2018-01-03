set GLASSFISH_HOME=e:\JavaApp\payara41
set PATH=%GLASSFISH_HOME%\glassfish\bin;%GLASSFISH_HOME%\bin%PATH%
appclient -client server\server.jar -targetserver localhost:3700

