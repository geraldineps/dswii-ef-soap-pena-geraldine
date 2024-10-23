package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service;

import pe.edu.cibertec.ws.objects.*;

public interface IHotelService {

    GetHotelesResponse listarHoteles();
    GetHotelResponse obtenerHotelxId(Integer id);
    PostHotelResponse registrarHotel(PostHotelRequest request);

    PutHotelResponse actualizarHotel(PutHotelRequest request);
}
