package com.gst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TickServiceImpl implements TickService{

	@Autowired
	TickRepository tickRepository;
	
	@Override
	public Tick save(Tick tick) {
		// TODO Auto-generated method stub
		return tickRepository.save(tick);
	}

}
