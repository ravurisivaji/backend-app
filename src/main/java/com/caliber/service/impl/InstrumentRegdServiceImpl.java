package com.caliber.service.impl;

import com.caliber.modal.InstrumentRegistration;
import com.caliber.repository.InstrumentRegdRepository;
import com.caliber.service.InstrumentRegdService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentRegdServiceImpl implements InstrumentRegdService {

    public static final Logger logger = LogManager.getLogger(InstrumentRegdServiceImpl.class);

    @Autowired
    private InstrumentRegdRepository instRepository;

    @Override
    public InstrumentRegistration saveInstrument(InstrumentRegistration instrument) {

        logger.info("***SaveInstrument Method with params {} ***", instrument.toString());

        if(ObjectUtils.isEmpty(instrument)){
            logger.error("instrument object is empty : ", instrument);
            return null;
        }

        InstrumentRegistration newInst =
                instRepository.save(instrument);

        if( ObjectUtils.isEmpty(newInst)){
            logger.error(" Unable to insert into Database : {} ", newInst);
            return newInst;
        }
        return newInst;
    }

    @Override
    public List<InstrumentRegistration> getAllInstruments() {
        logger.info("*** Get List of AllInstruments ***");
        List<InstrumentRegistration> instList = new ArrayList<>();
        instList = instRepository.findAll();
        if( instList.size() == 0 ){
            logger.error(" Unable to fetch instruments from DB");
            return instList;
        }
        return instList;
    }

    @Override
    public InstrumentRegistration getInstrumentByInstId(String id) {
        logger.info("Get Instrument by ID {} ", id);

        InstrumentRegistration instrument = instRepository.findByInstId(id);
        return instrument;
    }

    @Override
    public List<InstrumentRegistration> getInstrumentByInstLoc(String location) {
        logger.info("Get list of all instruments by location : {} ", location);
        List<InstrumentRegistration> instruments =
                instRepository.getInstrumentByInstInstalledAt(location);
        return instruments;
    }

    @Override
    public List<InstrumentRegistration> getInstrumentByInstDept(String department) {
        logger.info("Get list of all instruments by department : {} ", department);
        List<InstrumentRegistration> instruments = new ArrayList<>();
        instruments = instRepository.getInstrumentsByDepartments(department);
        return instruments;
    }
}
