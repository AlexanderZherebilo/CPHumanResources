package com.springproject.ZherebiloAV.repos;

import com.springproject.ZherebiloAV.domain.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepo extends CrudRepository<Position, Long> {
    Position findById(Integer id);
}
