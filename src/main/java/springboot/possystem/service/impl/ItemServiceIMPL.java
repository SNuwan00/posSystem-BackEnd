package springboot.possystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.possystem.dto.request.ItemSaveRequestDTO;
import springboot.possystem.dto.response.ItemGetResponseDTO;
import springboot.possystem.entity.Item;
import springboot.possystem.repo.ItemRepo;
import springboot.possystem.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = new Item(
                itemSaveRequestDTO.getItemName(),
                itemSaveRequestDTO.getMeasureUnit(),
                itemSaveRequestDTO.getBalanceQty(),
                itemSaveRequestDTO.getSupplierPrice(),
                itemSaveRequestDTO.getSellingPrice(),
                true
        );
        itemRepo.save(item);
        return "Item saved successfully";
    }

    @Override
    public ItemGetResponseDTO getItemByName(String itemName) {
        Item item = itemRepo.findItemByItemName(itemName);
        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO(
                item.getItemId(),
                item.getItemName(),
                item.getBalanceQty(),
                item.getSupplierPrice(),
                item.getSellingPrice(),
                item.isActiveState()
        );
        return itemGetResponseDTO;
    }

    @Override
    public List<ItemGetResponseDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();
        List<ItemGetResponseDTO> itemGetResponseDTOs = new ArrayList<>();
        for (Item item : items) {
            ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO(
                    item.getItemId(),
                    item.getItemName(),
                    item.getBalanceQty(),
                    item.getSupplierPrice(),
                    item.getSellingPrice(),
                    item.isActiveState()
            );
            itemGetResponseDTOs.add(itemGetResponseDTO);
        }
        return itemGetResponseDTOs;
    }
}
