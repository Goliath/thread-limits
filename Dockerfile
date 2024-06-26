# Use an official Java runtime as a parent image
FROM azul/zulu-openjdk-alpine:22
# Set the working directory in the container to /app
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/threadLimits-1.0-SNAPSHOT.jar /app

# Run the application when the container launches
CMD ["java", "-jar", "threadLimits-1.0-SNAPSHOT.jar"]