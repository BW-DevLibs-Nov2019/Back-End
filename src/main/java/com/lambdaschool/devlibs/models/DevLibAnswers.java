package com.lambdaschool.devlibs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.devlibs.logging.Loggable;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Loggable
@Entity
@Table(name = "devlibanswers", uniqueConstraints = {@UniqueConstraint(columnNames = {"devlibid", "answerid"})})
@ApiModel(value = "DevLibAnswers",
        description = "Answer for devlibs")
public class DevLibAnswers extends Auditable implements Serializable{


        @Id
        @ManyToOne
        @JoinColumn(name = "devlibid")
        @JsonIgnoreProperties("devlibanswers")
        private DevLib devLib;

        @Id
        @ManyToOne
        @JoinColumn(name = "answerid")
        @JsonIgnoreProperties("devlibanswers")
        private Answers answers;

        public DevLibAnswers()
        {
        }

        public DevLibAnswers(DevLib devLib,
                         Answers answers)
        {
            this.devLib = devLib;
            this.answers = answers;
        }

        public DevLib getDevLibs()
        {
            return devLib;
        }

        public void setDevLibs(DevLib devLibs)
        {
            this.devLib = devLib;
        }

        public Answers getAnswers()
        {
            return answers;
        }

        public void setAnswers(Answers answers)
        {
            this.answers = answers;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (!(o instanceof com.lambdaschool.devlibs.models.UserRoles))
            {
                return false;
            }
            com.lambdaschool.devlibs.models.DevLibAnswers devLibAnswers = (com.lambdaschool.devlibs.models.DevLibAnswers) o;
            return getDevLibs().equals(devLibAnswers.getDevLibs()) && getAnswers().equals(devLibAnswers.getAnswers());
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(getDevLibs(),
                   getAnswers());
        }

    }


