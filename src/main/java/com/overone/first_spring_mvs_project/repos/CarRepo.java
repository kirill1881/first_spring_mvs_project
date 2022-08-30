package com.overone.first_spring_mvs_project.repos;

import com.overone.first_spring_mvs_project.models.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<CarModel, Long> {
    CarModel findById(long id);
}
