package com.moto.motoparser.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shop_shopitemkind", schema = "moto", catalog = "")
public class ShopItemKindEntity {
    private int id;
    private int order;
    private String avatar;
    private String cropping;
    private String title;
    private String weight;
    private String productSize;
    private Integer quantity;
    private short canBuy;
    private String propertiesDict;
    private Integer oldPrice;
    private int price;
    private String desc;
    private Timestamp created;
    private Timestamp modify;
    private String numberCatalog;
    private ShopItemEntity shopShopitemByItemId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "`order`")
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "cropping")
    public String getCropping() {
        return cropping;
    }

    public void setCropping(String cropping) {
        this.cropping = cropping;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "product_size")
    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "can_buy")
    public short getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(short canBuy) {
        this.canBuy = canBuy;
    }

    @Basic
    @Column(name = "properties_dict")
    public String getPropertiesDict() {
        return propertiesDict;
    }

    public void setPropertiesDict(String propertiesDict) {
        this.propertiesDict = propertiesDict;
    }

    @Basic
    @Column(name = "old_price")
    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "`desc`")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "`modify`")
    public Timestamp getModify() {
        return modify;
    }

    public void setModify(Timestamp modify) {
        this.modify = modify;
    }

    @Basic
    @Column(name = "number_catalog")
    public String getNumberCatalog() {
        return numberCatalog;
    }

    public void setNumberCatalog(String numberCatalog) {
        this.numberCatalog = numberCatalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItemKindEntity that = (ShopItemKindEntity) o;
        return id == that.id &&
                order == that.order &&
                canBuy == that.canBuy &&
                price == that.price &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(cropping, that.cropping) &&
                Objects.equals(title, that.title) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(productSize, that.productSize) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(propertiesDict, that.propertiesDict) &&
                Objects.equals(oldPrice, that.oldPrice) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(created, that.created) &&
                Objects.equals(modify, that.modify) &&
                Objects.equals(numberCatalog, that.numberCatalog);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, order, avatar, cropping, title, weight, productSize, quantity, canBuy, propertiesDict, oldPrice, price, desc, created, modify, numberCatalog);
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    public ShopItemEntity getShopShopitemByItemId() {
        return shopShopitemByItemId;
    }

    public void setShopShopitemByItemId(ShopItemEntity shopShopitemByItemId) {
        this.shopShopitemByItemId = shopShopitemByItemId;
    }
}
