### Problem

`javax.validation.*` does not exist

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

### Sample deployment flags

Works with google cloud function

`gcloud functions deploy employee-function-demo --gen2 --region us-central1 --entry-point functions.EmployeeDemoApplication --runtime java17 --trigger-https --memory 256mb --timeout 90 --max-instances 1 --service-account employee-demo@verdant-art-410710.iam.gserviceaccount.com`

