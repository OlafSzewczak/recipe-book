package pl.oszewczak.recipebook.repository;

import org.springframework.data.repository.CrudRepository;
import pl.oszewczak.recipebook.model.Unit;

public interface UnitRepository extends CrudRepository<Unit, Long> {

}
