# Docker Images and Openshift
This is a repo on experiments on OpenShift using RedHat's Code Ready Containers

To prepare CRC on ubuntu. Use ubuntuansible repo.


## To push a docker images to openshift/crc registry
1. Create a project eg
 
    ``oc new-project test-sample-app``
    
2. Login to the docker
 
    ``docker login -u $(oc whoami) -p $(oc whoami -t) default-route-openshift-image-registry.apps-crc.testing``

3. Build maven
    
    ``mvn clean install -Plocal``   
    
    
## Caveats
- Spring boot dependency is imported and bom is not the parent, hence copied most of the plugins from the bom      