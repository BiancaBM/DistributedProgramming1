javac VisualCmmdc.java
jar cmfv myManifest.mf cmmdc0.jar *.class 
rem Generarea semnaturii
keytool -genkey -keystore myKeystore -alias myself -dname "cn=SE, ou=cs, o=unitbv, l=brasov, c=RO" -keypass abc123 -storepass abc123
keytool -selfcert -alias myself -keystore myKeystore -keypass abc123 -storepass abc123
pause
rem Certificarea resurselor
jarsigner -keystore myKeystore -signedjar cmmdc.jar -keypass abc123 -storepass abc123 cmmdc0.jar myself
jarsigner -verify cmmdc.jar