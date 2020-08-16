# Container based experiments

Caveats
- Spring boot dependency is imported and bom is not the parent, hence copied most of the plugins from the bom


## Run using Redhat CRC; push a docker images to openshift/crc registry

This is a repo on experiments on OpenShift using RedHat's Code Ready Containers

To prepare CRC on ubuntu. Use ubuntuansible repo.
1. Create a project eg
 
    ``oc new-project test-sample-app``
    
2. Login to the docker
 
    ``docker login -u $(oc whoami) -p $(oc whoami -t) default-route-openshift-image-registry.apps-crc.testing``

3. Build maven
    
    ``mvn clean install -Plocal``   
    
    

## Run using Docker
```
# Run locally
docker run -it --rm -p 8080:8080 my-project/generate-spanishcards-service
```

## Run using Docker Compose
```
cd docker-compose
docker-compose stop && docker-compose rm -f && docker-compose up -d

# logs
docker-compose logs -f
```      