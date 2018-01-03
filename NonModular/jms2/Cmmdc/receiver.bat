set JMS=e:\JavaApp\MessageQueue5.1.1\mq\lib
java -cp .;%JMS%\jms.jar;%JMS%\imq.jar cmmdc.MsgClientReceiver abc ABC
pause
