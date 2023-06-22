package com.example.picturegramm.repository;

import com.example.picturegramm.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Long> {
}
