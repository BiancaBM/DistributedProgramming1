#!/bin/bash
GroupID=cmmdc.socket.server
ArtifactID=server
Version=1.0
mvn archetype:generate -DgroupId=$GroupID -DartifactId=$ArtifactID -Dversion=$Version -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
