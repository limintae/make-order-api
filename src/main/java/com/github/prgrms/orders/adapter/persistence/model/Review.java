package com.github.prgrms.orders.adapter.persistence.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Table(name = "reviews")
@Entity
public class Review implements Serializable {
    @Serial
    private static final long serialVersionUID = -245683166190478328L;

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @NotNull
    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @NotNull
    @Column(name = "product_seq", nullable = false)
    private Long productSeq;

    @NotNull
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_seq", insertable = false, updatable = false)
//    private User user;

    @Builder
    public Review(Long userSeq, Long productSeq, String content) {
        this.userSeq = userSeq;
        this.productSeq = productSeq;
        this.content = content;
    }

    public static Review of(Long userSeq, Long productSeq, String content) {
        return Review.builder()
                .userSeq(userSeq)
                .productSeq(productSeq)
                .content(content)
                .build();
    }

}
