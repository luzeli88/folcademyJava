package com.EspindolaLuz.primeraApi.Models.Repositories;

import com.EspindolaLuz.primeraApi.Models.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
