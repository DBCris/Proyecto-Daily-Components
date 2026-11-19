package es.etg.daw.dawes.store.ordenador.infraestructure.db.repository.mock;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.store.ordenador.domain.model.Ordenador;
import es.etg.daw.dawes.store.ordenador.domain.repository.OrdenadorRepository;

@RequiredArgsConstructor 
@Repository 
public class OrdenadorRepositoryMockImpl implements OrdenadorRepository{

    private final Map<Integer, Ordenador> ordenadores = OrdenadorFactory.getDemoData();

    @Override
    public Ordenador save(Ordenador t) {
        if(t.getId()==0)
            t.setId(obtenerSiguienteId());
        ordenadores.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId(){
        int ultimo = 0;
        if(!ordenadores.isEmpty()){
            Collection<Ordenador> lista = ordenadores.values();
            
            for (Ordenador p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo+1;
    }

    @Override
    public List<Ordenador> getAll() {
        return new ArrayList<>(ordenadores.values());
    }

    @Override
    public Optional<Ordenador> getById(Integer id) {
        return Optional.ofNullable(ordenadores.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        ordenadores.remove(id);
    }

    @Override
    public Optional<Ordenador> getByName(String name) {
        for (Ordenador ordenador : ordenadores.values()) {
            if(ordenador.getNombre().equals(name)){
                return Optional.of(ordenador);
            }
        }
        return Optional.empty();
    }
    
}
