set PATH=e:\JavaApp\openmq5_1_1\mq\bin;%PATH%
imqobjmgr delete -t qf -l "QueueConnectionFactory" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr delete -t tf -l "TopicConnectionFactory" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr delete -t q -l "queue" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr delete -t t -l "topic" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
