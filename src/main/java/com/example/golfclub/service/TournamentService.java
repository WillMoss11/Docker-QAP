package com.example.golfclub.service;

import com.example.golfclub.model.Tournament;
import com.example.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    //save a new tournament
    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // find a tournament by ID
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    // search tournaments by location
    public List<Tournament> findByLocationContaining(String location) {
        return tournamentRepository.findByLocationContaining(location);
    }
}

