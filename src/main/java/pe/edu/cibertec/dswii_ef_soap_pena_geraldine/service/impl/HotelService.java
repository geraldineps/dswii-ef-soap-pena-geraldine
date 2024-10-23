package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Hotel;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Hotel;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.repository.HotelRepository;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.IHotelService;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.util.convert.HotelConvert;
import pe.edu.cibertec.ws.objects.*;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HotelService implements IHotelService {

    private final HotelRepository hotelRepository;
    private final HotelConvert hotelConvert;
    @Override
    public GetHotelesResponse listarHoteles() {
        GetHotelesResponse getHotelsResponse = new GetHotelesResponse();
        getHotelsResponse.getHoteles().addAll(
                hotelConvert.mapToHotelwsList(hotelRepository.findAll())
        );
        return getHotelsResponse;
    }

    @Override
    public GetHotelResponse obtenerHotelxId(Integer id) {
        GetHotelResponse hotelResponse = new GetHotelResponse();
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if(hotel == null){
            throw  new NotFoundException("El hotel con ID "+ id+" no existe.");
        }
        hotelResponse.setHotel(
                hotelConvert.mapToHotelws(hotel));
        return hotelResponse;
    }

    @Override
    public PostHotelResponse registrarHotel(PostHotelRequest request) {
        PostHotelResponse postHotelResponse = new PostHotelResponse();
        Hotel nuevoHotel = hotelRepository.save(
                hotelConvert.mapToHotel(request.getHotel())
        );
        postHotelResponse.setHotel(
                hotelConvert.mapToHotelws(nuevoHotel));
        return postHotelResponse;
    }

    @Override
    public PutHotelResponse actualizarHotel(PutHotelRequest request) {
        PutHotelResponse putHotelResponse = new PutHotelResponse();

        // Busca el hotel por ID
        Optional<Hotel> hotel = hotelRepository.findById(request.getHotel().getIdHotel());

        if (hotel.isEmpty()) {
            throw new NotFoundException("Hotel con el ID: " + request.getHotel().getIdHotel() + " no existe");
        }
        // Mapea los datos del request al hotel existente
        Hotel hotelActualizado = hotelConvert.mapToHotel(request.getHotel());
        hotelActualizado.setId_hotel(hotel.get().getId_hotel()); // asegura que el ID no cambie

        // Actualiza el hotel en la base de datos
        Hotel hotelGuardado = hotelRepository.save(hotelActualizado);

        // Convierte el hotel actualizado para la respuesta
        putHotelResponse.setHotel(
                hotelConvert.mapToHotelws(hotelGuardado)
        );

        return putHotelResponse;
    }
}
