package springboot.possystem.dto.paginated;

import springboot.possystem.dto.response.ItemGetResponseDTO;

import java.util.List;

public class PaginatedResponseItemDTO {
    List<ItemGetResponseDTO> items;
    private long totalItems;

    public List<ItemGetResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemGetResponseDTO> items) {
        this.items = items;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public PaginatedResponseItemDTO(List<ItemGetResponseDTO> items, long totalItems) {
        this.items = items;
        this.totalItems = totalItems;
    }

    public PaginatedResponseItemDTO() {
    }
}
