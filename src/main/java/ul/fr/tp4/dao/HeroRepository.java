package ul.fr.tp4.dao;

import org.springframework.data.repository.CrudRepository;
import ul.fr.tp4.model.Hero;

import java.util.Collection;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

    Hero findById(int id);
    Collection<Hero> findByName(String name);
    void deleteById(int id);
    Collection<Hero> findAll();

}
