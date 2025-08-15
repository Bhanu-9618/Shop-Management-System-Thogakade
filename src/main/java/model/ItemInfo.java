package model;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class ItemInfo   {

    private String itemCode;
    private String description;
    private String packSize;
    private Double unitPrice;
    private Integer qtyonHand;
}
