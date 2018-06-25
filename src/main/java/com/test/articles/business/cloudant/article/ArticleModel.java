package com.test.articles.business.cloudant.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleModel{

    @JsonIgnore
    @SerializedName("_id")
    private String id;

//    @JsonIgnore
    @SerializedName("_rev")
    private String rev;

    private String uuid;

    @NotNull
    @Size(min = 5)
    private String title;

    @NotNull
    @Size(min = 5)
    private String text;

    @Email
    private String publisher;

    @Email
    private String editor;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String datePublished;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String dateEdited;

    private Boolean isDeleted;

    public ArticleModel() {
    }

    public ArticleModel(String id,
                        String rev,
                        String uuid,
                        String title,
                        String text,
                        String publisher,
                        String editor,
                        String datePublished,
                        String dateEdited,
                        Boolean isDeleted) {
        this.id = id;
        this.rev = rev;
        this.uuid = uuid;
        this.title = title;
        this.text = text;
        this.publisher = publisher;
        this.editor = editor;
        this.datePublished = datePublished;
        this.dateEdited = dateEdited;
        this.isDeleted = isDeleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(String dateEdited) {
        this.dateEdited = dateEdited;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleModel that = (ArticleModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rev, that.rev) &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(text, that.text) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(datePublished, that.datePublished) &&
                Objects.equals(dateEdited, that.dateEdited) &&
                Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rev, uuid, title, text, publisher, editor, datePublished, dateEdited, isDeleted);
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "id='" + id + '\'' +
                ", rev='" + rev + '\'' +
                ", uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", publisher='" + publisher + '\'' +
                ", editor='" + editor + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", dateEdited='" + dateEdited + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
