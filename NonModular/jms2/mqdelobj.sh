#!/bin/bash
/home/mk/JavaApp/mq/bin/imqobjmgr delete -t qf -l "QueueConnectionFactory" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
/home/mk/JavaApp/mq/bin/imqobjmgr delete -t tf -l "TopicConnectionFactory" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
/home/mk/JavaApp/mq/bin/imqobjmgr delete -t q -l "queue" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
/home/mk/JavaApp/mq/bin/imqobjmgr delete -t t -l "topic" -j java.naming.provider.url=file:///home/mk/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
