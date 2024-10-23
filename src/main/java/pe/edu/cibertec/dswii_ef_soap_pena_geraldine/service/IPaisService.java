package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service;

import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Pais;
import pe.edu.cibertec.ws.objects.*;

import java.util.List;

public interface IPaisService {
    GetPaisesResponse listarPaises();
    GetPaisResponse obtenerPaisxId(Integer id);
    PostPaisResponse registrarPais(PostPaisRequest request);

    PutPaisResponse actualizarPais(PutPaisRequest request);

}
