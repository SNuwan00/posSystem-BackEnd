package springboot.possystem.service;

import jakarta.validation.constraints.Max;
import org.springframework.stereotype.Service;
import springboot.possystem.dto.paginated.PaginatedResponseItemDTO;
import springboot.possystem.dto.request.ItemSaveRequestDTO;
import springboot.possystem.dto.response.ItemGetResponseDTO;

import java.util.List;

@Service
public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemGetResponseDTO getItemByName(String itemName);

    List<ItemGetResponseDTO> getAllItems(int page, int size);

    PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, @Max(50) int size, boolean activeState);

    PaginatedResponseItemDTO getAllItemsWithPaginated(int page, @Max(50) int size);
}
