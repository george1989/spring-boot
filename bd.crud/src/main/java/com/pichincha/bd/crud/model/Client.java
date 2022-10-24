package com.pichincha.bd.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import com.pichincha.bd.crud.dto.ClientDto;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String identificacion;
    public String nombre;

    public String apellido;

    public String tipoCliente;


	public ClientDto getAsTo(){
        return new ClientDto(this.id,this.identificacion,this.nombre,this.apellido,this.tipoCliente);
    }
}
