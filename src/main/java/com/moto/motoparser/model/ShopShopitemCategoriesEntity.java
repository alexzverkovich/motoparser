package com.moto.motoparser.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shop_shopitem_categories", schema = "moto", catalog = "")
public class ShopShopitemCategoriesEntity {
    private int id;
    private ShopItemEntity shopItem;
    private ShopCategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "shopitem_id", referencedColumnName = "id", nullable = false)
    public ShopItemEntity getShopItem() {
        return shopItem;
    }


    public void setShopItem(ShopItemEntity shopItem) {
        this.shopItem = shopItem;
    }

    @ManyToOne
    @JoinColumn(name = "shopcategory_id", referencedColumnName = "id", nullable = false)
    public ShopCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ShopCategoryEntity category) {
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopShopitemCategoriesEntity that = (ShopShopitemCategoriesEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
