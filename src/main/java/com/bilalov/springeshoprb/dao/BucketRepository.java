package com.bilalov.springeshoprb.dao;

import com.bilalov.springeshoprb.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
}