package com.github.prgrms.review.repository;

import com.github.prgrms.common.RepositoryTest;
import com.github.prgrms.orders.adapter.persistence.ReviewRepository;
import com.github.prgrms.orders.adapter.persistence.model.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewRepositoryTest extends RepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @DisplayName("테스트 데이터로 입력한 리뷰데이터의 개수 검증")
    @Test
    void reviewCount() {
        List<Review> reviews = reviewRepository.findAll();
//        User user = reviews.get(0).getUser();
//        String email = user.getEmail();
//        Long id = user.getId();
        assertThat(reviews.size()).isEqualTo(1);
    }

}