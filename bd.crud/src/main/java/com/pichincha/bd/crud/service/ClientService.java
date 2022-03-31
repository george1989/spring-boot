package com.pichincha.bd.crud.service;

import java.util.List;

import com.pichincha.bd.crud.dto.ClientDto;
import com.pichincha.bd.crud.exception.NoResourceException;

public interface ClientService {
    public List<ClientDto> getAllClients();
    public ClientDto createClient(ClientDto clientDto);
    public ClientDto updateClient(Long id, ClientDto clientDto) throws NoResourceException;
    public void deleteCliente(Long id) throws NoResourceException;

}
