package com.sp2603.lab_b02.repository;

import com.sp2603.lab_b02.data.person.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

        @Query(
            nativeQuery = true,
                value = "SELECT * FROM person WHERE hkid=?1"
        )
        Optional<PersonEntity> findByHkid(String hkid);
        //int deleteByHkid(String hkid);
        List<PersonEntity> findAllByLastName(String lastName);
}
