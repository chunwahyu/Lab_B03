package com.sp2603.lab_b02.mapper.person;

import com.sp2603.lab_b02.data.person.domainObject.response.CreatePersonResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.GetAllPeopleResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.PersonResponseData;
import com.sp2603.lab_b02.data.person.dto.response.CreatePersonResponseDto;
import com.sp2603.lab_b02.data.person.dto.response.GetAllPeopleResponseDto;
import com.sp2603.lab_b02.data.person.dto.response.PersonResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDtoMapper {

    public CreatePersonResponseDto createPersonResponseDto(CreatePersonResponseData createPersonResponseData) {

        CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto();
        createPersonResponseDto.setFirstName(createPersonResponseData.getFirstName());
        createPersonResponseDto.setLastName(createPersonResponseData.getLastName());
        createPersonResponseDto.setHkid(createPersonResponseData.getHkid());

        return createPersonResponseDto;
    }

    public GetAllPeopleResponseDto toGetAllPeopleResponseDto(GetAllPeopleResponseData getAllPeopleResponseData) {

        GetAllPeopleResponseDto getAllPeopleResponseDto = new GetAllPeopleResponseDto();
        getAllPeopleResponseDto.setFirstName(getAllPeopleResponseData.getFirstName());
        getAllPeopleResponseDto.setLastName(getAllPeopleResponseData.getLastName());
        getAllPeopleResponseDto.setHkid(getAllPeopleResponseData.getHkid());

        return getAllPeopleResponseDto;
    }

    public List<GetAllPeopleResponseDto> toGetAllPeopleResponseDtoList(List<GetAllPeopleResponseData> getAllPeopleResponseDataList) {
        List<GetAllPeopleResponseDto> getAllPeopleResponseDtoList = new ArrayList<>();

        for(GetAllPeopleResponseData getAllPeopleResponseData: getAllPeopleResponseDataList) {
            GetAllPeopleResponseDto getAllPeopleResponseDto = toGetAllPeopleResponseDto(getAllPeopleResponseData);
            getAllPeopleResponseDtoList.add(getAllPeopleResponseDto);
        }

        return getAllPeopleResponseDtoList;
    }


    public PersonResponseDto toPersonResponseDto(PersonResponseData personResponseData) {
        PersonResponseDto personResponseDto = new PersonResponseDto();
        personResponseDto.setFirstName(personResponseData.getFirstName());
        personResponseDto.setLastName(personResponseData.getLastName());
        personResponseDto.setHkid(personResponseData.getHkid());

        return personResponseDto;
    }

    public List<PersonResponseDto> toPersonResponseDtoList(List<PersonResponseData> personResponseDataList) {
        List<PersonResponseDto> personResponseDtoList = new ArrayList<>();

        for(PersonResponseData personResponseData : personResponseDataList) {
            PersonResponseDto personResponseDto = toPersonResponseDto(personResponseData);
            personResponseDtoList.add(personResponseDto);
        }

        return personResponseDtoList;
    }

}
