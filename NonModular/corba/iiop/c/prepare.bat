rem set interface.jar.location=..\i
set stub.files.location=..\s
rem copy %interface.jar.location%\icmmdc.jar .
rem jar xfv icmmdc.jar
mkdir build\cmmdc\rmi\i
rem move cmmdc build
rem del /Q META-INF
rem rmdir /Q META-INF
copy %stub.files.location%\build\cmmdc\rmi\i\*.class build\cmmdc\rmi\i