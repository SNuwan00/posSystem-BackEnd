package springboot.possystem.controller;

import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.possystem.dto.paginated.PaginatedResponseItemDTO;
import springboot.possystem.dto.request.ItemSaveRequestDTO;
import springboot.possystem.dto.response.ItemGetResponseDTO;
import springboot.possystem.service.ItemService;
import springboot.possystem.util.StandardResponse;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        return message;
    }

    @GetMapping(path = "/get-by-name",params = "item_name")
    public ItemGetResponseDTO getItemByName(@RequestParam(value = "item_name")String itemName){
        ItemGetResponseDTO item = itemService.getItemByName(itemName);
        return item;
    }

    @GetMapping(path = "/get-all", params = {"page","size"})
    public List<ItemGetResponseDTO> getAllItem(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
        //List<ItemGetResponseDTO> items = itemService.getAllItems(page, size);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsWithPaginated(page, size);
        return null;
    }

    @GetMapping(
            path = "get-all-active-items-paginated",
                    params = {"page", "size","activeState"}
            )
    public ResponseEntity<StandardResponse> getAllActiveItemsPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeState") boolean activeState
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllActiveItemsPaginated(page, size, activeState);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", paginatedResponseItemDTO),
        HttpStatus.OK
    );
    }

}
