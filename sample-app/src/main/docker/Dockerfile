FROM oceanebelle/openjdk:latest

COPY /maven/${project.build.finalName}.${project.packaging} /${project.artifactId}.${project.packaging}

WORKDIR $APP_HOME

EXPOSE 8080

USER oceane

ENTRYPOINT ["java", "-jar", "/${project.artifactId}.${project.packaging}"]
