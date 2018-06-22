package com.test.articles.business.cloudant.article;

import com.test.articles.business.cloudant.CloudantModel;

import java.util.Objects;

public class ArticleModel extends CloudantModel {

    private String title;
    private String text;
    private String publisher;
    private String editor;
    private String datePublished;
    private String dateEdited;

    public ArticleModel() {
    }

    public ArticleModel(Boolean isDeleted,
                        String title,
                        String text,
                        String publisher,
                        String editor,
                        String datePublished,
                        String dateEdited) {
        super(isDeleted);
        this.title = title;
        this.text = text;
        this.publisher = publisher;
        this.editor = editor;
        this.datePublished = datePublished;
        this.dateEdited = dateEdited;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleModel that = (ArticleModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(text, that.text) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(datePublished, that.datePublished) &&
                Objects.equals(dateEdited, that.dateEdited);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, text, publisher, editor, datePublished, dateEdited);
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "id='"  + super.getId() + '\'' +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", publisher='" + publisher + '\'' +
                ", editor='" + editor + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", dateEdited='" + dateEdited + '\'' +
                '}';
    }
}
