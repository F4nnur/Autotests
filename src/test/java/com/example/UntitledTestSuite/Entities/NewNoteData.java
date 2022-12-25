package com.example.UntitledTestSuite.Entities;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class NewNoteData {

    public String new_title;

    public NewNoteData(String new_title) {
        this.new_title = new_title;
    }

    public void setTittle(String tittle) {
        this.new_title = new_title;
    }

    public String getTittle() {
        return new_title;
    }

}

