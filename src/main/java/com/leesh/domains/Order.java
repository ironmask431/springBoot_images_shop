package com.leesh.domains;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders") //실제 DB테이블명 다르게 적용 시
@Getter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id") //실제 DB컬럼명 다르게 설정필요할 시
    private Long id;

    //joinColumn 을 설정한곳이 연관관계의 주인. 두 엔티티의 관계를 변경하려면 연관관계 주인엔티티의 값을 변경하면 된다.
    @ManyToOne //Order 다 : 1 Member 관계이므로
    @JoinColumn(name = "member_id") //Member 테이블의 어떤 DB컬럼으로 join할지 설정
    private Member memeber;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDateTime;

    private OrderStatus orderStatus; //주문상태 ORDER, CANCEL
}