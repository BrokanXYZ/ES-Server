package com.earthsenseserver.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.earthsenseserver.model.Node;

public interface NodeRepository extends CassandraRepository<Node> {

}
