set PATH=e:\JavaApp\openmq5_1_1\mq\bin;%PATH%
imqobjmgr add -t qf -l "QueueConnectionFactory" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr add -t tf -l "TopicConnectionFactory" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr add -t q -l "queue" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr add -t t -l "topic" -j java.naming.provider.url=file:///e:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 