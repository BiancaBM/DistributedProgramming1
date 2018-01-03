set interface.jar.location=..\i
copy %interface.jar.location%\icmmdc.jar .
jar xfv icmmdc.jar
mkdir build
move cmmdc build
del /Q META-INF
rmdir /Q META-INF
