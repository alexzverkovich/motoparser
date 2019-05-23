package com.moto.motoparser.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shop_shopcategory", schema = "moto", catalog = "")
public class ShopCategoryEntity {
    private int id;
    private String title;
    private String slug;
    private int lft;
    private int rght;
    private int treeId;
    private int level;
    private Timestamp created;
    private Timestamp modify;
    private String avatar;
    private String cropping;
    private String preview;
    private String text;
    private String yandexTitle;
    private ShopCategoryEntity parentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "lft")
    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    @Basic
    @Column(name = "rght")
    public int getRght() {
        return rght;
    }

    public void setRght(int rght) {
        this.rght = rght;
    }

    @Basic
    @Column(name = "tree_id")
    public int getTreeId() {
        return treeId;
    }

    public void setTreeId(int treeId) {
        this.treeId = treeId;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    @Basic
    @Column(name = "yandex_title")
    public String getYandexTitle() {
        return yandexTitle;
    }

    public void setYandexTitle(String yandexTitle) {
        this.yandexTitle = yandexTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopCategoryEntity that = (ShopCategoryEntity) o;
        return id == that.id &&
                lft == that.lft &&
                rght == that.rght &&
                treeId == that.treeId &&
                level == that.level &&
                Objects.equals(title, that.title) &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(created, that.created) &&
                Objects.equals(modify, that.modify) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(cropping, that.cropping) &&
                Objects.equals(preview, that.preview) &&
                Objects.equals(text, that.text) &&
                Objects.equals(yandexTitle, that.yandexTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, slug, lft, rght, treeId, level, created, modify, avatar, cropping, preview, text, yandexTitle);
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public ShopCategoryEntity getParentId() {
        return parentId;
    }

    public void setParentId(ShopCategoryEntity shopShopcategoryByParentIdEntity) {
        this.parentId = shopShopcategoryByParentIdEntity;
    }
}
