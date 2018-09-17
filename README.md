# ES-Server
These are my contributions to the Earthsense project. I was tasked with working on everything back-end. I configured and maintained the Ubuntu VM and Cassandra DB, wrote a simple TCP server that collects data from our air quality sensors, and developed a REST API with Spring Boot that allows app users to use our collected data.

### SpringServer
A Spring Data application written in Java. Acts as a RESTful API that allows web clients to interact with the Cassandra database.

### SMS Server
Python server that interfaces with the Twilio service to send and recieve SMS messages. We were intially going to use this as the gateway between our nodes and the server, but have since decided to use the TCP server for that purpose.

https://www.twilio.com/


### TCP Server
Multithreaded Python TCP server. Acts as a gateway between nodes and the server. Recieves sensor data from nodes and places that data into Cassandra.

### ngrok
We are using this service to open the TCP server up beyond the firewall.

https://www.ngrok.com/
