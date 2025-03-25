package com.example.golfclub.controller;

import com.example.golfclub.model.Member;
import com.example.golfclub.repository.MemberRepository;
import com.example.golfclub.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MemberControllerTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMembers() {
        // Given
        Member member1 = new Member();
        member1.setId(1L);
        member1.setName("John Doe");

        Member member2 = new Member();
        member2.setId(2L);
        member2.setName("Jane Doe");

        when(memberService.getAllMembers()).thenReturn(Arrays.asList(member1, member2));

        // When
        List<Member> members = memberController.getAllMembers();

        // Then
        assertEquals(2, members.size());
        verify(memberService, times(1)).getAllMembers();
    }

    @Test
    void testGetMemberByName() {
        // Given
        Member member = new Member();
        member.setId(1L);
        member.setName("John Doe");

        when(memberRepository.findByNameContaining("John")).thenReturn(Arrays.asList(member));

        // When
        List<Member> response = memberController.getMemberByName("John");

        // Then
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals("John Doe", response.get(0).getName());
        verify(memberRepository, times(1)).findByNameContaining("John");
    }
}




