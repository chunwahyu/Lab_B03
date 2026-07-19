package com.sp2603.lab_b02.mapper.person;

import com.sp2603.lab_b02.data.person.domainObject.request.CreatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.request.UpdatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.response.CreatePersonResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.GetAllPeopleResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.PersonResponseData;
import com.sp2603.lab_b02.data.person.dto.request.CreatePersonRequestDto;
import com.sp2603.lab_b02.data.person.dto.request.UpdatePersonRequestDto;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDataMapper {

    public CreatePersonRequestData toCreatePersonRequestData(CreatePersonRequestDto createPersonRequestDto) {
        CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData();
        createPersonRequestData.setFirstName(createPersonRequestDto.getFirstName());
        createPersonRequestData.setLastName(createPersonRequestDto.getLastName());
        createPersonRequestData.setHkid(createPersonRequestDto.getHkid());

        return createPersonRequestData;
    }

    public CreatePersonResponseData toCreatePersonResponseData(PersonEntity personEntity) {
        CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData();
        createPersonResponseData.setFirstName(personEntity.getFirstName());
        createPersonResponseData.setLastName(personEntity.getLastName());
        createPersonResponseData.setHkid(personEntity.getHkid());

        return createPersonResponseData;
    }

    public GetAllPeopleResponseData toGetAllPeopleResponseData(PersonEntity personEntity) {
        GetAllPeopleResponseData getAllPeopleResponseData = new GetAllPeopleResponseData();
        getAllPeopleResponseData.setFirstName(personEntity.getFirstName());
        getAllPeopleResponseData.setLastName(personEntity.getLastName());
        getAllPeopleResponseData.setHkid(personEntity.getHkid());

        return getAllPeopleResponseData;
    }

    public List<GetAllPeopleResponseData> toGetAllPeopleResponseDataList(List<PersonEntity> personEntityList){
        List<GetAllPeopleResponseData> getAllPeopleResponseDataList = new ArrayList<>();

        for(PersonEntity personEntity: personEntityList) {
            GetAllPeopleResponseData getAllPeopleResponseData = toGetAllPeopleResponseData(personEntity);
            getAllPeopleResponseDataList.add(getAllPeopleResponseData);
        }

        return getAllPeopleResponseDataList;
    }

    public UpdatePersonRequestData toUpdatePersonRequestData(UpdatePersonRequestDto updatePersonRequestDto) {
        UpdatePersonRequestData updatePersonRequestData = new UpdatePersonRequestData();
        updatePersonRequestData.setFirstName(updatePersonRequestDto.getFirstName());
        updatePersonRequestData.setLastName(updatePersonRequestDto.getLastName());
        updatePersonRequestData.setHkid(updatePersonRequestDto.getHkid());

        return updatePersonRequestData;
    }

    public PersonResponseData toPersonResponseData(PersonEntity personEntity) {
        PersonResponseData personResponseData = new PersonResponseData();
        personResponseData.setFirstName(personEntity.getFirstName());
        personResponseData.setLastName(personEntity.getLastName());
        personResponseData.setHkid(personEntity.getHkid());

        return personResponseData;
    }

    public List<PersonResponseData> toPersonResponseDataList(List<PersonEntity> personEntityList) {
        List<PersonResponseData> personResponseDataList = new ArrayList<>();

        for(PersonEntity personEntity : personEntityList) {
            personResponseDataList.add(toPersonResponseData(personEntity));
        }

        return personResponseDataList;
    }

}
