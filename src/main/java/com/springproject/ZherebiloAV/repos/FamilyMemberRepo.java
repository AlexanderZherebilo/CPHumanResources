package com.springproject.ZherebiloAV.repos;

import com.springproject.ZherebiloAV.domain.FamilyMember;
import org.springframework.data.repository.CrudRepository;

public interface FamilyMemberRepo extends CrudRepository<FamilyMember, Long> {
    FamilyMember findById(Integer id);
}
