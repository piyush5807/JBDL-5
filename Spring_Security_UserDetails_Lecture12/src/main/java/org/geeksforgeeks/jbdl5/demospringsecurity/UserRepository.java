package org.geeksforgeeks.jbdl5.demospringsecurity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    public List<MyUser> findByname(String name);
}
