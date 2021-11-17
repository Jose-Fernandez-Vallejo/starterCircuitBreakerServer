package com.example.microservicioStarterCircuitBreakerClient.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import starterCircuitBreaker.starter.Status;

@Component
@Endpoint(id = "status")
public class StatusEndpoint {

	
List<String> lista = new ArrayList<>();

@Autowired
Status status;
	
	
	@ReadOperation
	public List<String> status()
	{
		return lista;
	}
	
	@WriteOperation
	public void write(@Selector String statusAdd)
	{
		
		lista.add(status.executeCircuit(statusAdd));
	}
	
	@DeleteOperation
	public void delete(@Selector String statusDelete)
	{
		lista.remove(statusDelete);
	}
}
