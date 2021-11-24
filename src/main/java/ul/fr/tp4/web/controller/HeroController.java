package ul.fr.tp4.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ul.fr.tp4.dao.HeroRepository;
import ul.fr.tp4.model.Hero;

import java.util.Collection;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {
    private HeroRepository dao;

    @Autowired
    public HeroController(HeroRepository heroRepository){
        this.dao = heroRepository;
    }

    @GetMapping(value="/heroes/{id}")
    public Hero getHero(@PathVariable int id) {
        return dao.findById(id);
    }
    @GetMapping(value="/heroes/name/{name}")
    public Collection<Hero> getHeroName(@PathVariable String name) {
        return dao.findByName(name);
    }


    @GetMapping(value="/heroes")
    public Collection<Hero> getHeroes() {
        return dao.findAll();
    }

    @DeleteMapping(value = "/heroes/{id}")
    public void deleteHero(@PathVariable int id){
        dao.deleteById(id);
    }

    @PostMapping(value = "/heroes")
    public Hero postHero(@RequestBody Hero hero){
       return dao.save(hero);
    }


    @PutMapping(value = "/heroes/{id}")
    public Hero putHero(@PathVariable int id, @RequestBody Hero hero){

        Logger log = LoggerFactory.getLogger("");
        if(dao.existsById(id)){
            hero.setId(id);
            return dao.save(hero);
        }else{
            log.info("error id ");
            return null;
        }
    }

}
