FROM adoptopenjdk/openjdk11:alpine

ARG KUBE_VERSION
ARG HELM_VERSION

USER root

RUN apk add --no-cache -t deps  \
    && apk add --no-cache ca-certificates curl docker \
    && curl -L https://storage.googleapis.com/kubernetes-release/release/${KUBE_VERSION}/bin/linux/amd64/kubectl -o /usr/local/bin/kubectl \
    && chmod +x /usr/local/bin/kubectl \
    && curl -L http://storage.googleapis.com/kubernetes-helm/helm-${HELM_VERSION}-linux-amd64.tar.gz -o /tmp/helm-${HELM_VERSION}-linux-amd64.tar.gz \
    && tar -zxvf /tmp/helm-${HELM_VERSION}-linux-amd64.tar.gz -C /tmp \
    && mv /tmp/linux-amd64/helm  /usr/local/bin/helm \
    && mkdir -p ~/.kube \
    && chmod +x /usr/local/bin/helm
    #&& pip install --upgrade pip \
    #&& pip install -r requirements.txt \
  #  && apk del --purge deps py-pip \
   # && rm -rf /tmp/*

WORKDIR /root
