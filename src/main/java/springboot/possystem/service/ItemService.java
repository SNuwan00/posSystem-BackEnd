package springboot.possystem.service;

import org.springframework.stereotype.Service;
import springboot.possystem.dto.request.ItemSaveRequestDTO;
import springboot.possystem.dto.response.ItemGetResponseDTO;

import java.util.List;

@Service
public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemGetResponseDTO getItemByName(String itemName);

    List<ItemGetResponseDTO> getAllItems();
}
