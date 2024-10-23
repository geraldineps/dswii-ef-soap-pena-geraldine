package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.impl;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.exception.NotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Pais;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.model.Pais;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.repository.PaisRepository;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.service.IPaisService;
import pe.edu.cibertec.dswii_ef_soap_pena_geraldine.util.convert.PaisConvert;
import pe.edu.cibertec.ws.objects.*;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaisService implements IPaisService {

    private final PaisRepository paisRepository;
    private final PaisConvert paisConvert;


    @Override
    public GetPaisesResponse listarPaises() {
        GetPaisesResponse getPaissResponse = new GetPaisesResponse();
        getPaissResponse.getPaises().addAll(
                paisConvert.mapToPaiswsList(paisRepository.findAll())
        );
        return getPaissResponse;
    }

    @Override
    public GetPaisResponse obtenerPaisxId(Integer id) {
        GetPaisResponse paisResponse = new GetPaisResponse();
        Pais pais = paisRepository.findById(id).orElse(null);
        if(pais == null){
            throw  new NotFoundException("El pais con ID "+ id+" no existe.");
        }
        paisResponse.setPais(
                paisConvert.mapToPaisws(pais));
        return paisResponse;
    }

    @Override
    public PostPaisResponse registrarPais(PostPaisRequest request) {
        PostPaisResponse postPaisResponse = new PostPaisResponse();
        Pais nuevoPais = paisRepository.save(
                paisConvert.mapToPais(request.getPais())
        );
        postPaisResponse.setPais(
                paisConvert.mapToPaisws(nuevoPais));
        return postPaisResponse;
    }

    @Override
    public PutPaisResponse actualizarPais(PutPaisRequest request) {
        PutPaisResponse putPaisResponse = new PutPaisResponse();

        // Busca el pais por ID
        Optional<Pais> pais = paisRepository.findById(request.getPais().getIdPais());

        if (pais.isEmpty()) {
            throw new NotFoundException("Pais con el ID: " + request.getPais().getIdPais() + " no existe");
        }
        // Mapea los datos del request al pais existente
        Pais paisActualizado = paisConvert.mapToPais(request.getPais());
        paisActualizado.setId_pais(pais.get().getId_pais()); // asegura que el ID no cambie

        // Actualiza el pais en la base de datos
        Pais paisGuardado = paisRepository.save(paisActualizado);

        // Convierte el pais actualizado para la respuesta
        putPaisResponse.setPais(
                paisConvert.mapToPaisws(paisGuardado)
        );

        return putPaisResponse;
    }


}
