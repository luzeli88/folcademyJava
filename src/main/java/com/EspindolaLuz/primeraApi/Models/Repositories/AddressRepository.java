package com.EspindolaLuz.primeraApi.Models.Repositories;

import com.EspindolaLuz.primeraApi.Models.Entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
