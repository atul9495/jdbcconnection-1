package com.gst;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

 
@Repository
public interface InstumentRepository extends PagingAndSortingRepository<Instrument, Long>{

}
