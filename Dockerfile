# Use the official gradle image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:8.5 as builder
LABEL stage=builder

# Copy local code to the container image.
COPY ./* ./
COPY src ./src

# Build a release artifact.
RUN gradle clean build --no-daemon

# Use the Official OpenJDK image for a lean production stage of our multi-stage build.
# https://hub.docker.com/_/openjdk
# https://docs.docker.com/develop/develop-images/multistage-build/#use-multi-stage-builds
FROM openjdk:21-jdk

# Copy the jar to the production image from the builder stage.
COPY --from=builder /home/gradle/build/libs/nuklearni-okurky-all.jar /nuklearni-okurky.jar

# Run the web service on container startup.
CMD [ "java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/nuklearni-okurky.jar" ]