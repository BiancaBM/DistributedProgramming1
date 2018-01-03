#!/bin/bash
/home/mk/JavaApp/mq/bin/imqobjmgr add -t qf -l "QueueConnectionFactory" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
/home/mk/JavaApp/mq/bin/imqobjmgr add -t tf -l "TopicConnectionFactory" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
/home/mk/JavaApp/mq/bin/imqobjmgr add -t q -l "queue" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
/home/mk/JavaApp/mq/bin/imqobjmgr add -t t -l "topic" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
