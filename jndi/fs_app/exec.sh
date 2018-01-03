#!/bin/bash
javac -d mods *.java
java --module-path mods -cp fscontext-4.4.2.jar -Djava.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory -m fs/fs.Lookup


