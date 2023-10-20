package com.fetchchallenge.fetchchallenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReceiptRepository extends CrudRepository<Receipt, UUID> {

}