package org.geeksforgeeks.dao;

import org.geeksforgeeks.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<Website, Integer> {
    Website findByname(String name);
}
