package com.sp2603.lab_b02.controller;

import com.sp2603.lab_b02.data.person.domainObject.request.UpdatePersonRequestData;
import com.sp2603.lab_b02.data.person.domainObject.response.CreatePersonResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.GetAllPeopleResponseData;
import com.sp2603.lab_b02.data.person.domainObject.response.PersonResponseData;
import com.sp2603.lab_b02.data.person.dto.request.UpdatePersonRequestDto;
import com.sp2603.lab_b02.data.person.dto.response.CreatePersonResponseDto;
import com.sp2603.lab_b02.data.person.dto.response.GetAllPeopleResponseDto;
import com.sp2603.lab_b02.data.person.dto.response.PersonResponseDto;
import com.sp2603.lab_b02.data.person.domainObject.request.CreatePersonRequestData;
import com.sp2603.lab_b02.data.person.dto.request.CreatePersonRequestDto;
import com.sp2603.lab_b02.mapper.person.PersonDataMapper;
import com.sp2603.lab_b02.mapper.person.PersonDtoMapper;
import com.sp2603.lab_b02.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PersonController {

    private final PersonService personService;
    private final PersonDataMapper personDataMapper;
    private final PersonDtoMapper personDtoMapper;

    //Constructor injection
    public PersonController(PersonService personService, PersonDataMapper personDataMapper, PersonDtoMapper personDtoMapper) {
        this.personService = personService;
        this.personDataMapper = personDataMapper;
        this.personDtoMapper = personDtoMapper;
    }

    @PostMapping("/people")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePersonResponseDto createPerson(@RequestBody CreatePersonRequestDto createPersonRequestDto) {
        //CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData();
        //createPersonRequestData.setFirstName(createPersonRequestDto.getFirstName());
        //createPersonRequestData.setLastName(createPersonRequestDto.getLastName());
        //createPersonRequestData.setHkid(createPersonRequestDto.getHkid());

        //CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto();
        //createPersonResponseDto.setFirstName(createPersonResponseData.getFirstName());
        //createPersonResponseDto.setLastName(createPersonResponseData.getLastName());
        //createPersonResponseDto.setHkid(createPersonResponseData.getHkid());

        CreatePersonRequestData createPersonRequestData = personDataMapper.toCreatePersonRequestData(createPersonRequestDto);

        CreatePersonResponseData createPersonResponseData = personService.createPerson(createPersonRequestData);

        CreatePersonResponseDto createPersonResponseDto = personDtoMapper.createPersonResponseDto(createPersonResponseData);

        return createPersonResponseDto;
    }


    @GetMapping("/people")
    public List<GetAllPeopleResponseDto> getAllPeople() {
        List<GetAllPeopleResponseData> getAllPeopleResponseDataList = personService.getAllPeopleResponseDataList();

        List<GetAllPeopleResponseDto> getAllPeopleResponseDtoList = personDtoMapper.toGetAllPeopleResponseDtoList(getAllPeopleResponseDataList);

        return getAllPeopleResponseDtoList;
    }


    @PutMapping("/people")
    public PersonResponseDto updatePerson(@Valid @RequestBody UpdatePersonRequestDto updatePersonRequestDto) {
        //Lv2
        //UpdatePersonRequestData updatePersonRequestData = personDataMapper.toUpdatePersonRequestData(updatePersonRequestDto);
        //PersonResponseData personResponseData = personService.updatePerson(updatePersonRequestData);
        //PersonResponseDto personResponseDto = personDtoMapper.toPersonResponseDto(personResponseData);
        //return personResponseDto;

        return personDtoMapper.toPersonResponseDto(
                personService.updatePerson(
                        personDataMapper.toUpdatePersonRequestData(updatePersonRequestDto)
                )
        );
    }

    @DeleteMapping("/people/{hkid}")
    public PersonResponseDto deletePerson(@PathVariable @NotBlank String hkid) {
        /** Lv2
        PersonResponseData personResponseData = personService.deletePerson(hkid);
        PersonResponseDto personResponseDto = personDtoMapper.toPersonResponseDto(personResponseData);
        return personResponseDto;
         **/

        return personDtoMapper.toPersonResponseDto(
                personService.deletePerson(hkid)
        );
    }

    @GetMapping("/people/{last_name}")
    public List<PersonResponseDto> getByLastName(@PathVariable(value="last_name") @NotBlank String lastName) {
        List<PersonResponseData> personResponseDataList = personService.getByLastName(lastName);

        List<PersonResponseDto> personResponseDtoList = personDtoMapper.toPersonResponseDtoList(personResponseDataList);

        return personResponseDtoList;
    }

}
