package com.earthsenseserver.repo;



import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;
import java.util.List;
import com.earthsenseserver.model.SensorData;

public interface SensorDataRepository extends CassandraRepository<SensorData> {
	List<SensorData> findByNodeId(UUID nodeId);
}
