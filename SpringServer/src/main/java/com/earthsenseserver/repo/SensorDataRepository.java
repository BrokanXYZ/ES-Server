package com.earthsenseserver.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.earthsenseserver.model.SensorData;

public interface SensorDataRepository extends CassandraRepository<SensorData> {

}
