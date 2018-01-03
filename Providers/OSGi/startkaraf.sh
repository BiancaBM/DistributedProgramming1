KARAF_HOME=/home/mk/JavaApp/apache-karaf-4.1.3
rm -r $KARAF_HOME/lock
rm  $KARAF_HOME/data/log/*
rm -r $KARAF_HOME/instances

$KARAF_HOME/bin/karaf clean
