package com.example.golfclub.controller;

import com.example.golfclub.model.Member;
import com.example.golfclub.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MemberControllerTest {

    @Mock
    private MemberRepository memberRepository;

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

        when(memberRepository.findAll()).thenReturn(Arrays.asList(member1, member2));

        // When
        List<Member> members = memberController.getAllMembers();

        // Then
        assertEquals(2, members.size());
        verify(memberRepository, times(1)).findAll();
    }

    @Test
    void testGetMemberByName() {
        // Given
        Member member = new Member();
        member.setId(1L);
        member.setName("John Doe");

        when(memberRepository.findByNameContaining("John")).thenReturn(Arrays.asList(member));

        // When
        List<Member> members = memberController.getMemberByName("John");

        // Then
        assertEquals(1, members.size());
        assertEquals("John Doe", members.get(0).getName());
        verify(memberRepository, times(1)).findByNameContaining("John");
    }
}


