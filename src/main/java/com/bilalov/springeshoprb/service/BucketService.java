package com.bilalov.springeshoprb.service;

import com.bilalov.springeshoprb.domain.Bucket;
import com.bilalov.springeshoprb.domain.User;
import com.bilalov.springeshoprb.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);
}