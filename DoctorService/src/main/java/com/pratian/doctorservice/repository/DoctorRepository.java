package com.pratian.doctorservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.doctorservice.controller.dto.DoctorDto;
import com.pratian.doctorservice.model.Doctor;

@Repository
//@EnableJpaRepositories
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
//	@Query(value = "select d from Doctor d where d.username =:username")
//	Doctor findByUserName(String username);
	
	@Query(value = "select d from Doctor d where d.speciality =:speciality")
	List<Doctor> findBySpeciality(@Param(value = "speciality")String speciality);
	
	@Query(value = "select d from Doctor d where d.id =:id")
	Doctor findByDoctorId(@Param(value = "id")long id);
	
}
