package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.IPaisService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class PaisEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IPaisService paisService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisesRequest")
    @ResponsePayload
    public GetPaisesResponse getPaises(@RequestPayload
                                           GetPaisesRequest request){
        return paisService.listarPaises();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getPaisXid(
            @RequestPayload GetPaisRequest request){
        return paisService.obtenerPaisxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postPaisRequest")
    @ResponsePayload
    public PostPaisResponse savePais(@RequestPayload
                                               PostPaisRequest request){
        return paisService.registrarPais(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putPaisRequest")
    @ResponsePayload
    public PutPaisResponse updatePais(@RequestPayload
                                            PutPaisRequest request){
        return paisService.actualizarPais(request);
    }
}
