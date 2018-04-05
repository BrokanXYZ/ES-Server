import uuid
from datetime import datetime
from decimal import Decimal
from cassandra.cluster import Cluster




# Connect to Cassandra
cluster = Cluster();
session = cluster.connect('earthsense')


# Insert data into SensorData table
session.execute(
"""
INSERT INTO sensordata (nodeid, timestamp, altitude, humidity, pressure, temp)
VALUES (%s, %s, %s, %s, %s, %s)
""",
(uuid.UUID('8c207df6-2291-451e-baff-d6b053e8c9e4'), datetime.fromtimestamp(Decimal(1346236702)), 1.0, 1.0, 1.0, 1.0)
)