
### Project Containerization with Docker

1. Create an executable jar file with Maven and copy the package snapshot name.

   `mvn clean package`

2. Create a docker file `Dockerfile` in the root folder and add information that provides specific instructions to Docker
   such as letting docker COPY the executable jar file from step 1.

3. Create an image from `Dockerfile` with `employee-demo` as the image name.

   `docker build --tag=employee-demo:latest .`

4. Run the container from the created image. Ensure that [Docker Desktop](https://www.docker.com/products/docker-desktop/)
   is running locally.

   `docker run employee-demo`

### Google Cloud Platform Deployment

The sample app has been deployed to google cloud platform by following the following
steps:

1. Login to the Google Cloud Platform with your Google account.

   `gcloud auth login`

2. Project initialization to run App Engine apps within the central region of the US.

   `gcloud app create --region us-central`

3. App deployment to App Engine with Maven - Skips tests and packages the project's executable jar file for deployment.

   `./mvn -DskipTests package appengine:deploy`

4. Visit the deployed app through a generated URL and test it.

   `gcloud app browse`

### Problem

`javax.validation.*` does not exist.

### Cause

Javax API has been bumped to Jakarta API in Spring Boot 3.x. Therefore, `javax.*` imports do not exist.

### Solution

In the plugin set-up with maven, use:

```
<configOptions>

    <useSpringBoot3>true</useSpringBoot3>

</configOptions>
```

[Check out these configuration options](https://openapi-generator.tech/docs/generators/spring/)
