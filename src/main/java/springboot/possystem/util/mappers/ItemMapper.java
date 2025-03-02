package springboot.possystem.util.mappers;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import springboot.possystem.dto.request.ItemSaveRequestDTO;
import springboot.possystem.dto.response.ItemGetResponseDTO;
import springboot.possystem.entity.Item;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
    ItemGetResponseDTO entityToDto(Item item);
    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);
    List<ItemGetResponseDTO> listDTOToPage(Page<Item> items);
}
