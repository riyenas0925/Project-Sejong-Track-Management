package kr.ac.sejong.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tbl_member_role")
@EqualsAndHashCode(of = "roleId")
@ToString
public class MemberRole implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, name = "role_enum", columnDefinition = "enum('ADMIN','PRO','STUDENT')") //관리자, 교수, 학생
    @Enumerated(EnumType.STRING)
    private MemberRoleEnum roleEnum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member member;

    @Override
    public String getAuthority() {
        return this.getRoleEnum().toString();
    }

    public MemberRole(){}

    @Builder
    public MemberRole(Long roleId, MemberRoleEnum roleEnum, Member member) {
        this.roleId = roleId;
        this.roleEnum = roleEnum;
        this.member = member;

    }
}
