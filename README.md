# Experiment 10: Multi-Container Infrastructure Setup & Deployment using Docker Compose

## Project contents
- `app-service`: Spring Boot REST application running on port 8080.
- `app-db`: PostgreSQL database running on port 5432.
- `docker-compose.yml`: configures both containers, environment variables, shared network, persistent volume, and database health check.
- `Dockerfile`: builds and runs the Spring Boot application.

## Import into Spring Tool Suite (STS)
1. Extract this ZIP file.
2. Open STS.
3. Select **File > Import > Maven > Existing Maven Projects**.
4. Browse to the extracted `Experiment10_Docker_Compose_STS` folder.
5. Select the detected `pom.xml`, then click **Finish**.
6. Wait for Maven dependencies to download.

## Run with Docker Compose
Make sure Docker Desktop is installed and running. Open a terminal in the extracted project folder and run:

```bash
docker compose up -d --build
```

Check that both containers are running:

```bash
docker compose ps
```

## Test the deployment
Send a GET request to:

```text
http://localhost:8080/api/data
```

You can open the URL in a browser or use:

```bash
curl http://localhost:8080/api/data
```

The endpoint runs a SQL query against PostgreSQL and returns the database name, server timestamp, and a success message. A successful response confirms that the Spring Boot container communicates with the database container.

## Stop the containers

```bash
docker compose down
```

To also delete the persisted database volume:

```bash
docker compose down -v
```

Warning: `docker compose down -v` deletes the database data stored in the volume.
"# 2400032073-SOAEndSemSkill" 
