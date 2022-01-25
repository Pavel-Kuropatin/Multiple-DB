package com.kuropatin.mdb.repository.first;

import com.kuropatin.mdb.model.first.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}