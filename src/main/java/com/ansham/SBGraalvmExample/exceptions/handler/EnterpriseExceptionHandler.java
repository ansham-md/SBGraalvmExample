package com.ansham.SBGraalvmExample.exceptions.handler;

import com.ansham.SBGraalvmExample.exceptions.DataNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.net.URISyntaxException;

@ControllerAdvice
public class EnterpriseExceptionHandler {


//    @ExceptionHandler(DataNotFound.class)
//    public ResponseEntity<ProblemDetail> handleRuntimeException(DataNotFound ex) throws URISyntaxException {
//        ProblemDetail problemDetailDetails =ProblemDetail
//                .forStatusAndDetail(HttpStatus.NOT_FOUND
//                        ,"DB Retrieval error."+ex.getMessage());
//        problemDetailDetails.setType(new URI("jdbc:h2:mem:ansham"));
//        problemDetailDetails.setTitle("SCR_FSS_ERR001_DB101");
//        return new ResponseEntity<>(problemDetailDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(DataNotFound.class)
    public ProblemDetail handleRuntimeException(DataNotFound ex) throws URISyntaxException {

        ProblemDetail problemDetailDetails =ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND
                        ,"DB Retrieval error."+ex.getMessage());
        problemDetailDetails.setType(new URI("jdbc:h2:mem:ansham"));
        problemDetailDetails.setTitle("SCR_FSS_ERR001_DB101");
        return problemDetailDetails;
    }
}
