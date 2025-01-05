package com.caliber.service;

import java.util.List;
import com.caliber.modal.InstrumentRegistration;

public interface InstrumentRegdService {

    public InstrumentRegistration saveInstrument(InstrumentRegistration instrument);

    public List<InstrumentRegistration> getAllInstruments();

    public InstrumentRegistration getInstrumentByInstId(String id);

    public List<InstrumentRegistration> getInstrumentByInstLoc(String location);

    public List<InstrumentRegistration> getInstrumentByInstDept(String department);

}
