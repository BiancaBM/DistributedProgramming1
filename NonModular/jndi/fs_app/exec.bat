set classpath=.;fscontext-4.4.2.jar

javac -Xlint Lookup.java
java -Djava.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory Lookup
