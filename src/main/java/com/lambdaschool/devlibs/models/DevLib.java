package com.lambdaschool.devlibs.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.devlibs.logging.Loggable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*each user will have a user name, password, id, and an array of objects, each object is going to have a title, id and a paragraph.*/
@Loggable
@Entity
@Table(name = "devlibs")
@ApiModel(value = "DevLib",
        description = "Controls Dev-Libs Actions")
public class DevLib extends Auditable {

    @ApiModelProperty(name = "Story",
            value = "A wonderful DevLibs Story",
            example = "Mary had a little lambda")
    private String story;

    @Transient
    List<String> answerstrings = new ArrayList<>();

    @ApiModelProperty(name = "DevLib id",
            value = "ID for DevLib",
            required = true,
            example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long devlibid;

    ////////////key///////////////
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties("devlibs")
    @JsonIgnore
    private User user;
    ///////////key///////////////

    @OneToMany(mappedBy = "devLib",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("devLib")
    @JsonIgnore
    private List<DevLibAnswers> devLibAnswers = new ArrayList<>();


    @Column(nullable = true)
    private String devlibtitle;
    private String paragraph;


    public DevLib(String story, User user, List<DevLibAnswers> devLibAnswers, String devlibtitle, String paragraph) {
        this.story = story;
        this.user = user;
        this.devLibAnswers = devLibAnswers;
        this.devlibtitle = devlibtitle;
        this.paragraph = paragraph;
    }

    public List<String> getAnswerstrings() {
        return answerstrings;
    }

    public void setAnswerstrings(List<String> answerstrings) {
        this.answerstrings = answerstrings;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<DevLibAnswers> getDevLibAnswers() {
        return devLibAnswers;
    }

    public void setDevLibAnswers(List<DevLibAnswers> devLibAnswers) {
        this.devLibAnswers = devLibAnswers;
    }

    public Long getDevlibid() {
        return devlibid;
    }

    public void setDevlibid(Long devlibid) {
        this.devlibid = devlibid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public DevLib() {
    }
}
