package com.moto.motoparser.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shop_shopitem", schema = "moto", catalog = "")
public class ShopItemEntity {
    private int id;
    private int order;
    private String title;
    private String slug;
    private Timestamp lastChanged;
    private byte published;
    private Timestamp publishedOn;
    private Timestamp publishedOff;
    private byte favorite;
    private byte isNew;
    private String itemKindsLi;
    private Timestamp created;
    private Timestamp modify;
    private String metaKeywords;
    private String metaDescription;
    private String avatar;
    private String cropping;
    private String preview;
    private String text;
    private String yandexTitle;
    private String typePrefix;
    private String vendor;
    private String modelName;
    private String countryOfOrigin;
    private String salesNotes;
    private byte manufacturerWarranty;
    private byte store;
    private byte pickup;
    private byte delivery;
    private String tags;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Basic
    @Column(name = "last_changed")
    public Timestamp getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(Timestamp lastChanged) {
        this.lastChanged = lastChanged;
    }

    @Basic
    @Column(name = "published")
    public byte getPublished() {
        return published;
    }

    public void setPublished(byte published) {
        this.published = published;
    }

    @Basic
    @Column(name = "published_on")
    public Timestamp getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Timestamp publishedOn) {
        this.publishedOn = publishedOn;
    }

    @Basic
    @Column(name = "published_off")
    public Timestamp getPublishedOff() {
        return publishedOff;
    }

    public void setPublishedOff(Timestamp publishedOff) {
        this.publishedOff = publishedOff;
    }

    @Basic
    @Column(name = "favorite")
    public byte getFavorite() {
        return favorite;
    }

    public void setFavorite(byte favorite) {
        this.favorite = favorite;
    }

    @Basic
    @Column(name = "is_new")
    public byte getIsNew() {
        return isNew;
    }

    public void setIsNew(byte isNew) {
        this.isNew = isNew;
    }

    @Basic
    @Column(name = "item_kinds_li")
    public String getItemKindsLi() {
        return itemKindsLi;
    }

    public void setItemKindsLi(String itemKindsLi) {
        this.itemKindsLi = itemKindsLi;
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
    @Column(name = "meta_keywords")
    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    @Basic
    @Column(name = "meta_description")
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
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
    @Column(name = "preview")
    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "yandex_title")
    public String getYandexTitle() {
        return yandexTitle;
    }

    public void setYandexTitle(String yandexTitle) {
        this.yandexTitle = yandexTitle;
    }

    @Basic
    @Column(name = "typePrefix")
    public String getTypePrefix() {
        return typePrefix;
    }

    public void setTypePrefix(String typePrefix) {
        this.typePrefix = typePrefix;
    }

    @Basic
    @Column(name = "vendor")
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "model_name")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "country_of_origin")
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Basic
    @Column(name = "sales_notes")
    public String getSalesNotes() {
        return salesNotes;
    }

    public void setSalesNotes(String salesNotes) {
        this.salesNotes = salesNotes;
    }

    @Basic
    @Column(name = "manufacturer_warranty")
    public byte getManufacturerWarranty() {
        return manufacturerWarranty;
    }

    public void setManufacturerWarranty(byte manufacturerWarranty) {
        this.manufacturerWarranty = manufacturerWarranty;
    }

    @Basic
    @Column(name = "store")
    public byte getStore() {
        return store;
    }

    public void setStore(byte store) {
        this.store = store;
    }

    @Basic
    @Column(name = "pickup")
    public byte getPickup() {
        return pickup;
    }

    public void setPickup(byte pickup) {
        this.pickup = pickup;
    }

    @Basic
    @Column(name = "delivery")
    public byte getDelivery() {
        return delivery;
    }

    public void setDelivery(byte delivery) {
        this.delivery = delivery;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItemEntity that = (ShopItemEntity) o;
        return id == that.id &&
                order == that.order &&
                published == that.published &&
                favorite == that.favorite &&
                isNew == that.isNew &&
                manufacturerWarranty == that.manufacturerWarranty &&
                store == that.store &&
                pickup == that.pickup &&
                delivery == that.delivery &&
                Objects.equals(title, that.title) &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(lastChanged, that.lastChanged) &&
                Objects.equals(publishedOn, that.publishedOn) &&
                Objects.equals(publishedOff, that.publishedOff) &&
                Objects.equals(itemKindsLi, that.itemKindsLi) &&
                Objects.equals(created, that.created) &&
                Objects.equals(modify, that.modify) &&
                Objects.equals(metaKeywords, that.metaKeywords) &&
                Objects.equals(metaDescription, that.metaDescription) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(cropping, that.cropping) &&
                Objects.equals(preview, that.preview) &&
                Objects.equals(text, that.text) &&
                Objects.equals(yandexTitle, that.yandexTitle) &&
                Objects.equals(typePrefix, that.typePrefix) &&
                Objects.equals(vendor, that.vendor) &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(countryOfOrigin, that.countryOfOrigin) &&
                Objects.equals(salesNotes, that.salesNotes) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, order, title, slug, lastChanged, published, publishedOn, publishedOff, favorite, isNew, itemKindsLi, created, modify, metaKeywords, metaDescription, avatar, cropping, preview, text, yandexTitle, typePrefix, vendor, modelName, countryOfOrigin, salesNotes, manufacturerWarranty, store, pickup, delivery, tags);
    }
}
