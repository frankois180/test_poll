package com.testsurvey.infrastructure.adapter.repository.jpa;

import com.testsurvey.infrastructure.adapter.repository.entity.PollJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PollJpaRepository extends JpaRepository<PollJpaEntity,Long> {

    Optional<PollJpaEntity>  findByCode(String code);
}
