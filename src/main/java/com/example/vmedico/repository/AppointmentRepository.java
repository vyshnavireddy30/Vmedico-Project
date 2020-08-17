package com.example.vmedico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vmedico.entity.Appointment;

@Repository("appointmentRepository")
public interface AppointmentRepository  extends JpaRepository<Appointment, Integer> {



	List<Appointment> findByEmail(String username);

}
