package com.amanee.shope.repository;

import com.amanee.shope.entity.BathOrder;
import com.amanee.shope.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BathOrderRepository extends JpaRepository<BathOrder,Integer> {
        Optional <BathOrder> findByUser(User user);
}
