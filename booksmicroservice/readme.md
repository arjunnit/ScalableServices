# TO RUN THE APPLICATION LOCALLY

    ./gradlew bootRun
        RUN JUST THE SQL SERVICE WITH DOCKER AND CHANGE SQL URL TO:
        spring.datasource.url=jdbc:mysql://localhost:3306/bookdb

# TO BUILD JAR FILE USED BY DOCKERFILE AND THEN THE DOCKER COMPOSE

    ./gradlew clean build
        CHANGE SQL URL TO:
        spring.datasource.url=jdbc:mysql://mysql:3306/bookdb

# OpenAPI JSON available at: http://localhost:8080/v3/api-docs

# Swagger UI available at: http://localhost:8080/swagger-ui.html

# TO START SQL SERVICE AND THE SPRINGBOOT SERVICE

    Go to bookmicroservice root folder
    open terminal
    execute ./gradlew clean build
    execute "docker-compose up --build"

# TO STOP SQL SERVICE

    open terminal
    execute "docker-compose down"

# Check Docker Container Status

    docker ps
    Look for your MySQL container in the output.
    0.0.0.0:3306->3306 confirms that MySQL is exposed on port 3306 on your localhost.
    The STATUS column should show Up X seconds/minutes
    If you don’t see the container, it might not be running. Start it with:
    docker start mysql-container

# Check MySQL Logs

    To check if the MySQL container started without errors:
    docker logs mysql-container
    You should see output indicating that MySQL is ready to accept connections, such as:
        [Server] /usr/sbin/mysqld: ready for connections.
        Version: '8.0.xx'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306

# Connect to SQL via prompt

    docker ps
    (Get name of container from the above and use it in place of "mysql-container" below)
    docker exec -it mysql-container mysql -u root -p
    password = rootpassword
    SHOW DATABASES;
    USE bookdb;
    SHOW TABLES;
    DESCRIBE books;
