package com.amanee.shope.repository;

import com.amanee.shope.entity.BathOrder;
import com.amanee.shope.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BathOrderRepository extends JpaRepository<BathOrder,Integer> {
        BathOrder findByUser(User user);
       BathOrder findByUserEmail(String email);
}
