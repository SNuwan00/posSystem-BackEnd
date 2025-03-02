package springboot.possystem.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springboot.possystem.dto.paginated.PaginatedResponseItemDTO;
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
    @Autowired
    private ModelMapper modelMapper;

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
    public List<ItemGetResponseDTO> getAllItems(int page, int size) {
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

    @Override
    public PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, int size, boolean activeState) {
        return null;
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsWithPaginated(int page, int size) {
        Page<Item> items = itemRepo.findAll(PageRequest.of(page, size));
        if (items.getSize() < 1)
            throw new RuntimeException("No items found");
        return modelMapper.map(items, PaginatedResponseItemDTO.class);
    }
}
