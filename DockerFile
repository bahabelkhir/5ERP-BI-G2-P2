FROM adoptopenjdk:11-jdk-hotspot
EXPOSE 8082
ADD target/mohamedazizbenzina-5erp-bi7-g2:1.0.jar mohamedazizbenzina-5erp-bi7-g2:1.0.jar
ENTRYPOINT ["java","-jar","/mohamedazizbenzina-5erp-bi7-g2:1.0.jar"]