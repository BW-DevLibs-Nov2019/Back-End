package com.lambdaschool.devlibs.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.devlibs.logging.Loggable;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

/*each user will have a user name, password, id, and an array of objects, each object is going to have a title, id and a paragraph.*/
@Loggable
@Entity
@Table(name = "devlibs")
@ApiModel(value = "DevLib",
        description = "Controls Dev-Libs Actions")
public class DevLib extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            private Long devlibid;

////////////key///////////////
    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties("userid")
    private DevLib devLib;
    ///////////key///////////////


    @Column(nullable = true)
    private String paragraph;
    private String devlibtitle;

    public DevLib(String paragraph, String devlibtitle) {
        this.paragraph = paragraph;
        this.devlibtitle = devlibtitle;
    }

    public Long getDevlibid() {
        return devlibid;
    }

    public void setDevlibid(Long devlibid) {
        this.devlibid = devlibid;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getDevlibtitle() {
        return devlibtitle;
    }

    public void setDevlibtitle(String devlibtitle) {
        this.devlibtitle = devlibtitle;
    }

    DevLib(){}
}
