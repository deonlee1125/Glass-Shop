package com.example.glassshop.models.data;

import com.example.glassshop.models.Art;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ArtDao extends CrudRepository<Art, Integer> {

    List<Art> findById(Integer Id);

    List<Art> findByArtistName(String artistName);

    List<Art> findByTrackingNumber(Integer trackingNumber);

    List<Art> findByDescription(String description);

}
