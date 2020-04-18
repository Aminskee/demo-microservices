# demo-microservices


## Contents

- `apps/`: The deployables of our system
- `env/`: Value-maps for our envirionments
- `env/local`: Configuration files and deployables for local development
- `tools/`: Deployables and executables that are not part of the core system (e.g. swagger-ui, system-test)
- `docker-compose.yml`: Docker-compose setup for local development
- `.env.sample`: Template for docker-compose `.env` file

## Local Setup

To run the project locally, use the `docker-compose.yml`. To build the images, the `db` container needs to be running.

```
docker-compose up -d db
docker-compose up -d --build
docker-compose logs -f
```

#### Java
We are using Java 8
