set cale=d:/mk/distr/rmi/acmmdc

java -Djava.rmi.server.codebase=file:%cale%/s/mods/ -Dmyactivation.impl.codebase=file:%cale%/s/mods/ -Dmyactivation.name=CmmdcServer -Dmyactivation.file="" -Dmyactivation.policy=group.policy --module-path %cale%/s/mods -m scmmdc/cmmdc.rmi.s.Setup cmmdc.rmi.s.CmmdcActivabil
