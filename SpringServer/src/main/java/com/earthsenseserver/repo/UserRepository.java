package com.earthsenseserver.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.earthsenseserver.model.User;

public interface UserRepository extends CassandraRepository<User> {

}
