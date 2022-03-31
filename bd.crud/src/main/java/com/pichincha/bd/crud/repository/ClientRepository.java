package com.pichincha.bd.crud.repository;

import com.pichincha.bd.crud.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
