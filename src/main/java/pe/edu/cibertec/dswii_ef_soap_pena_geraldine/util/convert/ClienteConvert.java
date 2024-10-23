package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Cliente;
import pe.edu.cibertec.ws.objects.Clientews;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConvert {

    public Cliente mapToCliente(Clientews clientews){
        Cliente cliente = new Cliente();
        cliente.setId_cliente(clientews.getIdCliente());
        cliente.setNombre(clientews.getNombre());
        cliente.setEmail(clientews.getEmail());
        cliente.setTelefono(clientews.getTelefono());
        cliente.setId_pais(clientews.getIdPais());
        return cliente;
    }
    public Clientews mapToClientews(Cliente cliente){
        Clientews clientews = new Clientews();
        clientews.setIdCliente(cliente.getId_cliente());
        clientews.setNombre(cliente.getNombre());
        clientews.setEmail(cliente.getEmail());
        clientews.setTelefono(cliente.getTelefono());
        clientews.setIdPais(cliente.getId_pais());
        return clientews;
    }

    public List<Cliente> mapToClienteList(List<Clientews> clientewsList){
        List<Cliente> clienteList = new ArrayList<>();
        for (Clientews clientews : clientewsList){
            clienteList.add(mapToCliente(clientews));
        }
        return clienteList;
    }

    public List<Clientews> mapToClientewsList(List<Cliente> clienteList){
        List<Clientews> clientewsList = new ArrayList<>();
        for (Cliente cliente : clienteList){
            clientewsList.add(mapToClientews(cliente));
        }
        return clientewsList;
    }
}
