package springboot.possystem.entity;

import jakarta.persistence.*;
import springboot.possystem.entity.enums.MeasuringUnitType;


@Entity
@Table(name = "items")
@Access(AccessType.FIELD)
public class Item {
    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 100, nullable = false)
    private MeasuringUnitType measureUnit;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 100, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", length = 100, nullable = false)
    private boolean activeState;

    public Item(String itemName, MeasuringUnitType measureUnit, double balanceQty, double supplierPrice, double sellingPrice, boolean activeState) {
        this.itemName = itemName;
        this.measureUnit = measureUnit;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
    }

    public Item() {

    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public MeasuringUnitType getMeasureUnit() {
        return measureUnit;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public boolean isActiveState() {
        return activeState;
    }
}
