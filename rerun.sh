rm -rf target
git checkout src/
git pull
rm src/main/resources/application.debug.yml
mvn clean
mvn install
java -jar target/bsapp-1.0.jar 
