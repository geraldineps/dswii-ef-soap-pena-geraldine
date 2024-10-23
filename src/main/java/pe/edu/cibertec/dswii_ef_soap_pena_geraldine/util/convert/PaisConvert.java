package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Pais;
import pe.edu.cibertec.ws.objects.Paisws;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaisConvert {

    public Pais mapToPais(Paisws paisws){
        Pais pais = new Pais();
        pais.setId_pais(paisws.getIdPais());
        pais.setNombre(paisws.getNombre());
        return pais;
    }
    public Paisws mapToPaisws(Pais pais){
        Paisws paisws = new Paisws();
        paisws.setIdPais(pais.getId_pais());
        paisws.setNombre(pais.getNombre());
        return paisws;
    }

    public List<Pais> mapToPaisList(List<Paisws> paiswsList){
        List<Pais> paisList = new ArrayList<>();
        for (Paisws paisws : paiswsList){
            paisList.add(mapToPais(paisws));
        }
        return paisList;
    }

    public List<Paisws> mapToPaiswsList(List<Pais> paisList){
        List<Paisws> paiswsList = new ArrayList<>();
        for (Pais pais : paisList){
            paiswsList.add(mapToPaisws(pais));
        }
        return paiswsList;
    }


}
