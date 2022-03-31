package com.pichincha.bd.crud.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.bd.crud.model.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    public long id;
    public String identificacion;
    public String nombre;
    public String apellido;
    public String tipoCliente;

	@JsonIgnore
    public Client getAsEntity(){
        return new Client(this.id,this.identificacion,this.nombre,this.apellido,this.tipoCliente);
    }

}
