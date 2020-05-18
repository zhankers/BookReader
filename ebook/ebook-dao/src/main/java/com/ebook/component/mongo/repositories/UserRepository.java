package com.ibook.component.mongo.repositories;

import com.ibook.component.mongo.repositories.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-08-25 18:03
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
