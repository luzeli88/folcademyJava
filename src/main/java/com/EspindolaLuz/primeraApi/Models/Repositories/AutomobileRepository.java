package com.EspindolaLuz.primeraApi.Models.Repositories;

import com.EspindolaLuz.primeraApi.Models.Entities.AutomobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Integer> {
    List<AutomobileEntity> findAllByUserId(Integer id);
}
