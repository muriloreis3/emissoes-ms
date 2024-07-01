package com.emissor_ms.core.repository;

import com.emissor_ms.core.entity.PropostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity, Integer> {
}
