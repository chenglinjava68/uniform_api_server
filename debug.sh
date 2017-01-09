rm -rf target
git checkout src/
git pull
cp src/main/resources/application.debug.yml src/main/resources/application.yml
mvn clean
mvn install
java -jar target/bsapp-1.0.jar 
