package com.overone.first_spring_mvs_project.repos;

import com.overone.first_spring_mvs_project.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel, Long> {
}
