package com.sp2603.lab_b02.service;

import com.sp2603.lab_b02.data.person.domainObject.request.CreatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.request.UpdatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.response.CreatePersonResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.GetAllPeopleResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.PersonResponseData;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData);

    List<GetAllPeopleResponseData> getAllPeopleResponseDataList();

    PersonResponseData updatePerson(UpdatePersonRequestData updatePersonRequestData);

    PersonResponseData deletePerson(String hkid);

    List<PersonResponseData> getByLastName(String lastName);

    PersonEntity getEntityByHkid(String hkid);
}
