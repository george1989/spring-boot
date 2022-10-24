package com.pichincha.bd.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.bd.crud.dto.ClientDto;
import com.pichincha.bd.crud.exception.NoResourceException;
import com.pichincha.bd.crud.model.Client;
import com.pichincha.bd.crud.repository.ClientRepository;
import com.pichincha.bd.crud.service.ClientService;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = new ArrayList<>();
        clients.stream().forEach((client) -> {
            clientDtos.add(client.getAsTo());
        });
        return clientDtos;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        return clientRepository.save(clientDto.getAsEntity()).getAsTo();
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) throws NoResourceException {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            client.get().setId(clientDto.getId());
            client.get().setIdentificacion(clientDto.getIdentificacion());
            client.get().setNombre(clientDto.getNombre());
            client.get().setApellido(clientDto.getApellido());
            client.get().setTipoCliente(clientDto.getTipoCliente());
            return clientRepository.save(client.get()).getAsTo();
        }
        else {
            throw  new NoResourceException("No existe la persona con id : "+id);
        }
    }

    @Override
    public void deleteCliente(Long id) throws NoResourceException {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            clientRepository.delete(client.get());
        }else{
            throw  new NoResourceException("No existe la persona con id : "+id);
        }
    }
}
