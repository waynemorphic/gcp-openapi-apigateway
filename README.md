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
