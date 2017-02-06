package br.com.teste.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.teste.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

}
