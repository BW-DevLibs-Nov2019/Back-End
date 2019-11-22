package com.lambdaschool.devlibs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.devlibs.logging.Loggable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Loggable
@Entity
@Table(name = "devlibanswers")
@ApiModel(value = "DevLibAnswers",
        description = "Answer for devlibs")
public class DevLibAnswers extends Auditable implements Serializable {


    @ApiModelProperty(name = "DevLib ID",
            value = "ID for DevLib",
            required = true,
            example = "1")
    @Id
    @ManyToOne
    @JoinColumn(name = "devlibid")
    @JsonIgnoreProperties("devlibanswers")
    private DevLib devLib;

    @ApiModelProperty(name = "answer ID",
            value = "Answer ID",
            example = "1")
    @Id
    @ManyToOne
    @JoinColumn(name = "answerid")
    @JsonIgnoreProperties("devlibanswers")
    private Answers answers;

    public DevLibAnswers() {
    }

    public DevLibAnswers(DevLib devLib,
                         Answers answers) {
        this.devLib = devLib;
        this.answers = answers;
    }

    public DevLib getDevLibs() {
        return devLib;
    }

    public void setDevLibs(DevLib devLibs) {
        this.devLib = devLib;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof com.lambdaschool.devlibs.models.UserRoles)) {
            return false;
        }
        com.lambdaschool.devlibs.models.DevLibAnswers devLibAnswers = (com.lambdaschool.devlibs.models.DevLibAnswers) o;
        return getDevLibs().equals(devLibAnswers.getDevLibs()) && getAnswers().equals(devLibAnswers.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDevLibs(),
                getAnswers());
    }

}


