package com.example.golfclub.controller;

import com.example.golfclub.model.Member;
import com.example.golfclub.service.MemberService;
import com.example.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    // Search members by name
    @GetMapping("/search")
    public List<Member> getMemberByName(@RequestParam String name) {
        return memberRepository.findByNameContaining(name);
    }

    // Add a new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}

