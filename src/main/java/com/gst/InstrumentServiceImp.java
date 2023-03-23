package com.gst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentServiceImp implements InstrumentServiceInterface{

	@Autowired
	InstumentRepository  instumentRepository;
	@Override
	public Instrument Save(Instrument instrument) {
		 
 return instumentRepository.save(instrument);
	}

}
