package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Hotel;
import pe.edu.cibertec.ws.objects.Hotelws;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelConvert {
    
    public Hotel mapToHotel(Hotelws hotelws){
    Hotel hotel = new Hotel();
    hotel.setId_hotel(hotelws.getIdHotel());
    hotel.setNombre(hotelws.getNombre());
    hotel.setDireccion(hotelws.getDireccion());
    hotel.setCiudad(hotelws.getCiudad());
    hotel.setId_pais(hotelws.getIdPais());
    return hotel;
}
    public Hotelws mapToHotelws(Hotel hotel){
        Hotelws hotelws = new Hotelws();
        hotelws.setIdHotel(hotel.getId_hotel());
        hotelws.setNombre(hotel.getNombre());
        hotelws.setDireccion(hotel.getDireccion());
        hotelws.setCiudad(hotel.getCiudad());
        hotelws.setIdPais(hotel.getId_pais());
        return hotelws;
    }

    public List<Hotel> mapToHotelList(List<Hotelws> hotelwsList){
        List<Hotel> hotelList = new ArrayList<>();
        for (Hotelws hotelws : hotelwsList){
            hotelList.add(mapToHotel(hotelws));
        }
        return hotelList;
    }

    public List<Hotelws> mapToHotelwsList(List<Hotel> hotelList){
        List<Hotelws> hotelwsList = new ArrayList<>();
        for (Hotel hotel : hotelList){
            hotelwsList.add(mapToHotelws(hotel));
        }
        return hotelwsList;
    }
}
