package com.example.glassshop.models.data;

import com.example.glassshop.models.Art;
import com.example.glassshop.models.SearchFieldType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public interface ArtDao extends CrudRepository<Art, Integer> {

    List<Art> findByArtistName(String artistName);

    List<Art> findByTrackingNumber(Integer trackingNumber);

    List<Art> findByDescription(String description);

}
