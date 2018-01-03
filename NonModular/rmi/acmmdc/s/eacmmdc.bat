rem start startrmiregistry.bat
rem start rmid -J-Djava.security.policy=rmid.policy -J-Dmyactivation.policy=group.policy 
rem pause
set cale=e:/mk/distr/rmi0/acmmdc
set classpath=%cale%/s/icmmdc.jar;%cale%/s/build
java -Djava.rmi.server.codebase=file:%cale%/s/build/ -Dmyactivation.impl.codebase=file:%cale%/s/build/ -Dmyactivation.name=CmmdcServer -Dmyactivation.file="" -Dmyactivation.policy=group.policy cmmdc.rmi.s.Setup cmmdc.rmi.s.CmmdcActivabil
