package com.ansham.SBGraalvmExample.controller;

import com.ansham.SBGraalvmExample.exceptions.DataNotFound;
import com.ansham.SBGraalvmExample.model.DPRequest;
import com.ansham.SBGraalvmExample.repository.DomesticPaymentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domestic-payments")
public class DomesticPaymentsController {

    public static final Logger LOGGER=
            LoggerFactory.getLogger(DomesticPaymentsController.class);

    @Autowired
    DomesticPaymentsRepository domesticPaymentsRepository;


    @PostMapping
    public DPRequest addConsents(@RequestBody DPRequest dpRequest)
    {
        LOGGER.info("Adding new consent: {} ",dpRequest);
        return domesticPaymentsRepository.save(dpRequest);
    }

    @GetMapping
    public List<DPRequest> findAll(){
        LOGGER.info("Returned all the data to the user");
        return domesticPaymentsRepository.findAll();
    }
    @GetMapping("/{consentId}")
    public DPRequest findById(@PathVariable Long consentId){
        LOGGER.info("Retrieving the data of the consentId: "+consentId);
        if (!domesticPaymentsRepository.existsById(consentId))
        {
            LOGGER.error("Data does not exist for the consentId: "+consentId);
            throw new DataNotFound("No data found");
        }

        return domesticPaymentsRepository.findByConsentid(consentId);
    }




}
