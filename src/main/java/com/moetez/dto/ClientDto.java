package com.moetez.dto;

import com.moetez.clients.entities.Type;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
	private Long idClient;
	private String nomClient;
	private String adresseclient;
	private String emailclient;
	private Date dateInscription;
	private Type type;
}

