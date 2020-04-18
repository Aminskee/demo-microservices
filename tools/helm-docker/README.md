# Summary

Our helm-deployment requires a container with Kubernetes and Helm. The corresponding docker-image is built manually and pushed to the ODM Docker Registry.

## Versions:
- Kubernetes: v1.13.6
- Helm: v2.14.3

## Manual Deployment Process
 
### Local Build
docker build --build-arg KUBE_VERSION="v1.13.6" --build-arg HELM_VERSION="v2.14.3" --tag demo.com/rr-demo
/demo/docker-helm:latest .

### Push to ODM Docker Registry
docker login demo.com (with AccessToken for Api)
docker push demo.com/rr-demo/demo/docker-helm:latest
