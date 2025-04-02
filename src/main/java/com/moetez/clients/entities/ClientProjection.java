package com.moetez.clients.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomCli", types = { Client.class })
public interface ClientProjection {
	public String getNomclient();
}
