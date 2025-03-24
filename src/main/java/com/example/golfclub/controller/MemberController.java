package com.example.golfclub.controller;

import com.example.golfclub.model.Member;
import com.example.golfclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.golfclub.repository.MemberRepository;

import java.util.List;


@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    // Search members by name
    @GetMapping("/search")
    public List<Member> searchMembersByName(@RequestParam String name) {
        return memberRepository.findByNameContaining(name);
    }

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // End for adding new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    // End for getting all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
