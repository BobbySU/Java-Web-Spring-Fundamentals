package com.example.battleships.repository;

import com.example.battleships.models.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, String> {
    Optional<Ship> findByName(String name);
    Optional<List<Ship>> findAllByUserId(String Id);
}
