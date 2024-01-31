clear && mvn clean install 

tomcatBin=$HOME/Documents/apache-tomcat-10.0.27/bin
tomcatWebapps=$HOME/Documents/apache-tomcat-10.0.27/webapps

cp target/filter.war $tomcatWebapps/

cd $tomcatBin

./catalina.sh stop
./catalina.sh start
