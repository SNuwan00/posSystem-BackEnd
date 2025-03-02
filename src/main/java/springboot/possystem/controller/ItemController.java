package springboot.possystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.possystem.dto.request.ItemSaveRequestDTO;
import springboot.possystem.dto.response.ItemGetResponseDTO;
import springboot.possystem.service.ItemService;

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
    @GetMapping(path = "/get-all")
    public List<ItemGetResponseDTO> getAllItem(){
        List<ItemGetResponseDTO> items = itemService.getAllItems();
        return items;
    }
}
