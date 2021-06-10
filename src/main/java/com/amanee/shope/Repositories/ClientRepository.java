package com.amanee.shope.Repositories;

import com.amanee.shope.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
