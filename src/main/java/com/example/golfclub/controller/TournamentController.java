package com.example.golfclub.controller;

import com.example.golfclub.model.Tournament;
import com.example.golfclub.repository.TournamentRepository;
import com.example.golfclub.repository.MemberRepository;
import com.example.golfclub.service.TournamentService;
import com.example.golfclub.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    // add members to a tournament
    @PostMapping("/{tournamentId}/members")
    public Tournament addMembersToTournament(@PathVariable Long tournamentId, @RequestBody List<Long> memberIds) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();

        // find members by their IDs
        List<Member> members = memberRepository.findAllById(memberIds);

        // add the members to the tournament
        tournament.getParticipatingMembers().addAll(members);

        // save the updated tournament
        return tournamentRepository.save(tournament);
    }

    // search tournaments by location
    @GetMapping("/search")
    public List<Tournament> searchTournamentsByLocation(@RequestParam String location) {
        return tournamentRepository.findByLocationContaining(location);
    }

    //to create new tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // to get all the tournament
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // to get a specific tournament by its ID
    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentRepository.findById(id);
    }

    //To update an existing tournament
    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable Long id, @RequestBody Tournament tournamentDetails) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);
        if (tournamentOptional.isPresent()) {
            Tournament tournament = tournamentOptional.get();
            tournament.setStartDate(tournamentDetails.getStartDate());
            tournament.setEndDate(tournamentDetails.getEndDate());
            tournament.setLocation(tournamentDetails.getLocation());
            tournament.setEntryFee(tournamentDetails.getEntryFee());
            tournament.setCashPrizeAmount(tournamentDetails.getCashPrizeAmount());
            tournament.setParticipatingMembers(tournamentDetails.getParticipatingMembers());
            return tournamentRepository.save(tournament);
        }
        return null; // return null or throw exception if not found
    }

    // to delete a tournament by its ID
    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentRepository.deleteById(id);
    }
}

