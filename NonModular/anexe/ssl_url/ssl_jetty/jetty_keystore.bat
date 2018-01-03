rem Generarea semnaturii

keytool -genkey -alias jetty -keyalg RSA -keystore keystore -dname "cn=localhost, ou=cs, o=unitbv, l=brasov, c=RO" -keypass 1q2w3e -storepass 1q2w3e

