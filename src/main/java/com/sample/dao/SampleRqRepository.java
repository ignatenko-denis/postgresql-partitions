package com.sample.dao;

import com.sample.entity.SampleRq;
import com.sample.entity.SampleRqPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRqRepository extends PagingAndSortingRepository<SampleRq, SampleRqPk> {
    Page<SampleRq> findByCode(String code, Pageable pageable);
}