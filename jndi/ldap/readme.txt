javac -d mods *.java

java --module-path mods -m ldap/ldap.LDAPServerCmmdc

java --module-path mods -m ldap/ldap.LDAPClientCmmdc
