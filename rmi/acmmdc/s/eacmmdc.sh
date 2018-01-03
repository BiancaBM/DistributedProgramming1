#!/bin/bash
cale=/home/mk/distr/rmi/acmmdc
export CLASSPATH=$cale/s/icmmdc.jar:$cale/s/mods
java -Djava.rmi.server.codebase=file:$cale/s/mods/ -Dmyactivation.impl.codebase=file:$cale/s/mods/ -Dmyactivation.name=CmmdcServer -Dmyactivation.file="" -Dmyactivation.policy=group.policy cmmdc.rmi.s.Setup cmmdc.rmi.s.CmmdcActivabil

