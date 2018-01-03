set GLASSFISH_HOME=e:\JavaApp\payara41
set PATH=%GLASSFISH_HOME%\glassfish\bin;%GLASSFISH_HOME%\bin%PATH%
appclient -client sender\sender.jar -targetserver localhost:3700 abc ABC

