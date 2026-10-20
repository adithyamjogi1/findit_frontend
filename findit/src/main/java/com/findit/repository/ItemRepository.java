
package com.findit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.findit.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
