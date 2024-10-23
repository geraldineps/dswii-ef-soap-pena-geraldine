package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service;

import pe.edu.cibertec.ws.objects.*;

public interface IClienteService {

    GetClientesResponse listarClientes();
    GetClienteResponse obtenerClientexId(Integer id);
    PostClienteResponse registrarCliente(PostClienteRequest request);

    PutClienteResponse actualizarCliente(PutClienteRequest request);
}
