package com.github.prgrms.review.entity;

import com.github.prgrms.users.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reviews")
@Entity
public class Review implements Serializable {
    @Serial
    private static final long serialVersionUID = -245683166190478328L;

    @Id
    @NotNull
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_id_seq")
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

    @NotNull
    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_seq", insertable = false, updatable = false)
    @JoinColumn(name = "user_seq")
    private User user;

    @Builder
    public Review(Long seq, Long userSeq, Long productSeq, String content, LocalDateTime createAt) {
        this.seq = seq;
        this.userSeq = userSeq;
        this.productSeq = productSeq;
        this.content = content;
        this.createAt = createAt;
    }

}
