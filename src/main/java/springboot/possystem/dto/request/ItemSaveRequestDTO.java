package springboot.possystem.dto.request;

import springboot.possystem.entity.enums.MeasuringUnitType;

public class ItemSaveRequestDTO {
    private String itemName;
    private MeasuringUnitType measureUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

    public ItemSaveRequestDTO() {
    }

    public ItemSaveRequestDTO(String itemName, MeasuringUnitType measureUnit, double balanceQty, double supplierPrice, double sellingPrice) {
        this.itemName = itemName;
        this.measureUnit = measureUnit;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MeasuringUnitType getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasuringUnitType measureUnit) {
        this.measureUnit = measureUnit;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
