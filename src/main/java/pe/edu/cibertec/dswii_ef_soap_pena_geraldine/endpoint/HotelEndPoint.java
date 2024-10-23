package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.IHotelService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class HotelEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IHotelService hotelService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelesRequest")
    @ResponsePayload
    public GetHotelesResponse getHoteles(@RequestPayload
                                       GetHotelesRequest request){
        return hotelService.listarHoteles();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelRequest")
    @ResponsePayload
    public GetHotelResponse getHotelXid(
            @RequestPayload GetHotelRequest request){
        return hotelService.obtenerHotelxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postHotelRequest")
    @ResponsePayload
    public PostHotelResponse saveHotel(@RequestPayload
                                     PostHotelRequest request){
        return hotelService.registrarHotel(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putHotelRequest")
    @ResponsePayload
    public PutHotelResponse updateHotel(@RequestPayload
                                            PutHotelRequest request){
        return hotelService.actualizarHotel(request);
    }
}
