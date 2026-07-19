package com.sp2603.lab_b02.mapper.person;

import com.sp2603.lab_b02.data.person.domainObject.request.CreatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.request.UpdatePersonRequestData;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityMapper {

    public PersonEntity toPersonEntity(CreatePersonRequestData createPersonRequestData) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(createPersonRequestData.getFirstName());
        personEntity.setLastName(createPersonRequestData.getLastName());
        personEntity.setHkid(createPersonRequestData.getHkid());

        return personEntity;
    }

    public PersonEntity toUpdatePersonEntity(UpdatePersonRequestData updatePersonRequestData) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(updatePersonRequestData.getFirstName());
        personEntity.setLastName(updatePersonRequestData.getLastName());
        personEntity.setHkid(updatePersonRequestData.getHkid());

        return personEntity;
    }

}
