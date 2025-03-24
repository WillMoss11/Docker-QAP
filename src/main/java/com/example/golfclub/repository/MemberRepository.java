package com.example.golfclub.repository;

import com.example.golfclub.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContaining(String name);
}
