# REST-poc
This POS displays list of products from the application

## Setup instruction

1. Setup Docker on your system
  https://docs.docker.com/docker-for-mac/
2. Make sure docker is running on the machine
3. Clone the repository to your local machine
4. run gradle build  'gradle build buildDocker'
5. You may get an error 'Docker execution failed
  Command line [docker push demo:latest] returned:
  unauthorized: authentication required' 
6. Ignore this error .
7. On command line type 'docker images' to confirm the image demo is installed
8. Start the application image 'docker run -p 8080:8080 -t demo'
9. Go to http://localhost:8080/swagger-ui.html to test the app
