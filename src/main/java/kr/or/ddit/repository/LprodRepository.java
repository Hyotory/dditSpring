package kr.or.ddit.repository;

import kr.or.ddit.entity.Lprod;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LprodRepository extends CrudRepository<Lprod,Long> {

    @Override
    ArrayList<Lprod> findAll();
}
