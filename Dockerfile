FROM anapsix/alpine-java
MAINTAINER meksula
COPY computer-alchemist-0.1.jar /home/computer-alchemist-0.1.jar
CMD ["java","-jar","/home/computer-alchemist-0.1.jar"]
