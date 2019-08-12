#!/usr/bin/env bash

set -e
echo "------------------------------ GIT CHECKOUT . ------------------------------";
git checkout .;
echo "------------------------------ GIT PULL ------------------------------";
git pull;
echo "------------------------------ MVN CLEAN ------------------------------";
mvn clean;
echo "------------------------------ MVN PACKAGE ------------------------------";
mvn package -P SERVER-LIVE;
echo "------------------------------ TOMCAT STOP ------------------------------";
sudo sh /opt/tomcat/bin/shutdown.sh
echo "------------------------------ NGINX STOP ------------------------------";
sudo service nginx stop
echo "------------------------------ WEBAPP REPLACE ------------------------------";
sudo cp /home/ubuntu/aap_project/target/ROOT.war /opt/tomcat/webapps/ROOT.war
echo "------------------------------ TOMCAT START ------------------------------";
sudo sh /opt/tomcat/bin/startup.sh
echo "------------------------------ NGINX START  ------------------------------";
sudo service nginx start
