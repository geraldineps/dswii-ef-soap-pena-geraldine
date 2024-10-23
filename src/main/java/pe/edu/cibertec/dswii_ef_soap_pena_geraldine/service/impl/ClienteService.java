package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Cliente;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.repository.ClienteRepository;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.IClienteService;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.util.convert.ClienteConvert;
import pe.edu.cibertec.ws.objects.*;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConvert clienteConvert;
    @Override
    public GetClientesResponse listarClientes() {
        GetClientesResponse getClientesResponse = new GetClientesResponse();
        getClientesResponse.getClientes().addAll(
                clienteConvert.mapToClientewsList(clienteRepository.findAll())
        );
        return getClientesResponse;
    }

    @Override
    public GetClienteResponse obtenerClientexId(Integer id) {
        GetClienteResponse clienteResponse = new GetClienteResponse();
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null){
            throw  new NotFoundException("El cliente con ID "+ id+" no existe.");
        }
        clienteResponse.setCliente(
                clienteConvert.mapToClientews(cliente));
        return clienteResponse;
    }

    @Override
    public PostClienteResponse registrarCliente(PostClienteRequest request) {
        PostClienteResponse postClienteResponse = new PostClienteResponse();
        Cliente nuevoCliente = clienteRepository.save(
                clienteConvert.mapToCliente(request.getCliente())
        );
        postClienteResponse.setCliente(
                clienteConvert.mapToClientews(nuevoCliente));
        return postClienteResponse;
    }

    @Override
    public PutClienteResponse actualizarCliente(PutClienteRequest request) {
        PutClienteResponse putClienteResponse = new PutClienteResponse();

        // Busca el cliente por ID
        Optional<Cliente> cliente = clienteRepository.findById(request.getCliente().getIdCliente());

        if (cliente.isEmpty()) {
            throw new NotFoundException("Cliente con el ID: " + request.getCliente().getIdCliente() + " no existe");
        }
        // Mapea los datos del request al cliente existente
        Cliente clienteActualizado = clienteConvert.mapToCliente(request.getCliente());
        clienteActualizado.setId_cliente(cliente.get().getId_cliente()); // asegura que el ID no cambie

        // Actualiza el cliente en la base de datos
        Cliente clienteGuardado = clienteRepository.save(clienteActualizado);

        // Convierte el cliente actualizado para la respuesta
        putClienteResponse.setCliente(
                clienteConvert.mapToClientews(clienteGuardado)
        );

        return putClienteResponse;
    }
}
