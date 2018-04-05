# TCP Server
This server runs on port 5005 and accepts TCP messages from running nodes. These messages contain sensor data. The messages are parsed by the server and then inserted into the Cassandra table SensorData.

### Data Format
1. NodeId (UUID)
2. Timestamp (UTC Timestamp)
3. Altitude (Decimal)
4. Humidity (Decimal)
5. Pressure (Decimal)
6. Temperature (Decimal)

**Example Message**
```
8c207df6-2291-451e-baff-d6b053e8c9e4,1346236702,1.0,1.0,1.0,1.0
```



