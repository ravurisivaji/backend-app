package com.caliber.controller;

import com.caliber.modal.InstrumentRegistration;
import com.caliber.service.InstrumentRegdService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentsController {

    private static final Logger logger = LogManager.getLogger(InstrumentsController.class);

    @Autowired
    private InstrumentRegdService instService;

    @PostMapping(value = "/saveInstrument" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveInstruments(@RequestBody InstrumentRegistration instrument){
        logger.info(" ***SaveInstruments method {} *** " , instrument.toString());

        if(ObjectUtils.isEmpty(instrument)){
            logger.error("Instrument Object is empty ...");
            return new ResponseEntity<>("Received invalid Object", HttpStatus.BAD_REQUEST);
        }
        //check if the Object is already exist

        InstrumentRegistration newInst = instService.saveInstrument(instrument);
        return new ResponseEntity<>(newInst, HttpStatus.OK);
    }

}
