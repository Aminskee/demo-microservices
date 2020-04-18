FROM ibmcom/db2
USER root
RUN yum install -y gettext

RUN mkdir /var/custom

COPY db.sql_template /var/custom
COPY run.sh /var/custom
RUN chmod a+x /var/custom/run.sh

