# ES-SpringServer

RESTful API used by web client to interact with the Cassandra database.

## Nodes
1. **GET: /node**

    Returns all nodes.

2. **GET: /node/{nodeId}**

    Returns node with the specified id.
    
3. **POST: /node/create**

    Create a node based upon the received node object. The node's id and status will be set by the server. The id with "UUIDs.timeBased()" and the status set to 0.
    
```
{
	"owner": "10ad2d26-75dd-44dc-975e-5badc018db11",
	"nodeName": "SuperCoolName",
	"latitude": 12.5,
	"longitude": 68.3,
	"city": "Little Rock",
	"state": "Arkansas",
	"country": "United States"
}
```

4. **PUT: /node/{nodeId}**

    Update node, with the specified id, to match the recieved node object.
    
5. **DELETE: /node/{nodeId}**

    Delete node with the specified id.
    
    
## Users
1. **GET: /user**

    Returns all users.

2. **GET: /user/{userId}**

    Returns user with the specified id.
    
3. **POST: /user/create**

    Create a user based upon the received user object. The user's id will be set by the server with "UUIDs.timeBased()".
    
```
{
	"permissionId": "1",
	"username": "Chuck",
	"password": "PASSWORD",
	"email": "getrichquick@chuck.edu"
}
```

4. **PUT: /user/{userId}**

    Update user, with the specified id, to match the recieved user object.
    
5. **DELETE: /user/{userId}**

    Delete user with the specified id.
    
    
## Sensor Data
1. **GET: /sensordata**

    Returns all sensor data.

2. **GET: /sensordata/{nodeId}**

    Returns all sensor data for the specified node.
    
