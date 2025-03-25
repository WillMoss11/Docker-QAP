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

    @GetMapping("/test")
    public String test() {
        return "Controller is working!"; // Tested it, this works but everything else is throwing 404
    }

    // search the members by name
    @GetMapping("/search")
    public List<Member> getMemberByName(@RequestParam String name) {
        return memberRepository.findByNameContaining(name);
    }

    // to add new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    // get all the members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}

