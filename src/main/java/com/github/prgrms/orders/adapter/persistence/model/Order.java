package com.github.prgrms.orders.adapter.persistence.model;

import com.github.prgrms.orders.application.enums.OrderStatus;
import com.github.prgrms.review.entity.Review;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    private Long seq;

    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "product_seq", nullable = false)
    private Long productSeq;

    @Column(name = "review_seq", unique = true)
    private Long reviewSeq;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus state;

    @Column(name = "request_msg", length = 1000)
    private String requestMsg;

    @Column(name = "reject_msg", length = 1000)
    private String rejectMsg;

    @Column(name = "completed_at")
    @UpdateTimestamp
    private LocalDateTime completedAt;

    @Column(name = "rejected_at")
    @UpdateTimestamp
    private LocalDateTime rejectedAt;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_seq", insertable = false, updatable = false)
    private Review review;

    @Builder
    public Order(
            Long userSeq,
            Long productSeq,
            Long reviewSeq,
            OrderStatus state,
            String requestMsg,
            String rejectMsg,
            LocalDateTime completedAt,
            LocalDateTime rejectedAt
    ) {
        this.userSeq = userSeq;
        this.productSeq = productSeq;
        this.reviewSeq = reviewSeq;
        this.state = state;
        this.requestMsg = requestMsg;
        this.rejectMsg = rejectMsg;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
    }

}
