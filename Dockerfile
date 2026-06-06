# Run stage
FROM openjdk:17
WORKDIR /app

COPY --from=build /app/target/search-0.0.1-SNAPSHOT.jar inventory-search.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "inventory-search.jar"]