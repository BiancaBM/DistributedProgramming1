javac -d mods src/*.java src/client/*.java

java --module-path mods -m client/cmmdc.socket.client.CmmdcClient

java --module-path mods -m client/cmmdc.socket.client.ClientFXCmmdc

java --module-path mods -m client/cmmdc.socket.client.VisualCmmdcClient




