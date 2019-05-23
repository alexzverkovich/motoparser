package com.moto.motoparser.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shop_shoppromoitem", schema = "moto", catalog = "")
public class ShopPromoItemEntity {
    private int id;
    private int order;
    private String title;
    private String slug;
    private byte published;
    private Timestamp publishedOn;
    private String productsIds;
    private int factor;
    private byte isFixed;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private String days;
    private Short hourStart;
    private Short minuteStart;
    private Short hourEnd;
    private Short minuteEnd;
    private Timestamp created;
    private Timestamp modify;
    private String avatar;
    private String cropping;
    private String preview;
    private String text;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order")
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
    @Column(name = "products_ids")
    public String getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(String productsIds) {
        this.productsIds = productsIds;
    }

    @Basic
    @Column(name = "factor")
    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    @Basic
    @Column(name = "is_fixed")
    public byte getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(byte isFixed) {
        this.isFixed = isFixed;
    }

    @Basic
    @Column(name = "date_start")
    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_end")
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "days")
    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Basic
    @Column(name = "hour_start")
    public Short getHourStart() {
        return hourStart;
    }

    public void setHourStart(Short hourStart) {
        this.hourStart = hourStart;
    }

    @Basic
    @Column(name = "minute_start")
    public Short getMinuteStart() {
        return minuteStart;
    }

    public void setMinuteStart(Short minuteStart) {
        this.minuteStart = minuteStart;
    }

    @Basic
    @Column(name = "hour_end")
    public Short getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Short hourEnd) {
        this.hourEnd = hourEnd;
    }

    @Basic
    @Column(name = "minute_end")
    public Short getMinuteEnd() {
        return minuteEnd;
    }

    public void setMinuteEnd(Short minuteEnd) {
        this.minuteEnd = minuteEnd;
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
    @Column(name = "modify")
    public Timestamp getModify() {
        return modify;
    }

    public void setModify(Timestamp modify) {
        this.modify = modify;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopPromoItemEntity that = (ShopPromoItemEntity) o;
        return id == that.id &&
                order == that.order &&
                published == that.published &&
                factor == that.factor &&
                isFixed == that.isFixed &&
                Objects.equals(title, that.title) &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(publishedOn, that.publishedOn) &&
                Objects.equals(productsIds, that.productsIds) &&
                Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(dateEnd, that.dateEnd) &&
                Objects.equals(days, that.days) &&
                Objects.equals(hourStart, that.hourStart) &&
                Objects.equals(minuteStart, that.minuteStart) &&
                Objects.equals(hourEnd, that.hourEnd) &&
                Objects.equals(minuteEnd, that.minuteEnd) &&
                Objects.equals(created, that.created) &&
                Objects.equals(modify, that.modify) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(cropping, that.cropping) &&
                Objects.equals(preview, that.preview) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, order, title, slug, published, publishedOn, productsIds, factor, isFixed, dateStart, dateEnd, days, hourStart, minuteStart, hourEnd, minuteEnd, created, modify, avatar, cropping, preview, text);
    }
}
