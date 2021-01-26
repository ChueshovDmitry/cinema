package com.godeltech.app.service.repository;

import com.godeltech.app.service.entity.Director;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitry Chueshov 26.01.2021 15:06
 * @project application
 */

@Repository
public interface DirectorRepository extends PagingAndSortingRepository<Director,Integer> {


}
