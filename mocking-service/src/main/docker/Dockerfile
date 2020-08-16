FROM oceanebelle/openjdk:latest

RUN set -eux; \
    groupadd -r app --gid=1000; \
    useradd -r -g app --uid=1000 app;

USER app

COPY /maven/${project.build.finalName}.${project.packaging} $APP_HOME/${project.artifactId}.${project.packaging}
COPY /maven/__files $APP_HOME/__files
COPY /maven/config $APP_HOME/config

WORKDIR $APP_HOME

EXPOSE 8080

CMD ["java", "-jar", "${project.artifactId}.${project.packaging}"]
