package com.example.golfclub.repository;

import com.example.golfclub.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    List<Tournament> findByLocationContaining(String location);
}

