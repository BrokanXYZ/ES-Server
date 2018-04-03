package com.earthsenseserver.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class SensorDataKey implements Serializable {

  @PrimaryKeyColumn(name = "nodeid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private UUID nodeId;

  @PrimaryKeyColumn(name = "timestamp", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
  private Date timestamp;

  
  public SensorDataKey(UUID nodeId, Date timestamp){
	  this.nodeId = nodeId;
	  this.timestamp = timestamp;
  }
  
  public UUID getNodeId() {
    return nodeId;
  }

  public void setNodeId(UUID nodeId) {
    this.nodeId = nodeId;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
    result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SensorDataKey other = (SensorDataKey) obj;
    if (timestamp == null) {
      if (other.timestamp != null)
        return false;
    } else if (!timestamp.equals(other.timestamp))
      return false;
    if (nodeId == null) {
      if (other.nodeId != null)
        return false;
    } else if (!nodeId.equals(other.nodeId))
      return false;
    return true;
  }
}