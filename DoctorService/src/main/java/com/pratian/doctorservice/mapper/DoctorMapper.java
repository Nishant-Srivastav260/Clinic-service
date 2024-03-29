package com.pratian.doctorservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.pratian.doctorservice.controller.dto.DoctorDto;
import com.pratian.doctorservice.model.Doctor;

@Mapper
public interface DoctorMapper {
	
	@Mapping(source = "doctor.id", target = "id")
	@Mapping(source = "doctor.name", target = "name")
	@Mapping(source = "doctor.phone_no", target = "phone_no")
	@Mapping(source = "doctor.speciality", target = "speciality")
	public DoctorDto convertToDto(Doctor doctor);
	
	@Mapping(source = "dto.id", target = "id")
	@Mapping(source = "dto.name", target = "name")
	@Mapping(source = "dto.phone_no", target = "phone_no")
	@Mapping(source = "dto.speciality", target = "speciality")
	public Doctor ConvertToEntity(DoctorDto dto);
}
