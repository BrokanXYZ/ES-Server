import socket
import threading
import uuid
from datetime import datetime
from decimal import Decimal
from cassandra.cluster import Cluster

class ThreadedServer(object):
    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        self.sock.bind((self.host, self.port))

    def listen(self):
        self.sock.listen(5)
        while True:
            client, address = self.sock.accept()
            client.settimeout(60)
            threading.Thread(target = self.listenToClient,args = (client,address)).start()

    def listenToClient(self, client, address):
        size = 1024
        while True:
            try:
                # Data Format (CSV)
                #   0. NodeId
                #   1. Timestamp
                #   2. Altitude
                #   3. Humidity
                #   4. Pressure
                #   5. Temperature
				#	6. Latitude
				#	7. Longitude

                # Decode and split data
                data = client.recv(size).decode("utf-8").split(",");

                # Else data is not in the correct format
                if len(data) == 8:

                    # Log Message
                    print(datetime.now()) 
                    print("     Data recieved from...")
                    print("         Address: ", address)
                    print("         NodeId:  ", data[0])
                    print(data[0], ", ",data[1], ", ",data[2], ", ",data[3], ", ",data[4], ", ",data[5], ", ",data[6], ", ",data[7])

                    # Connect to Cassandra
                    cluster = Cluster();
                    session = cluster.connect('earthsense')


                    # Insert data into SensorData table
                    session.execute(
                        """
                        INSERT INTO sensordata (nodeid, timestamp, altitude, humidity, pressure, temp, latitude, longitude)
                        VALUES (%s, %s, %s, %s, %s, %s, %s, %s)
                        """,
                        (uuid.UUID(data[0]), datetime.fromtimestamp(Decimal(data[1])), Decimal(data[2]), Decimal(data[3]), Decimal(data[4]), Decimal(data[5]), Decimal(data[6]), Decimal(data[7]))
                    )

                    # Let client know data has been successfully submitted
                    client.send(b'ACK')


                else:
                    client.send(b'ERROR: Incorrect data format.')

            except:
                client.close()
                return False

if __name__ == "__main__":
    ThreadedServer('',5005).listen()
