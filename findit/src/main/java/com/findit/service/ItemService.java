
package com.findit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.findit.entity.Item;
import com.findit.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            return null;
        }

        existingItem.setItemName(item.getItemName());
        existingItem.setCategory(item.getCategory());
        existingItem.setDescription(item.getDescription());
        existingItem.setLocation(item.getLocation());
        existingItem.setDate(item.getDate());
        existingItem.setType(item.getType());
        existingItem.setStatus(item.getStatus());

        return itemRepository.save(existingItem);
    }

    public boolean deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);
        return true;
    }
}
