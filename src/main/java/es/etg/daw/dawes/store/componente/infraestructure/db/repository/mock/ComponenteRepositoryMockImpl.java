package es.etg.daw.dawes.store.componente.infraestructure.db.repository.mock;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.store.componente.domain.model.Componente;
import es.etg.daw.dawes.store.componente.domain.repository.ComponenteRepository;

@RequiredArgsConstructor 
@Repository 
public class ComponenteRepositoryMockImpl implements ComponenteRepository{

    private final Map<Integer, Componente> componentes = ComponenteFactory.getDemoData();

    @Override
    public Componente save(Componente t) {
        if(t.getId()==0)
            t.setId(obtenerSiguienteId());
        componentes.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId(){
        int ultimo = 0;
        if(!componentes.isEmpty()){
            Collection<Componente> lista = componentes.values();
            
            for (Componente p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo+1;
    }

    @Override
    public List<Componente> getAll() {
        return new ArrayList<>(componentes.values());
    }

    @Override
    public Optional<Componente> getById(Integer id) {
        return Optional.ofNullable(componentes.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        componentes.remove(id);
    }

    @Override
    public Optional<Componente> getByName(String name) {
        for (Componente componente : componentes.values()) {
            if(componente.getNombre().equals(name)){
                return Optional.of(componente);
            }
        }
        return Optional.empty();
    }
    
}
