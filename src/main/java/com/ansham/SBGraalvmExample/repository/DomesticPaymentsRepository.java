package com.ansham.SBGraalvmExample.repository;


import com.ansham.SBGraalvmExample.model.DPRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomesticPaymentsRepository extends JpaRepository<DPRequest, Long> {
    DPRequest findByConsentid(long consentid);
}
