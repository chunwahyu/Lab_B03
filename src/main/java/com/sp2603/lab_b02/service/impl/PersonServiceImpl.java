package com.sp2603.lab_b02.service.impl;

import com.sp2603.lab_b02.data.person.domainObject.request.CreatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.request.UpdatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.response.CreatePersonResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.GetAllPeopleResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.PersonResponseData;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;
import com.sp2603.lab_b02.exception.person.PersonNotFoundException;
import com.sp2603.lab_b02.mapper.person.PersonDataMapper;
import com.sp2603.lab_b02.mapper.person.PersonEntityMapper;
import com.sp2603.lab_b02.repository.PersonRepository;
import com.sp2603.lab_b02.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonRepository personRepository;

    //private List<PersonEntity> personEntityList = new ArrayList<>();
    private final PersonEntityMapper personEntityMapper;
    private final PersonDataMapper personDataMapper;

    //Constructor injection
    public PersonServiceImpl(PersonEntityMapper personEntityMapper, PersonDataMapper personDataMapper, PersonRepository personRepository) {
        this.personEntityMapper = personEntityMapper;
        this.personDataMapper = personDataMapper;
        this.personRepository = personRepository;
    }

    @Override
    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
        //PersonEntity personEntity = new PersonEntity();
        //personEntity.setFirstName(createPersonRequestData.getFirstName());
        //personEntity.setLastName(createPersonRequestData.getLastName());
        //personEntity.setHkid(createPersonRequestData.getHkid());

        //CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData();
        //createPersonResponseData.setFirstName(personEntity.getFirstName());
        //createPersonResponseData.setLastName(personEntity.getLastName());
        //createPersonResponseData.setHkid(personEntity.getHkid());

        PersonEntity personEntity = personEntityMapper.toPersonEntity(createPersonRequestData);

        //personEntityList.add(personEntity);
        personRepository.save(personEntity);

        CreatePersonResponseData createPersonResponseData = personDataMapper.toCreatePersonResponseData(personEntity);

        return createPersonResponseData;
    }

    @Override
    public List<GetAllPeopleResponseData> getAllPeopleResponseDataList() {
        Iterable<PersonEntity> personEntityList = personRepository.findAll();
        List<GetAllPeopleResponseData> getAllPeopleResponseDataList = personDataMapper.toGetAllPeopleResponseDataList(personEntityList);

        return getAllPeopleResponseDataList;
    }

    @Override
    public PersonResponseData updatePerson(UpdatePersonRequestData updatePersonRequestData) {
        try {

            /**
            if (updatePersonRequestData.getHkid() == null) {
                throw new PersonDataMissingException("hkid");
            }

            if (updatePersonRequestData.getFirstName() == null) {
                throw new PersonDataMissingException("firstName");
            }

            if (updatePersonRequestData.getLastName() == null) {
                throw new PersonDataMissingException("lastName");
            }
            **/

            /**
            for (PersonEntity person : personEntityList) {
                if (person.getHkid().equals(updatePersonRequestData.getHkid())) {
                    person.setFirstName(updatePersonRequestData.getFirstName());
                    person.setLastName(updatePersonRequestData.getLastName());

                    PersonResponseData personResponseData = personDataMapper.toPersonResponseData(person);
                    return personResponseData;
                }
            }

            throw new PersonNotFoundException(updatePersonRequestData.getHkid());
             **/

            PersonEntity personEntity = getEntityByHkid(updatePersonRequestData.getHkid());
            personEntity.setFirstName(updatePersonRequestData.getFirstName());
            personEntity.setLastName(updatePersonRequestData.getLastName());

            personEntity = personRepository.save(personEntity);

            PersonResponseData personResponseData = personDataMapper.toPersonResponseData(personEntity);
            return personResponseData;

        } catch(Exception exception) {
            log.warn("Update Person Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public PersonResponseData deletePerson(String hkid) {
        try {
            /**
            for (PersonEntity personEntity : personEntityList) {
                if (personEntity.getHkid().equals(hkid)) {
                    personEntityList.remove(personEntity);
                    PersonResponseData personResponseData = personDataMapper.toPersonResponseData(personEntity);
                    return personResponseData;
                }
            }
            throw new PersonNotFoundException(hkid);
            **/
            PersonEntity personEntity = getEntityByHkid(hkid);
//            personEntityList.remove(personEntity);
            personRepository.delete(personEntity);
            PersonResponseData personResponseData = personDataMapper.toPersonResponseData(personEntity);

            return personResponseData;

        } catch (Exception exception) {
            log.warn("Delete Person Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public List<PersonResponseData> getByLastName(String lastName) {
        List<PersonResponseData> resultList = new ArrayList<>();

        for(PersonEntity personEntity: personRepository.findAllByLastName(lastName)) {
            if(personEntity.getLastName().equals(lastName)) {
                PersonResponseData personResponseData = personDataMapper.toPersonResponseData(personEntity);
                resultList.add(personResponseData);
            }
        }

        return resultList;
    }

    @Override
    public PersonEntity getEntityByHkid(String hkid) {
//        for(PersonEntity personEntity: personEntityList) {
//            if(personEntity.getHkid().equals(hkid)) {
//                return personEntity;
//            }
//        }
//
//        throw new PersonNotFoundException(hkid);

        Optional<PersonEntity> optionalPersonEntity = personRepository.findByHkid(hkid);
        if(optionalPersonEntity.isEmpty()) {
            throw new PersonNotFoundException(hkid);
        }

        PersonEntity personEntity = optionalPersonEntity.get();
        return personEntity;
    }
}
