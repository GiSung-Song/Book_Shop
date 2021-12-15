package com.shop.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class Cart extends BaseEntity{

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) //1:1매핑, FetchType.Lazy 지연 로딩, 지연 로딩 설정 시 실제 엔티티 대신 HibernateProxy 객체를 넣어둠.
    @JoinColumn(name = "member_id") //외래키를 지정,
    private Member member;
}
