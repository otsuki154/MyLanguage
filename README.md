
# Steps to Setup

## 1. Clone the application

git clone https://github.com/otsuki154/MyLanguage.git

## 2. Create Mysql database

create database springmybatis

## 3. Run the script file

Run the script file queries.sql attached to the project

## 4. Change mysql username and password as per your installation

open src/main/java/resources/mybatis-config.xml

change username and password as per your mysql installation

## 5. Build and run the app using maven

mvn package

The app will start running at http://localhost:8080/ML/.
