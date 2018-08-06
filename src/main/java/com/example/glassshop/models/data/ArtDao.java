package com.example.glassshop.models.data;

import com.example.glassshop.models.forms.Art;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ArtDao extends CrudRepository<Art, Integer> {
}
