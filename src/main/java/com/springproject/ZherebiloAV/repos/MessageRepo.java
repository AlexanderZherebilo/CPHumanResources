package com.springproject.ZherebiloAV.repos;

import antlr.debug.MessageAdapter;
import com.springproject.ZherebiloAV.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
