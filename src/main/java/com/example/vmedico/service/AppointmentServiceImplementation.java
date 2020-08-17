package com.example.vmedico.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vmedico.repository.AppointmentRepository;
import com.example.vmedico.entity.Appointment;
@Service
public class AppointmentServiceImplementation {

	private AppointmentRepository appointmentRepository;

	@Autowired   
	public AppointmentServiceImplementation( AppointmentRepository obj)
	{
		appointmentRepository=obj;
	}
	
	
	public void save(Appointment app)
	{
		
		appointmentRepository.save(app);
	}
	
	
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}


	public List<Appointment> findByEmail(String username) {
		return appointmentRepository.findByEmail(username);
		
	}

}
