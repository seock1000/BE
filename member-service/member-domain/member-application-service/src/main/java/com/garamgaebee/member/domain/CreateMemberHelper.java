package com.garamgaebee.member.domain;

import com.garamgaebee.member.domain.dto.CreateMemberCommand;
import com.garamgaebee.member.domain.ports.out.MemberRepository;
import com.garamgaebee.member.domain.valueobject.MemberType;
import com.garamgaebee.member.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateMemberHelper {

    private final MemberRepository memberRepository;

    @Autowired
    public CreateMemberHelper(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public UUID persistMember(Member member) {
        return memberRepository.persistMember(member);
    }

    public Member createMember(CreateMemberCommand req){
        return Member.builder()
                .memberIdx(req.getMemberIdx())
                .memberName(req.getMemberName())
                .nickname(req.getNickname())
                .dept(req.getDept())
                .type(MemberType.values()[req.getMemberType()]).build();
    }
}