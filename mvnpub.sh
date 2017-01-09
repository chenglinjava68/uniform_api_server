#!/usr/bin/expect
git pull
rm target/qqvisa.war
mvn compile war:war
expect mvnpub2.expect
